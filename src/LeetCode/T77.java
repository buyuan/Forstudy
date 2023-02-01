/*
 * 77. Combinations
Medium

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
1 <= k <= n
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), k,n,1);
        return res;
        
        
    }

	private void helper(List<List<Integer>> res, ArrayList<Integer> cur, int numberLeft, int Upper,int leftBound) {
		if(numberLeft==0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		//从左边界开始遍历，
		for(int i=leftBound;i<=Upper;i++) {
			/*
			 * 应该是没有重复的
			if(cur.contains(i)) {
				//重复的不要
				continue;
			}
			*/
			cur.add(i);
			helper(res,cur,numberLeft-1,Upper,i+1);
			cur.remove(cur.size()-1);
		}
	}
}








