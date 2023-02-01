package LeetCode;

import java.util.HashMap;

public class T740 {
    public int deleteAndEarn(int[] nums) {
        //max(x) =max(max(maxPoints(num - 1), maxPoints(num - 2) + points[num]))
    	//1.将nums转换为 值和对应可以得分数的map
    	HashMap<Integer, Integer> point = new HashMap<>();
    	int max = 0;
    	for (int i:nums) {
    		point.put(i, point.getOrDefault(i, 0)+i);
    		max = Math.max(max,i);
    	}
    	//从最大的往下找
    	HashMap<Integer, Integer> maxScore = new HashMap<>();
    	return maxScore(max,point,maxScore);
    	
    }

	private int maxScore(int num, HashMap<Integer,Integer> point,HashMap<Integer,Integer>  maxScore) {
		if(num==0) {
			return 0;
		}
		if(num==1) {
			return point.getOrDefault(1, 0);
		}
		if(maxScore.containsKey(num)) {
			return maxScore.get(num);
		}
		int cur = point.getOrDefault(num, 0);
		maxScore.put(num, Math.max(maxScore(num-1,point,maxScore), maxScore(num-2,point,maxScore)+cur));
		return maxScore.get(num);
	}
    
}

/*
 * 740. Delete and Earn
Medium

5271

284

Add to List

Share
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104
Accepted
211,496
Submissions
367,796
*/
