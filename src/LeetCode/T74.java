/**
 * 74. Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a value target in an m x n integer 
matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */
package LeetCode;

public class T74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        //move along antidiagonal
    	int upSide = matrix.length-1;
    	int rightSide=0;
    	int rightLimit= matrix[0].length-1;
    	boolean result = false;
    	while(upSide>=0&&rightSide<=rightLimit) {
    		if(matrix[upSide][rightSide]==target) {
    			return true;
    		}
    		if(matrix[upSide][rightSide]>target) {
    			upSide--;
    		}else {
    			rightSide++;
    		}
    	}
    	return result;
    	
    }
    public static boolean searchMatrix_bina(int[][] matrix, int target) {
    	int len = matrix[0].length;
    	int l=0;
    	int r = len*matrix.length;
    	while(l<r) {
    		int mid = l+(r-l)/2;
    		if(matrix[mid/len][mid%len]==target) {
    			return true;
    		}
    		if(matrix[mid/len][mid%len]<target) {
    			l=mid+1;
    		}else {
    			r=mid;
    		}
    	}
    	return false;    	
    }

	public static void main(String[] args) {
    	int[][] m1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};int t1=3;
    	int[][] m2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};int t2=13;
    	
    	int[][] m =m2;int t =t2;
    	display(m);
    	System.out.println(searchMatrix_bina(m,t));
    	
    }
	private static void display(int[][] m) {
		for(int[] arr:m) {
			for(int x:arr) {
				System.out.printf("%-5s",x);
			}
			System.out.println();
		}
		 
	}
}
