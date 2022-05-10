/**
 * [LeetCode] 348. Design Tic-Tac-Toe
Medium

Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical,
 or diagonal row wins the game.
 

Example:

Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
 

Follow up:
Could you do better than O(n2) per move()

Hint:

Could you trade extra space such that move() operation can be done in O(1)?
You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.

 

CareerCup上的原题，请参见我之前的博客17.2 Tic Tac Toe。我们首先来O(n2)的解法，这种方法的思路很straightforward，就是建立一个nxn大小的board，其中0表示该位置没有棋子，1表示玩家1放的子，2表示玩家2。那么棋盘上每增加一个子，我们都扫描当前行列，对角线，和逆对角线，看看是否有三子相连的情况，有的话则返回对应的玩家，没有则返回0，参见代码如下：

 
 */
package LeetCode;

import java.util.Scanner;

public class T348 {
	class TicTacToe{
		//思路是用行数组,列数组,然后两个对角线,分别记录放置的值,如果是1玩家,+1,2玩家,-1,到达目标之后则说明有人赢了
		 /** Initialize your data structure here. */
		int[] rows,cols;
		int diag, rev_dig;
		int size;
		public TicTacToe(int n) {
			size =n;
			rows = new int[n];//default is 0
			cols = new int[n];
			diag    = 0;
			rev_dig = 0;		
		}
		   /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */		
		public int move(int row,int col,int player) {
			if(player==1) {
				rows[row]++;
				cols[col]++;
				if(row == col) {
					diag++;
				}
				if((row+col)==size-1) {
					rev_dig++;
				}
				if(rows[row]==size||cols[col]==size||diag==size||rev_dig==size) {
					return 1;
				}
			}else if(player==2) {
				rows[row]--;
				cols[col]--;
				if(row == col) {
					diag--;
				}
				if((row+col)==size-1) {
					rev_dig--;
				}
				if(rows[row]==(0-size)||cols[col]==(0-size)||diag==(0-size)||rev_dig==(0-size)) {
					return 2;
				}
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		T348 out = new T348();
		TicTacToe TT = out.new TicTacToe(3);
		Scanner scn = new Scanner(System.in);
		String[][] board = new String[3][3];
		display(board);
		while(true) {
			System.out.println("please input");
			String ipt = scn.nextLine();
			char[] ch = ipt.toCharArray();
			int r = ch[0]-'0';
			int c = ch[1]-'0';
			int p = ch[2]-'0';
			String Str =  (p==1)?"X":"O";
			board[r][c] = Str;
			int result = TT.move(r,c,p);
			display(board);
			if(result ==1) {
				System.out.println("winner is 1");
				break;
			}
			if(result ==2) {
				System.out.println("winner is 2");
				break;
			}
		}
	}
	private static void display(String[][] board) {
		// TODO Auto-generated method stub
		for(String[] srs:board) {
			for(String s:srs) {
				System.out.print(s+"\t|");
			}
			System.out.println();
		}
		
	}

}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */