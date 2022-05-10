/**
 * 34. Find First and Last Position of Element in Sorted Array
Medium
Given an array of integers nums sorted in non-decreasing order, 
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
package LeetCode;

public class T34 {
    public static int[] searchRange(int[] nums, int target) {
    	int[] result = new int[2];
    	if(nums.length==0) {
        	result[0] = -1;
        	result[1] = -1;
        	return result;
    	}
        int l=0;
        int r =nums.length-1;
        int mid = l+(r-l)/2;
        while(nums[mid]!=target&&l<r) {
        	if(nums[mid]<target) {
        		l = mid+1;
        	}else {
        		r =mid;
        	}
        	mid = l+(r-l)/2;
        }       
        if(nums[mid]!=target) {
        	result[0] = -1;
        	result[1] = -1;
        	return result;
        }
        int left = mid;
        while(nums[left]==target) {
        	if(left<1||nums[left-1]!=target) {
        		break;
        	}else {
               	left--;
        	}
        }
        int right = mid;
        while(nums[right]==target) {
        	if(right+1>nums.length-1||nums[right+1]!=target) {
        		break;
        	}else {
        		right++;
        	}
        }
        result[0]=left;
        result[1]=right;
        return result;
    }
    public static int[] searchRange_recur(int[] nums, int target) {
    	int[] result = new int[2];
    	int index = find(nums,0,nums.length-1,target);
    	if(index==-1) {
    		result[0]=index;
    		result[1]=index;
    	}
    	int left = index;
    	while(left>0&&nums[left-1]==target) {
    		left--;
    	}
    	int right=index;
    	while(right<nums.length&&nums[right+1]==target) {
    		right++;
    	}
    	result[0] = left;
    	result[1] = right;
    	return result;
    }
    private static int find(int[] nums, int l, int r, int target) {
		if(l>r) {return -1;}
		int mid = l+(r-l)/2;
		if(nums[mid]==target) {
			return mid;
		}
		if(nums[mid]<target) {
			l=mid+1;
			return find(nums,l,r,target);
		}else{
			r=mid;
			return find(nums,l,r,target);
		}
	}
	public static void main(String[] args) {
    	int[] case1 = {5,7,7,8,8,10};int tar1 =8;
    	int[] case2 = {5,7,7,8,8,10};int tar2 =6;
    	int[] case3 = {};int tar3 =0;
    	int[] case4 = {1};int tar4 =1;
    	
    	int[] testcase = case1;int tar =tar1;
    	int[] result = searchRange_recur(testcase,tar);
    	System.out.println(result[0]+","+result[1]);
    }
}
