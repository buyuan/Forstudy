/**
 * 162. Find Peak Element
Medium

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index.
 If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2,
 or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */
package LeetCode;

public class T162 {
    public int findPeakElement(int[] nums) {
        //因为两头是负无穷,且不会出现连续相当的数据,说明肯定有一个局部的峰值, 换句话说,曲线不能平,为了打到两头都是最低的,所以只能有升有降
    	//实际我还是不是特别能确定为什么这样能找到,这个太是个数学问题了....
    	int left =0;int right = nums.length-1;
    	while(left<right) {
    		int mid = left+(right-left)/2;
    		if(nums[mid]<nums[mid+1]) {
    			//说明过mid这个点,左右都是增,所以往右边走, 右边肯定有先增后降
    			left =mid+1; 			
    		}else {
    			right = mid;
    			
    		}	
    	}
    	return left;
    }
}
