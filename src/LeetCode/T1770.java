package LeetCode;

public class T1770 {
	public int[][] memo;
	public int n,m;
	public int[] nums, multipliers;
    public int maximumScore(int[] nums, int[] multipliers) {
    	this.m = multipliers.length;
    	this.n = nums.length;
    	this.nums = nums;
    	this.multipliers = multipliers;
        this.memo = new int[m][m];
        return dp(0,0);
    }
	private int dp(int i, int left) {
		if(i==m){
			//选完了，没可选了
			return 0;
		}
		int ml = multipliers[i];
		int r = n-1-(i-left);
		if(memo[i][left]==0) {
			//没有存过这个值
			//memo[i][left]是指，在第I次，左边去了left次这种状态下，可娶到的最大值
			memo[i][left]=Math.max(ml*nums[left]+dp(i+1,left+1),ml*nums[r]+dp(i+1,left));
		}
		return memo[i][left];
	}
}


/*
 * 
 * 
 * 
 * 1770. Maximum Score from Performing Multiplication Operations
Medium

842

214

Add to List

Share
You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.

 

Example 1:

Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.
Example 2:

Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
Output: 102
Explanation: An optimal solution is as follows:
- Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
- Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
- Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
- Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
- Choose from the end, [-2,7], adding 7 * 6 = 42 to the score. 
The total score is 50 + 15 - 9 + 4 + 42 = 102.
 

Constraints:

n == nums.length
m == multipliers.length
1 <= m <= 103
m <= n <= 105
-1000 <= nums[i], multipliers[i] <= 1000
 * */
