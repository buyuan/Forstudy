package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res,cur,nums,0);
        return res;
    }
    
	private static void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int i) {
		res.add(new ArrayList<>(cur));
		if(i==nums.length) {
			return;
		}
		for(int j=i;j<nums.length;j++) {
			cur.add(nums[j]);
			helper(res,cur,nums,j+1);
			cur.remove(cur.size()-1);
		}
	}
	
	public static void main (String[] args) {
		int[] n1 = {1,2,3};
		
		int[] nums=n1;
		List<List<Integer>> res = subsets(nums);
		for(List<Integer> e: res) {		
			for( int i:e) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
}
/*
 * 78. Subsets
Medium

10937

164

Add to List

Share
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */