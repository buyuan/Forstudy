/*
 * 130. Surrounded Regions
Medium
Given an m x n matrix board containing 'X' and 'O', 
capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X'
s in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
package LeetCode;

public class T130 {
    public static void solve(char[][] board) {
    	//从边缘找,找到O.开始dfs,改成一个其他字母%,扫完边缘,
    	//剩下的O肯定都在中间,都改成X,再把%改成O
    	int rL = board.length;
    	int cL = board[0].length;
        for(int i=0;i<cL;i++) {
        	//up side
        	if(board[0][i]=='O') {
        		dfs(0,i,board);
        	}
        }
        for(int i=1;i<rL;i++) {
        	//left side
        	if(board[i][0]=='O') {
        		dfs(i,0,board);
        	}
        }
        for(int i=1;i<cL;i++) {
        	//down side
        	if(board[rL-1][i]=='O') {
        		dfs(rL-1,i,board);
        	}
        }
        for(int i=1;i<rL-1;i++) {
        	//right side
        	if(board[i][cL-1]=='O') {
        		dfs(i,cL-1,board);
        	}
        }
        for(int i=0;i<rL;i++) {
        	for(int j=0;j<cL;j++) {
        		if(board[i][j]=='O') {
        			board[i][j]='X';
        		}
        		if(board[i][j]=='%') {
        			board[i][j]='O';
        		}
        	}
        }
    }

	private static void dfs(int row, int col, char[][] board) {
		// TODO Auto-generated method stub
		board[row][col]='%';
		if(row<board.length-1&&board[row+1][col]=='O') {
			//down
			dfs(row+1,col,board);
		}
		if(col<board[0].length-1&&board[row][col+1]=='O') {
			//right
			dfs(row,col+1,board);
		}
		if(0<col&&board[row][col-1]=='O') {
			//left
			dfs(row,col-1,board);
		}
		if(row>0&&board[row-1][col]=='O') {
			//up
			dfs(row-1,col,board);
		}
	}
	
	public static void main(String[] args) {
		char[][] bd1 ={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		
		char[][] board=bd1;
		disp(board);
		solve(board);
		System.out.println("========================");
		disp(board);
	}
	
	private static void disp(char[][] board) {
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		System.out.printf("%-5c",board[i][j]);       		
        	}
        	System.out.println();
        }
	}
        
}
