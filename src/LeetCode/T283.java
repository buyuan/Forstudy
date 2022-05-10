/*
 * 283. Move Zeroes
Easy

Given an integer array nums, move all 0's to the end of 
it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
Accepted
1,533,140
Submissions
2,543,294
 */
package LeetCode;

public class T283 {
    public void moveZeroes(int[] nums) {
    	int len = nums.length;
        int r=len-1;
        int count=0;
        for(int i=len-1;i>=0;i--) {
        	if(nums[i]==0) {
        		count++;
        		for(int j=i;j<len-count;j++) {
        			nums[j]=nums[j+1];
        		}
        		nums[len-count]=0;
        		
        	}
        }
        
    }
    
    public static void main(String[] args) {
    	
    	
    }
    
    
}
