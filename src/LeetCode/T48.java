package LeetCode;

public class T48 {
	public void rotate(int[][] matrix) {
		/*
		//1反对角线交换
		transpose(matrix);
		//2中轴线左右交换
		reverse(matrix);
		*/
		//1.对角线交换
		transpose_tri(matrix);
		//2. 中线上下交换
		reverse_updown(matrix);
	}

	private void reverse_updown(int[][] matrix) {
		int len =matrix.length;
		for(int i=0;i<len/2;i++) {
			for(int j=0;j<len;j++) {
				int cur = matrix[i][j];
				matrix[i][j] = matrix[len-1-i][j];
				matrix[len-1-i][j] = cur;
			}
		}
		
	}

	private void transpose_tri(int[][] matrix) {
		int len = matrix.length;
		for(int i=len-1;i>=0;i--) {
			for(int j=len-1-i; j>=0;j--) {
				int cur = matrix[i][j];
				matrix[i][j] =matrix[len-1-j][len-1-i];
				matrix[len-1-j][len-1-i]= cur;
			}
		}
		
	}

	private void reverse(int[][] matrix) {
		int len = matrix.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len/2;j++) {
				int cur = matrix[i][j];
				matrix[i][j] = matrix[i][len-1-j];
				matrix[i][len-1-j] = cur;
			}
		}
		
	}

	private void transpose(int[][] matrix) {
		int len = matrix.length;
		for(int i=0;i<len;i++) {
			for(int j=i+1;i<len;j++) {
				int cur = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = cur;
			}
		}
		
	}
}

/*
 * 48. Rotate Image
Medium

10513

537

Add to List

Share
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */
