/**
 * 53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 */
package LeetCode;

public class T53 {
	public static void main(String[] args) {
		int[] nums = {-2,-1};
		int A =maxSubArray(nums);
		System.out.println(A);
		
	}
	//complexity n^2, not accepted
    public static int maxSubArray1(int[] nums) {
        int start=0;
        int end =0;
        int ans=nums[0];
    	if(nums.length==1) {
    		return nums[0];
    	}
    	if(nums==null) {
    		return -1;
    	}
        for(int i=0;i<nums.length;i++) {
        	int temp=0;
        	for(int j=i;j<nums.length;j++) {
        		temp+=nums[j]; 
        		if(temp>ans) {
        			ans = temp;
        			start=i;
        			end =j;
        		}
        	}

        }
        return ans;
    }
    public static int maxSubArray(int[] nums) {
    	if(nums==null) {
    		return -1000;
    	}
    	return maxSubArrR(nums,0,nums.length-1);
    }
	private static int maxSubArrR(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
    	if(left==right) {
    		return nums[left];
    	}
    	int mid = (left+right)/2;
    	int leftMax = maxSubArrR(nums,left,mid);
    	int rightMax = maxSubArrR(nums,mid+1,right);
    	int midMax_L=nums[mid];
    	int midMax_R=nums[mid+1];
    	int temp=0;
    	for(int i=mid;i>=left;i--) {
    		temp+=nums[i];
    		if(temp>midMax_L) {
    			midMax_L=temp;
    		}
    	}
    	temp=0;
    	for(int i=mid+1;i<=right;i++) {
    		temp+=nums[i];
    		if(temp>midMax_R) {
    			midMax_R=temp;
    		}
    	}
    	int maxMid =max( midMax_L,midMax_R,midMax_L+midMax_R);
    	return max(leftMax,rightMax,maxMid);
	}
	private static int max(int a, int b, int c) {
		// TODO Auto-generated method stub
		return a>b?(a>c?a:c):(b>c?b:c);
	}
}
