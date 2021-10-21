
/**
 * 35. Search Insert Position
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
Eample 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:
Input: nums = [1], target = 0
Output: 0
 */
package LeetCode;

public class T35 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,6}; 
		int target = 4;
		System.out.println(searchInsert(nums, target));
	}
	
    public static int searchInsert(int[] nums, int target) {
        int leftSide = 0;
        int rightSide=nums.length-1;
        return(search(nums,target, leftSide,rightSide));
    }

	private static int search(int[] nums, int target, int leftSide, int rightSide) {
		// TODO Auto-generated method stub
		int mid = (leftSide+rightSide)/2;
		if(nums[0]>target) {
			return 0;
		}
		if(nums[rightSide]<target) {
			return rightSide+1;
		}
		//find a place where the target is in the middle 
		if(nums[mid]<target&&nums[mid+1]>target) {
			return mid+1;
		}
        if(nums[mid]<target) {
        	return search(nums,target,mid+1,rightSide);
        }
        if(nums[mid]>target) {       	
        	return search(nums,target,leftSide,mid-1);
        }else {
        	return mid;
        }
	}
}


















