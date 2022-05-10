/**
 * 
 * 54. Spiral Matrix
Medium
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
    	//总体思路是用,左右,上下边界,一个圈一个圈的循环,所谓一个圈,是指一个完整的,沿着各个边走的一个圈,外圈遍历完,剩下的部分,也是一个矩阵,所以可以用同样的方法循环
    	int left = 0;
    	int right = matrix[0].length;
    	int top =0;
    	int bottom = matrix.length;
    	
    	ArrayList<Integer> result = new ArrayList<>();
    	
    	while(left<right&&top<bottom) {
    		//top line ,from left to right
    		for(int i =left;i<right;i++) {
    			result.add(matrix[top][i]);
    		}
    		top ++;
    		if(!(left<right&&top<bottom) ){
    			//防止边界变化之后,来不及反应到循环中
    			break;
    		}
    		//right line, from top to bottom
    		for(int i = top; i<bottom; i++) {
    			result.add(matrix[i][right-1]);
    		}
    		right--;
    		if(!(left<right&&top<bottom) ){
    			break;
    		}
    		//bottom line from right to left
    		for(int i = right-1;i>=left;i--) {
    			result.add(matrix[bottom-1][i]);
    		}
    		bottom--;
    		if(!(left<right&&top<bottom) ){
    			break;
    		}
    		//left line from bottom to top
    		for(int i = bottom-1;i>=top;i--) {
    			result.add(matrix[i][left]);
    		}
    		left++;
    	}
    	
    	
    	return result;
        
    }
    
    public static void main(String[] args) {
    	int[] nums1[] = {{1,2,3},{4,5,6},{7,8,9}};
    	int[] nums2[] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	int[] nums3[] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	int[] nums4[] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
    	int[] nums5[] = {{7},{9},{6}};
    	
    	int[][] testcase = nums2;
    	
    	ArrayList<Integer> result =(ArrayList<Integer>) spiralOrder(testcase);
    	
    	display(testcase);
    	for(int i:result) {
    		System.out.print(i+",");
    	}
    }

	private static void display(int[][] testcase) {
		for(int[] arr:testcase) {
			for(int i:arr) {
				System.out.print(i+",");
			}
			System.out.println();		
		}
		System.out.println("====================");
		
	}
}
