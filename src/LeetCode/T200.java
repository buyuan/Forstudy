/*
 * 200. Number of Islands
Medium

Given an m x n 2D binary grid grid which represents a 
map of '1's (land) and '0's (water), return the number 
of islands.

An island is surrounded by water and is formed by 
connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all 
 surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
Accepted
1,455,142
Submissions
2,728,479
 */
package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class T200 {
    public static int numIslands_DFS(char[][] grid) {
    	//DFS就是从这个点出发一直走到走不下去,找到一个陆地,岛+1. 遍历过程中,把陆地置为0,直到下次循环发现一块新的陆地
    	if(grid==null||grid.length==0) {
    		//nothing there
    		return 0;
    	}
    	int rL = grid.length;
    	int cL = grid[0].length;
    	int result=0;
    	for(int r=0;r<rL;r++) {
    		for(int c=0;c<cL;c++) {
    			if(grid[r][c]=='1') {
    				result++;
    				dfs(grid,r,c);
    			}
    		}
    	}
    	return result;
    }

	private static void dfs(char[][] grid, int r, int c) {
		// TODO Auto-generated method stub
    	int cL = grid[0].length;
    	int rL = grid.length;
		if(c<0||c>=cL||r<0||r>=rL||grid[r][c]=='0') {
			return ;
		}
		grid[r][c]='0';
		dfs(grid,r-1,c);
		dfs(grid,r+1,c);
		dfs(grid,r,c-1);
		dfs(grid,r,c+1);
	}
	public static int numIslands_BFS(char[][] grid) {
		//就是找到一个1,然后把周围的1入队
		if(grid==null||grid.length==0) {
    		//nothing there
    		return 0;
    	}
		int rL = grid.length;
		int cL = grid[0].length;
		int result=0;
		Queue<Integer> qu = new LinkedList<Integer>();
    	for(int r=0;r<rL;r++) {
    		for(int c=0;c<cL;c++) {
    			if(grid[r][c]=='1') {
    				//Queue<Integer> qu = new LinkedList<Integer>();
    				qu.add(r*cL+c);//这个算是一种编码方式, 这个值除以cL得到r,取模CL得到c,而且, 必须乘以内层的长度,
    				//grid[r][c]='0';
    				result++;
    				while(!qu.isEmpty()) {
    					//上下左右
    					int code = qu.poll();
    					int col = code%cL;
    					int row = code/cL;
    					grid[row][col]='0';
    					// 注意不能越界
    					//必须在找到一个1之后马上置为0,避免另一个坐标,计算出来的值,和其他坐标的值重复
    					if(row+1<rL&&grid[row+1][col]=='1') {
    						qu.add(col+(row+1)*cL);
    						grid[row+1][col]='0';
    					}
    					if(row-1>=0&&grid[row-1][col]=='1') {
    						qu.add(col+(row-1)*cL);
    						grid[row-1][col]='0';
    					}
    					if(col+1<cL&&grid[row][col+1]=='1') {
    						qu.add((col+1)+row*cL);
    						grid[row][col+1]='0';
    					}
    					if(col-1>=0&&grid[row][col-1]=='1') {
    						qu.add((col-1)+row*cL);
    						grid[row][col-1]='0';
    					}
    				}
    			}
    			
    		}
    		
    	}
    	return result;
	}
	public static void main(String[] args) {
		char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		char[][] grid3 = {{'1'},{'1'}};
		char[][] grid4 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		
		char[][] grid=grid1;
		//System.out.println(numIslands_DFS(grid));
		System.out.println(numIslands_BFS(grid));
	
	}
}
