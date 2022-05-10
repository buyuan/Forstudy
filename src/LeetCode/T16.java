package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
 * @author cbuyu
 *
 */
public class T16 {
	public static void main(String[] args) {
		int nums1[] = {-1,2,1,-4};
		int target1 = 1;
		int nums2[] = {0,0,0};
		int target2 = 1;
		System.out.println(threeSumClosest_update(nums1, target1));
	}
	 public static int threeSumClosest_update(int[] nums, int target) {
		 //我发现这个方法和下面的better一样
	    	if(nums==null) {
	    		return (Integer) null;
	    	}
	    	//先排序,然后target-每个元素就变成2sum问题,用左右指针 可以做一些剪枝,
	    	sort(nums);  
    		int result =Integer.MAX_VALUE;
    		int min_dis =Integer.MAX_VALUE;
	    	int size = nums.length;
	    	for(int i=0;i<size-2;i++) {//-2是因为要有三个位置
	    		int l=i+1; int r = size-1;
	    		int first = nums[i];
	    		while(l<r) {
	    			int sum = nums[l]+nums[r];
	    			if(sum+first==target) {   				
	    				result = sum+first;
	    				break;
	    			}else {
	    				int dis = distance(sum+first,target);
	    				if(dis<min_dis) {
	    					result = sum+first;
	    					min_dis=dis;
	    				}	    				
	    				if(sum+first>target) {
	    					r--;
	    				}else {
	    					l++;
	    				}
	    			}
	    		}
	    		while(nums[i+1]==nums[i]&&i<size-2) {
	    			i++;//避免重复,
	    		}
	    	}
	    	return result;
	    }
	    
		private static void sort(int[] nums) {
			// TODO Auto-generated method stub
				int size = nums.length;
				for(int i=0;i<size;i++) {
					for(int j=0;j<size-1-i;j++) {
						if(nums[j]>nums[j+1]) {
							int temp = nums[j];
							nums[j]  = nums[j+1];
							nums[j+1]=temp;
						}
					}
				}	
		}
	public static int threeSumClosest_better(int[] nums, int target) {	
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<nums.length-i;j++) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j+1];
					nums[j+1]=nums[j];
					nums[j] = temp;
				}
			}
		}
		int ans = nums[0]+nums[1]+nums[2];//make it run
		if(ans==target) {//found
			return ans;
		}
		int min_dis = distance(ans, target);//make it run

		for(int i=0;i<nums.length-2;i++) {
			int left = i+1;
			int right = nums.length-1;
			while(left<right) {
				int sum = nums[i]+nums[left]+nums[right];
				int cur_dis = distance(sum, target);
				if(cur_dis<min_dis) {
					ans =sum;
					min_dis=cur_dis;
				}
				if(sum<target) {
					//需要让sum变大
					left++;
				}else {
					//需要让SUM变小
					right--;
				}
			}
		}
		return ans;
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		int ans =nums[0]+nums[1]+nums[2];//make it run
		int min_dis = distance(ans, target);//make it run
        for(int i=0;i<nums.length-2;i++) {
    		for(int j=i+1;j<nums.length-1;j++) {
    			for(int k=j+1;k<nums.length;k++) {
    				int sum = nums[i]+nums[j]+nums[k];
    				int cur_dis = distance(sum, target);
    				if(cur_dis<min_dis) {
    					ans = sum;
    					min_dis=cur_dis;
    				}
    			}
    		}
        }
    	return ans;
    }
	
	private static int distance(int fresh, int target) {
		int a = target -fresh;
		if(a>0) {
			return a;
		}
		return 0-a;	
	}
}
