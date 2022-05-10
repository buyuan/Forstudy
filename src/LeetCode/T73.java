/**
 * 73. Set Matrix Zeroes
Medium
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 
 */
package LeetCode;

public class T73 {
	public static void setZeroes(int[][] matrix) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
        boolean[] col = new boolean[colSize];
        boolean[] row = new boolean[rowSize];
        //find the column or rows that contains 0
        for(int rw=0;rw<rowSize;rw++) {
        	for(int cln =0;cln<colSize;cln++) {
        		if(matrix[rw][cln]==0) {
        			col[cln] = true;
        			row[rw]  = true;
        		}
        	}
        }

        //set the row to zero
        for(int i=0;i<rowSize;i++) {
        	if(row[i]) {
        		for(int j=0;j<colSize;j++) {
        			matrix[i][j]=0;
        		}
        	}
        }
        //set the col to zero
        for(int i=0;i<colSize;i++) {
        	if(col[i]) {
        		for(int j=0;j<rowSize;j++) {
        			matrix[j][i]=0;
        		}
        	}
        }
    }
	
	public static void main(String[] args) {
		int[][] m1 ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		int[][] m2 ={{1,1,1},{1,0,1},{1,1,1}};
		
		int[][] testcase = m2;
		display(testcase);
		setZeroes(testcase);
		System.out.println("=========================");
		display(testcase);
	}

	private static void display(int[][] testcase) {
		for(int[] x:testcase) {
			for(int i:x) {
				System.out.print(i+",");
			}
			System.out.println();
		}
		
	}
}
