package LeetCode;
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
		System.out.println(threeSumClosest_better(nums1, target1));
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
