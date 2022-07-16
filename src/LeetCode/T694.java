/*
 * 694. Number of Distinct Islands
Medium
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.

 

Example 1:


Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1
Example 2:


Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class T694 {
    public static int numDistinctIslands(int[][] grid) {
    	//1. 先找到所有的岛屿，DFS
    	//遍历所有的点，如果有1，开始DFS，所有的为1的点记录下来，然后将这个点赋值为0
    	int col = grid[0].length;
    	int row = grid.length;
    	Set<String> cout = new HashSet<>();	
    	for(int r=0;r<row;r++) {
    		for(int c=0;c<col;c++) {
    			StringBuilder island = new StringBuilder();
    			if(grid[r][c]==1) {
    				//found a island, 第一个发现的1就是基点，如果岛屿形状一样，那么基点应该相对位置一样
    				dfs(grid,r,c,r,c,island);
    				//出来以后，island就是这个岛的所有点
    				cout.add(island.toString());
    			}
    		}
    	}
        return cout.size();
    }

	private static void dfs(int[][] grid, int r0, int c0, int r, int c, StringBuilder island) {
		int cL = grid[0].length;
		int rL = grid.length;
		if(r<0||r>=rL||c<0||c>=cL||grid[r][c]==0) {
			return;
		}
		grid[r][c]=0;
		island.append((r-r0)+""+(c-c0));
		dfs(grid,r0,c0,r-1,c,island);
		dfs(grid,r0,c0,r+1,c,island);
		dfs(grid,r0,c0,r,c-1,island);
		dfs(grid,r0,c0,r,c+1,island);
		
	}

	public static void main(String[] args) {
		int[][] grid1 = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		char[][] grid3 = {{'1'},{'1'}};
		char[][] grid4 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		
		int[][] grid=grid1;
		//System.out.println(numIslands_DFS(grid));
		System.out.println(numDistinctIslands(grid));
	
	}   
}
