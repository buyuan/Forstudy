/*
 * 454. 4Sum II
Medium

Given four integer arrays nums1, nums2, nums3,
 and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 

Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
 

Constraints:

n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
package LeetCode;

import java.util.HashMap;

public class T454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //注意,这个题的目的是cout,不是找出坐标
    	HashMap<Integer , Integer> AB = new HashMap<>();//val,frequency
    	HashMap<Integer , Integer> CD = new HashMap<>();
    	int size = nums1.length;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			int t1 = nums1[i] + nums2[j];
    			int t2 = nums3[i] + nums4[j];
    			int fre = AB.getOrDefault(t1, 0);
    			AB.put(t1, fre+1);
    			fre = CD.getOrDefault(t2, 0);
    			CD.put(t2, fre+1);
    		}
    	}
    	int result=0;
    	for(int val:AB.keySet()) {
    		int fre = CD.getOrDefault(-1*val,0);
    		result+=AB.get(val)*fre;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	int[] n1 = {1,2}; int[] n2= {-2,-1};int[] n3 = {-1,2}; int[] n4 = {0,2};
    	
    	int[] t1 = n1; int[] t2= n2;int[] t3 = n3; int[] t4 = n4;
    	int result = fourSumCount(t1,t2,t3,t4);
    	System.out.println(result);
    }
}
