/*
 * 1293. Shortest Path in a Grid with Obstacles Elimination
Hard
You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0
 */
package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T1293 {
    public static int shortestPath_false(int[][] grid, int k) {
    	//这个方法有问题,相当于K是不同路径共用了
        int lenR = grid.length;
        int lenC = grid[0].length;
        if(lenR==1&&lenC==1) {
        	return 0;
        }
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0,0});
        grid[0][0]=4;//4 for visited
        int[][] directions = {{1,0},{0,1},{-1,0},{-1,0}};
        int result=0;
        while(!qu.isEmpty()) {
        	result++;
        	int size = qu.size();
        	for(int i=0;i<size;i++) {
        		int[] curP = qu.poll();
        		int r = curP[0];
        		int c = curP[1];
        		for(int[] dir: directions) {
        			int nextR = r+dir[0];
        			int nextC = c+dir[1];
        			if(nextR==lenR-1&&nextC==lenC-1) {
        				return result;
        			}
        			if(nextR>=0&&nextR<lenR&&nextC>=0&&nextC<lenC&&grid[nextR][nextC]!=4) {
        				if(grid[nextR][nextC]==0) {
        					grid[nextR][nextC]=4;
        					qu.add(new int[] {nextR,nextC});
        				}else if(grid[nextR][nextC]==1&&k>0) {
        					grid[nextR][nextC]=4;
        					qu.add(new int[] {nextR,nextC});
        					k--;
        				}
        			}
        		}
        	}
        }
        return -1;
    }
    public static int shortestPath_false2(int[][] grid, int k) {
    	 //这道题不应根据某个点是否访问过来判断是不是应该入队,因为搞不搞障碍是不同的路线,都可能经过同一个点
    	//记录到达某个点,需要搞多少个障碍,用来和K对比
    	int lenR = grid.length;
        int lenC = grid[0].length;
        if(lenR==1&&lenC==1) {
        	return 0;
        }

        Queue<int[]> qu = new LinkedList<>();
      //这道题不应根据某个点是否访问过来判断是不是应该入队,因为搞不搞障碍是不同的路线,都可能经过同一个点
        int[][] visited = new int[lenR][lenC];
        visited[0][0]=1;
        qu.add(new int[] {0,0,0});//row, col, numbers of obstacle
        int[][] directions = {{1,0},{0,1},{-1,0},{-1,0}};
        int result=0;
        while(!qu.isEmpty()) {
        	result++;
        	int size = qu.size();
        	for(int i=0;i<size;i++) {
        		int[] curP = qu.poll();
        		int r = curP[0];
        		int c = curP[1];
        		int o = curP[2];
        		for(int[] dir: directions) {
        			int nextR = r+dir[0];
        			int nextC = c+dir[1];
        			if(nextR==lenR-1&&nextC==lenC-1) {
        				return result;
        			}
        			if(nextR>=0&&nextR<lenR&&nextC>=0&&nextC<lenC&&visited[nextR][nextC]==0) {
        				
        				if(grid[nextR][nextC]==1&&o<k) {      					
        					o++;    
        					visited[nextR][nextC]=1;
        					qu.add(new int[] {nextR,nextC,o});
        				}else if(grid[nextR][nextC]==0) {
        					visited[nextR][nextC]=1;
        					qu.add(new int[] {nextR,nextC,o});
        				}
        				
        			}
        		}
        			
        	}
        }
        return -1;
    }
    public static int shortestPath(int[][] grid, int k) {

    	//记录到达某个点,需要搞多少个障碍,用来和K对比
    	int lenR = grid.length;
        int lenC = grid[0].length;
        if(lenR==1&&lenC==1) {
        	return 0;
        }
        /*
        用来判断入队的方法,不是是否访问过,而是这条路,是否有更少的搞障碍的情况.
        例如. {1,1,1}. {1,1,2}, 那么同样是来到了{1,1}这个点,我就不用经过两个障碍的这个入队了,
        假设后面都没有障碍,那么两条路的后续,实际可以打到同样效果,所以,1,1,2不会比1,1,1好
        注意理解BFS是一圈一圈的扩展的,同一次扩展,到同一个点,前面步数一样, 之后扩展,到同一个点,前面步数肯定更多(常见的需要visited的原因),
        同样是没有必要再把这样一个点,且障碍多的放进去
        BFS,第一次来,到达的点,肯定是步数最少的
        */
      //这个是用来记录到达某个点,最低的障碍数,也就是说某条路到这里时候,用最少的障碍,再从这个点出发, 初始化为正无穷
        int[][] minObs = new int[lenR][lenC];
        for(int i=0;i<lenR;i++) {
        	Arrays.fill(minObs[i], Integer.MAX_VALUE);
        }
        minObs[0][0]=0;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0,0,0});//row, col, numbers of obstacle
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        int result=0;
        while(!qu.isEmpty()) {
        	result++;
        	int size = qu.size();
        	for(int i=0;i<size;i++) {
        		int[] curP = qu.poll();
        		int r = curP[0];
        		int c = curP[1];
        		int o = curP[2];
        		for(int[] dir: directions) {
        			int nextR = r+dir[0];
        			int nextC = c+dir[1];
        			if(nextR==lenR-1&&nextC==lenC-1) {
        				return result;
        			}
        			if(nextR>=0&&nextR<lenR&&nextC>=0&&nextC<lenC) {
        				int nextO = o+grid[nextR][nextC];
        				if(nextO<minObs[nextR][nextC]&&nextO<=k) {
        					minObs[nextR][nextC]=nextO;
        					qu.add(new int[] {nextR,nextC,nextO});
        				}
        				
        			}
        		}
        			
        	}
        }
        return -1;
    }
    public static int shortestPath_noCut(int[][] grid, int k) {
    	//试一下不剪枝,不剪枝其实也可以,因为是扩撒找路,最多就是找更多无用的点
    	int lenR = grid.length;
        int lenC = grid[0].length;
        if(lenR==1&&lenC==1) {
        	return 0;
        }

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0,0,0});//row, col, numbers of obstacle
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        int result=0;
        while(!qu.isEmpty()) {
        	result++;
        	int size = qu.size();
        	for(int i=0;i<size;i++) {
        		int[] curP = qu.poll();
        		int r = curP[0];
        		int c = curP[1];
        		int o = curP[2];
        		for(int[] dir: directions) {
        			int nextR = r+dir[0];
        			int nextC = c+dir[1];
        			if(nextR==lenR-1&&nextC==lenC-1) {
        				return result;
        			}
        			if(nextR>=0&&nextR<lenR&&nextC>=0&&nextC<lenC) {
        				int nextO = o+grid[nextR][nextC];
        				if(nextO<=k) {
        					qu.add(new int[] {nextR,nextC,nextO});
        				}
        				
        			}
        		}
        			
        	}
        }
        return -1;
    	
    }
    public static void main(String[] args) {
    	int[][] g1= {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}; int k1 = 1;
    	int[][] g2= {{0,1,1},{1,1,1},{1,0,0}}; int k2 = 1;
    	int[][] g3= {{0}};int k3 =1;
    	int[][] g4= {{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},
    			{0,1,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},
    			{0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,0,0,0,0,0,0,1,0}};int k4 =1;
    	int[][] g5 = {{0,1,1,0}}; int k5=1;
    	int[][] g6 =
    		   {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    	int k6=5;
    	
    	
    	int[][] grid=g6;int k=k6;
    	System.out.println(shortestPath(grid,  k));
    }
}
