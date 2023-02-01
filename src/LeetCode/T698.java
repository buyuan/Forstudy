
package LeetCode;

import java.util.Arrays;

public class T698 {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        //思路，可以先算出来每组的和是多少， 然后回溯依次选值来凑
    	int sum=0;
    	for(int i:nums) {
    		sum+=i;
    	}
    	int  target= 0;
    	if(sum%k!=0) {
    		//没有相同的均值，无法平均分成k组
    		return false;
    	}else {
    		target=sum/k;
    	}
    	boolean[] visited = new boolean[nums.length];
    	return startToPar(nums,target,k,visited,0,target);
    }

	private static boolean startToPar(int[] nums, int amountLeft, int leftNumber, boolean[] visited,int startIndex, int target) {
		if(leftNumber==0) {
			return true;
		}
		if(amountLeft==0) {
			// 找到一组之后，从头继续找
			return startToPar(nums,target,leftNumber-1,visited,0,target);
		}
		for(int i=startIndex;i<nums.length;i++) {
			if(visited[i]||amountLeft<nums[i]) {
				//已经被选中过
				continue;
			}
			visited[i]=true;
			if(startToPar(nums,amountLeft-nums[i],leftNumber,visited,i+1,target )) {
				return true;
			}
			visited[i]=false;
			
		}
		return false;
	}
	public static void main(String[] args) {
		int[] n1 = {6,5,9,6,3,5,1,10,4,1,4,3,9,9,3,3} ;int k1=9;
		
		int[] nums=n1;int k=k1;
		System.out.println(canPartitionKSubsets(nums,k));
	}
}


/*
 * 698. Partition to K Equal Sum Subsets
Medium
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
 */