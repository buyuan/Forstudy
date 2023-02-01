package LeetCode;

public class T221 {
	public int maximalSquare_3(char[][] matrix) {
		//DP
		//dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1.
		//dp(i,j)是指，以（i，J）为右下角的正方形最长边
		//1， 是因为 (i,j)必须为1，这个点才有意义，如果（i，j）为0，那么dp（i，j）为0
		//min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))是为了左，左上，上，三个方向都没有0的点的方形的边长
		int row = matrix.length;
    	int col = matrix[0].length;
    	int maxLen=0;
    	//在外面套一层全0的边，这样原来的上边，下边也可以用样的逻辑计算了，相当于从新方块的（1，1）开始
    	int[][] dp = new int[row+1][col+1];
 
    	for(int r=1;r<=row;r++) {
    		for(int c=1;c<=col;c++) {
    			if(matrix[r-1][c-1]=='1') {
    				dp[r][c]=Math.min(Math.min(dp[r-1][c-1],dp[r][c-1]),dp[r-1][c])+1;
    				maxLen = maxLen<dp[r][c]?dp[r][c]:maxLen;
    			}
    		}
    	}
		return maxLen*maxLen;
	}
    public int maximalSquare_2(char[][] matrix) {
        //brute forc
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int maxLen=0;
    	for(int i =0;i<row;i++) {
    		for(int j=0;j<col;j++) {
    			if(matrix[i][j]=='0'){
    				//start from(i,j),so (i,j)must be 1
    				continue;
    			}
    			int len = 1;
    			boolean flag = true;
    			while(flag && i+len<row && j+len<col) {
    				//从点（i，j）开始找最长边((i,j)本身已经是0了
    				//每次 len加一，就遍历一遍新出现的一圈点
    				
    				//horizental
    				for(int c=j;c<j+len;c++) {
    					if(matrix[i+len][c]=='0') {
    						flag=false;
    						break;
    					}
    				}
    				//vertical
    				for(int r = i;r<i+len;r++) {
    					if(matrix[r][j+len]=='0') {
    						flag = false;
    						break;
    					}
    				}
    				if(flag) {
    					len++;
    				}
    			}
    			if(maxLen<len) {
    				maxLen=len;
    			}
    		}
    	}
    	return maxLen*maxLen;
    }
    public int maximalSquare_1(char[][] matrix) {
        //brute force
    	//这个超时了，相当于找的时候每次延长一个边长，都要重新遍历一次
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int maxLen=0;
    	for(int i =0;i<row;i++) {
    		for(int j=0;j<col;j++) {
    			if(matrix[i][j]=='0'){
    				//start from(i,j),so (i,j)must be 1
    				continue;
    			}
    			int len = 1;
    			boolean flag = true;
    			while(flag && i+len<row && j+len<col) {
    				//从点（i，j）开始找最长边((i,j)本身已经是0了
    				for(int r=i;r<=i+len;r++) {
    					for(int c=j;c<=j+len;c++) {
    						if(matrix[r][c]=='0') {
    							flag=false;
    							break;
    						}
    					}
    				}
    				if(flag) {
    					len++;
    				}
    			}
    			if(maxLen<len) {
    				maxLen=len;
    			}
    		}
    	}
    	return maxLen*maxLen;
    }
}


/**
221. Maximal Square
Medium

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
*/