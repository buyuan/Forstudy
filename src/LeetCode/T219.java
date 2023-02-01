package LeetCode;

public class T219 {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++) {
        	int edge = Math.min(i+k, nums.length-1);
        	for(int j=i+1;j<=edge;j++) {
        		if(nums[j]==nums[i]) {
        			return true;
        		}
        	}

        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,1,2,3};
		int k =2;
		System.out.print(containsNearbyDuplicate(nums,k));
	}
}


/*
219. Contains Duplicate II
Easy
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
*/