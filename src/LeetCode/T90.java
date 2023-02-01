package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90 {
	 public static List<List<Integer>> subsetsWithDup(int[] nums) {
		 List<List<Integer>> res = new ArrayList<>();
		 List<Integer> cur = new ArrayList<>();
		 Arrays.sort(nums);
		 helper(res,cur, nums,0);
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
			while( j<(nums.length-1) && nums[j]==nums[j+1]) {
				//跳过重复
				j++;
			}
		}
	}
	
	public static void main (String[] args) {
		int[] n1 = {1,2,3};
		
		int[] nums=n1;
		List<List<Integer>> res = subsetsWithDup(nums);
		for(List<Integer> e: res) {		
			for( int i:e) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
}
