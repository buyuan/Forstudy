package LeetCode;

import java.util.HashMap;

public class T746 {
	public static void main(String[] args) {
		int[] cost = {10,15,20};
		System.out.println(minCostClimbingStairs(cost));
	}
    public static int minCostClimbingStairs(int[] cost) {
        //第 i 层台阶，累计的cost是， 如果是前两层不用，就是dp（i-2）+cost(2)，如果这上一层，就是dp(i-1)+cost(i-1),找两者最小值
    	//F(i) == min(f(i-1),f(i-2)+cost(i))
    	//1 for top dowm
    	HashMap<Integer,Integer> memo = new HashMap<>();
    	//return dp_rec(cost.length,cost,memo);
    	//2 for botom up
    	//+1的原因，因为cost是上一层的花费，所以最高层并没有在这里面
    	int[] memo2 = new int[cost.length+1];
    	for(int i=2;i<memo2.length;i++) {
			int oneStep = memo2[i-1]+cost[i-1];
			int twoStep = memo2[i-2]+cost[i-2];
			memo2[i] = Math.min(oneStep, twoStep);
		}
		return memo2[memo2.length-1];
    }
    
	private static int dp_rec(int length, int[] cost, HashMap<Integer, Integer> memo) {
		if(length==0||length==1) {
			return 0;
		}
		if(memo.containsKey(length)) {
			return memo.get(length);
		}
		
		int fromLastStep = cost[length-1] + dp_rec(length-1,cost,memo);
		int fromLastTwo  = cost[length-2] + dp_rec(length-2,cost,memo);
		memo.put(length, Math.min(fromLastStep, fromLastTwo));
		return memo.get(length);
	}
}


/*
746. Min Cost Climbing Stairs
Easy
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
*/