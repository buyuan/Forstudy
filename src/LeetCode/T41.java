package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class T41 {
	//数组长度有多少，则可能结果范围是1 ～ （n+1），
	//1. hash set,放到set中，从1开始挨个找，找不到就返回，找完了，就最后一个+1
	public int firstMissingPositive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for( int i:nums) {
        	if(!st.contains(i)){
        		st.add(i);
        	}
        }
        int res = 1; int len = nums.length;
        while(res<=len) {
        	if(!st.contains(res)) {
        		return res;
        	}
        	res++;
        }
        return res;
    }
	
}


/*
41. First Missing Positive
Hard

12376

1491

Add to List

Share
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1

Explanation: The smallest positive integer 1 is missing.
*/