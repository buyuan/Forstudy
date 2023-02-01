package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T46 {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();     
        int[] visited = new int[nums.length];
        helper(res,cur, nums,0,visited);
		return res;       
    }

	private static void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int startIndex, int[] visited) {
		// TODO Auto-generated method stub
		if(startIndex==nums.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			//全排列，所以从0开始，但是要注意，不能重复拿已经拿过的值
			if(visited[i]==1) {
				continue;
			}
			visited[i]=1;
			cur.add(nums[i]);
			helper(res,cur,nums, startIndex+1, visited);
			cur.remove(cur.size()-1);
			visited[i]=0;
		}
	}
	
	public static void main(String[] args) {
		int[] n1 = {1,2,3};
		
		int[] nums =n1;
		List<List<Integer>> res = permute(nums);
		for(List<Integer> l:res) {
			for(int i:l) {
				System.out.print(i+",");
			}
			System.out.println();
		}
		
	}
}
