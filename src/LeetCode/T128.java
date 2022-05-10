/**
 * 128. Longest Consecutive Sequence
Medium
Given an unsorted array of integers nums, return the length of 
the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
package LeetCode;

import java.util.HashSet;

public class T128 {
    public static int longestConsecutive(int[] nums) {
        //思路,把数组中的数据存到一个hashset中,然后遍历数组,从hashset中找是否有连续的,然后连续的有多少个数字,同时,一边找一遍删除找到的, 
    	//避免某个数字是之前的某个数组的连续数字中的某一个
    	HashSet<Integer> hs = new HashSet<>();
    	for(int i:nums) {
    		hs.add(i);
    	}
    	int result=0;
    	for(int i:nums) {
    		if(!hs.contains(i)) {
    			continue;
    		}
    		hs.remove(i);
        	int pre=i-1;;
        	int after=i+1;
        	int count =1;
        	while(hs.contains(pre)) {
        		hs.remove(pre--);
        		count++;
        	}
        	while(hs.contains(after)) {
        		hs.remove(after++);
        		count++;
        	}
    		result = result>count?result:count;
    	}
    	return result;
    }
	public static void main(String[] args) {
    	int[] nums1 = {100,4,200,1,3,2};
    	int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
    	
    	
    	int[] testcase = nums2;
    	int result = longestConsecutive(testcase);
    	System.out.println(result);
    }
}
