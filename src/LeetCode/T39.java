/*
 * 39. Combination Sum
Medium
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
 */

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,cur,candidates,target,0);      
        return res;   
    }

	private static void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int i) {
		if(target<0) {
			return;
		}
		if(target==0) {
			//不能直接丢cur进去，因为cur是引用，改变了之后，res中的还会改变	
			res.add(new ArrayList<>(cur));
			return;
		}
		for(int j=i;j<candidates.length;j++) {
			cur.add(candidates[j]);
			// 可以从自己开始，因为自己可以重复选
			helper(res,cur,candidates,target-candidates[j],j);
			cur.remove(cur.size()-1);
		}		
	}
	
	public static void main(String[] args) {
		int[] c1 = {3,2,6,7}; int t1 = 7;
		
		int[] candidates = c1; int target = t1;
		List<List<Integer>> res = combinationSum(candidates, target);
		for(List<Integer> ls:res) {
			for(int i :ls) {
				System.out.print(i);
				System.out.print(',');
			}
			System.out.println();
		}
	}
}
