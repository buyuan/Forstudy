/**
 * 1. Two Sum
Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */
package LeetCode;

import java.util.HashMap;

public class T1 {
	//方法1是暴力寻找,从第一俄开始,往后遍历, 时间复杂度n^2
    public static int[] twoSum_violence(int[] nums, int target) {
        int[] ans = new int[2];
        boolean get = false;
        for(int i =0; i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if ((nums[i]+nums[j])==target) {
                   ans[0]=i;
                   ans[1]=j;
                   get = true;
                   break;
                }
            }
            
        }

        return ans;
    }
	//方法2是用hashmap,直接找目标的index,查找的时间复杂度是1, 数据录入时间复杂度n
    public static int[] twoSum_HashMap(int[] nums, int target) {
    	HashMap<Integer,Integer> hm = new HashMap<>();
    	int size = nums.length;
    	for(int i=0;i<size;i++) {
    		hm.put(nums[i],i);
    	}
    	int[] result = new int[2];
    	for(int i=0;i<size;i++) {
        	int dif = target-nums[i];
        	if(hm.containsKey(dif)) {
        		int index = hm.get(dif);
        		if(i==index) {continue;}
        		result[0] = i;
        		result[1] =index;
        		break;
        	}
    	}
    	return result;
    }
    //下面这个更快,一边put一边找,因为,找到1,2和找到2,1是一样的,如果1的时候,2还没有put,在2的时候,就能找到原来1的put,这样就只用循环一次
    //而且还不用考虑同一个index被用两次的情况
    public static int[] twoSum_HashMap2(int[] nums, int target) {
    	HashMap<Integer,Integer> hm = new HashMap<>();
    	int size = nums.length;
    	int[] result = new int[2];
    	for(int i=0;i<size;i++) {
    		if(hm.containsKey(target-nums[i])) {
    			result[0] = i;
    			result[1] = hm.get(target-nums[i]);
    			break;
    		}
    		hm.put(nums[i], i);
    	}
    	return result;
    }
    public static void main(String[] args) {
    	int[] nums1 = {2,7,11,15};int t1 = 9;
    	int[] nums2 = {3,2,4};int t2 = 6;
    	int[] nums3 = {3,3};int t3 = 6;
    	
    	int[] testcase = nums3; int testK = t3;
    	int[] result = twoSum_HashMap(testcase,testK);
    	disply(testcase);
    	System.out.println();
    	System.out.println("========================");
    	disply(result);
    }
	private static void disply(int[] testcase) {
		for(int i:testcase) {
			System.out.print(i+",");
		}
		
	}
}
