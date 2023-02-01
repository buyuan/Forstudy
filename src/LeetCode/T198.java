package LeetCode;

import java.util.HashMap;

public class T198 {
    public int rob(int[] nums) {
    	//dp(i)表示，在第i个商店时候，累计抢到的最多的钱
        //recursive relationship : dp(i) = max(dp(i-1), dp(i-2)+num(i))
    	//base case : dp(0) = nums[0], dp(1)= max(nums[0[,nums[1])
    	HashMap<Integer,Integer> memo = new HashMap<>();
    	int[] mem = new int[nums.length];
    	return dp_b2t(nums,mem);
    	//return dp(nums.length-1,nums,memo);
    }

	private int dp_b2t(int[] nums, int[] mem) {
		if(nums.length==1) {
			return nums[0];
		}
		mem[0] = nums[0];
		mem[1] = Math.max(nums[0],nums[1]);
		for(int j=2;j<nums.length;j++) {
			mem[j] = Math.max(mem[j-1], mem[j-2]+nums[j]);
		}
		return mem[nums.length-1];
	}

	private int dp(int i, int[] nums, HashMap<Integer, Integer> memo) {
		if(i==0) {
			return nums[0];
		}
		if(i==1) {
			return Math.max(nums[0], nums[1]);
		}
		if(!memo.containsKey(i)) {
			int cur = Math.max(dp(i-1,nums,memo), dp(i-2,nums,memo)+nums[i]);
			memo.put(i, cur);
		}
		return memo.get(i);
	}
	

}


/*
198. House Robber
Medium

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
*/