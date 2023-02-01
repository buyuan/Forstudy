package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class T36 {
	public static void main(String[] args) {
		char[][] b1 = 
			   {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
				
		char[][] testcase = b1;
		System.out.print(isValidSudoku(testcase));
	}
	public static boolean isValidSudoku(char[][] board) {
		//just validate, nor checking if there is a resolve, 
		//col, row, 3X3 squre not repetition
		Set<Character> stRow = new HashSet<>();
		Set<Character> stCol = new HashSet<>();
		Set<Character> stCell = new HashSet<>();
		//row by row
		for(int i =0;i<9;i++) {
			//rol
			for(int j =0;j<9;j++) {
				if (board[i][j]=='.') {
					continue;
				}
				//col
				if(stCol.contains(board[i][j])) {
					return false;
				}else {
					stCol.add(board[i][j]);
				}
			}
			stCol = new HashSet<>();
		}
		
		//col by col
		for(int i =0;i<9;i++) {
			//rol
			for(int j =0;j<9;j++) {
				//col
				if (board[j][i]=='.') {
					continue;
				}
				if(stRow.contains(board[j][i])) {
					return false;
				}else {
					stRow.add(board[j][i]);
				}
			}
			stRow = new HashSet<>();
		}
		
		//cell by cell
		for(int baseR=0;baseR<9;baseR+=3) {
			for(int baseC=0;baseC<9;baseC+=3) {
				for(int i=baseR;i<baseR+3;i++) {
					for(int j =baseC;j<baseC+3;j++) {
						if (board[i][j]=='.') {
							continue;
						}
						if(stCell.contains(board[i][j])){
							return false;
						}else {
							stCell.add(board[i][j]);
						}
					}
					
				}
				stCell = new HashSet<>();
			}
		}
		return true;
	}
}
