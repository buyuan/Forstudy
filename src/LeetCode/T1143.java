package LeetCode;

public class T1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
    	//DP[i][j]是指，text1，在i位置和text2在j位置，i之前，j之前子字符串，LCS的值
    	//所以，当这个字符相等时，时上一个位置+1，不等时，就是上一个位置，两者的最大值
    	
    	//String前面加一个站位的，方便应用同一个规则(指的是DP这个数组外面包一圈）
    	//从第一个开始往前遍历
    	
    	text1="1"+text1;
    	text2="2"+text2;
    	int[][] dp = new int[text1.length()][text2.length()];
    	for(int row=1;row<=dp.length-1;row++) {
    		for(int col =1;col<=dp[0].length-1;col++) {
    			if(text1.charAt(row)==text2.charAt(col)) {
    				dp[row][col] = 1+dp[row-1][col-1];
    			}else {
    				dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
    			}
    		}
    	}
    	
    	return dp[text1.length()-1][text2.length()-1];
    	
    }
}

/*

1143. Longest Common Subsequence
Medium

7635

86

Add to List

Share
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
*/