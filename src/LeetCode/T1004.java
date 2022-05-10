/*
 * 1004. Max Consecutive Ones III
Medium

Given a binary array nums and an integer k, return the maximum number of 
consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
package LeetCode;

public class T1004 {
    public static int longestOnes(int[] nums, int k) {
    	//从0开始遍历,0开始的符合的是多少,1开始的,符合的是多少...
        int res=0;
        int size = nums.length;
        for(int i=0;i<size;i++) {
        	if(i+res>=size) {
        		break;
        	}
        	int zCount=0;
        	int r=i;
        	while(zCount<=k&&r<size) {
        		if(nums[r]==0){
        			zCount++;
        		}
        		if(zCount>k) {
        			break;
        		}
    			r++;
        	}
        	res=res>r-i?res:r-i;   	

        }
        return res;
    }
    
    public static int longestOnes_new(int[] nums, int k) {
    	//两边滑动,如果过程中,不符合条件了,左边前移,右边再继续往后探
    	int l=0;
    	int zCount=0;
    	int res=0;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==0) {
    			zCount++;
    		}
    		while(zCount>k) {
    			if(nums[l]==0) {
    				zCount--;
    			}
    			l++;
    			
    		}
    		res = res>i-l+1?res:i-l+1;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0}; int k1=2;
    	int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};int k2=3;
    	int[] nums3 = {0,0,0,1};int k3=4;
    	
    	int[] nums=nums2;int k=k2;
    	
    	System.out.println(longestOnes_new(  nums, k));
    	
    }
}
