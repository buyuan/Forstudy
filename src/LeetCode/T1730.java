/*
 * 1730. Shortest Path to Get Food
Medium
You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.

 

Example 1:


Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
Output: 3
Explanation: It takes 3 steps to reach the food.
Example 2:


Input: grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
Output: -1
Explanation: It is not possible to reach the food.
Example 3:


Input: grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
Output: 6
Explanation: There can be multiple food cells. It only takes 6 steps to reach the bottom food.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[row][col] is '*', 'X', 'O', or '#'.
The grid contains exactly one '*'.
 */
package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class T1730 {
    public static int getFood(char[][] grid) {
        int lenR = grid.length;
        int lenC = grid[0].length;
        Queue<int[]> qu = new LinkedList<>();
        int result=0;
        //需要visited,因为避免回头路,同一个点,第一次到的步数比后面的少
        boolean[][] visited= new boolean[lenR][lenC] ;
        for(int i=0;i<lenR;i++) {
        	for(int j=0;j<lenC;j++) {
        		if(grid[i][j]=='*') {
        			visited[i][j]=true;
        			qu.add(new int[] {i,j});
        			break;
        		}
        	}
        }
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!qu.isEmpty()) {
        	int size = qu.size();
        	result++;
        	for(int i=0;i<size;i++) {
            	int[] curP = qu.poll();
            	int r = curP[0];
            	int c = curP[1];
            	for(int[] dir :directions) {
            		int nextR = r+dir[0];
            		int nextC = c+dir[1];
            		if(nextR>=0&&nextR<lenR&nextC>=0&&nextC<lenC&&grid[nextR][nextC]!='X') {
            		//if(nextR>=0&&nextR<lenR&nextC>=0&&nextC<lenC&&grid[nextR][nextC]!='X'&&!visited[nextR][nextC]) {
            			if(grid[nextR][nextC]=='#') {
            				return result;
            			}
            			visited[nextR][nextC]=true;
            			qu.add(new int[] {nextR,nextC});
            		}
            	}
        		
        	}
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	char[][] g1 ={{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
    	char[][] g2 ={{'X','X','X','X','X'},{'X','*','X','O','X'},{'X','O','X','#','X'},{'X','X','X','X','X'}};
    	char[][] grid=g2;
    	disp(grid);
    	System.out.println(getFood(grid));
    	
    	
    }

	private static void disp(char[][] grid) {
		// TODO Auto-generated method stub
		for(char[] c:grid) {
			for(char r:c) {
				System.out.print(r+" ,");
			}
			System.out.println();
		}
	}
}
