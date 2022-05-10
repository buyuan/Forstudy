/**
 * 540. Single Element in a Sorted Array
Medium

You are given a sorted array consisting of only integers 
where every element appears exactly twice, except for one element which 
appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 */
package LeetCode;

public class T540 {
    public static int singleNonDuplicate(int[] nums) {
        //分一半,如果这个mid和下一个相等,说明,如果落单的数字再左边,则右边肯定是奇数,如果落单再右边,则右边是偶数
    	int l =0; int rside = nums.length-1; int r = rside-1;
    	while(l<r) {
    		int mid = l+(r-l)/2;
    		if(nums[mid]==nums[mid+1]) {
    			//说明,右边已经单了一个,如果还有一个单的,则说明落单在右边,如果不是,则在左边
    			if((rside-mid)%2==0) {
    				//右边是双数,说明落单的在右边
    				l = mid+1;//l= mid+2,这样容易溢出,
    			}else {
    				r=mid;//r= mid-1, ,这样容易溢出,
    			}
    		}else {
    			if(mid==0||nums[mid]!=nums[mid-1]) {
    				return nums[mid];
    			}
    			//如果落单的在右边,则右边是单数
    			if((rside-mid)%2==0) {
    				r = mid;//r =mid-2,,这样容易溢出,
    			}else {
    				l=mid+1;
    			}
    		}
    	}
    	return nums[l];	
    }
    

    public static void main(String[] args) {
    	int[] n1 = {1,1,2,3,3,4,4,8,8};
    	int[] n2 = {3,3,7,7,10,11,11};
    	int[] n3 = {0,1,1};
    	
    	int[] n = n3;
     	System.out.println(singleNonDuplicate(n));
    }
}
