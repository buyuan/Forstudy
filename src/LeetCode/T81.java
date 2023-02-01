package LeetCode;

public class T81 {
	public static boolean search(int[] nums, int target) {
		/*一开始想用左右移动先把两边相等情况错开，但是发现，可能影响数组的生序排列
		//adjut the arry, 保证不出现左右相当,但是需要左移动，因为左右相等，把左移动到右
		//不影响右边的非降序
		if(nums.length==1) {
			if (nums[0]==target){
				return true;
			}else {
				return false;
			}
		}
		while(nums[0]==nums[nums.length-1]) {
			int temp = nums[0];
			for(int i=0;i<nums.length-1;i++) {
				nums[i]=nums[i+1];
			}
			nums[nums.length-1]=temp;
		}
		*/
		if(nums.length==1) {
			if (nums[0]==target){
				return true;
			}else {
				return false;
			}
		}
		int left = 0;
		int right = nums.length-1;
		while(left<=right) {
			int mid = left+(right-left)/2;
			if(nums[mid]==target) {
				return true;
			}
			if(nums[mid]==nums[right]) {
				//说明重复点刚好等于右边，跳过
				right--;
			}else if(nums[mid]==nums[left]) {
				left++;
			}else if(nums[mid]>nums[right]) {
				//上半
				if(target<nums[mid] && target>=nums[left]) {
					right = mid-1;
				}else {
					left = mid+1;
				}
			}else if(nums[mid]<nums[right]){
				//下半
				if(nums[mid]<target&&target<=nums[right]) {
					left=mid+1;
				}else {
					right=mid-1;
				}
			}
		}
		return false;
    }
	public static void main(String[] args) {
		
		
		int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
		int target = 2;
		
		System.out.println(search(nums,target));
	}
}


/*
81. Search in Rotated Sorted Array II
Medium
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104

*/