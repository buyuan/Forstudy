/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Medium
Given an array of integers nums and an integer limit, return the size of 
the longest non-empty subarray such that the absolute difference between any 
two elements of this subarray is less than or equal to limit.

 

Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2 
Explanation: All subarrays are: 
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4. 
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4. 
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4 
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute
diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= limit <= 109
 */
package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;



public class T1438 {
    public static int longestSubarray(int[] nums, int limit) {
//        PriorityQueue<Integer> min = new PriorityQueue<>();
//        PriorityQueue<Integer> max = new PriorityQueue<>((x,y)->(y-x));
        Deque<Integer> min = new LinkedList<>(); ;
        Deque<Integer> max= new LinkedList<>();;
        int left=0;
        int ans=0;
        for(int right=0;right<nums.length;right++) {
        	while(!min.isEmpty()&&min.peekLast()>nums[right]) {
        		min.pollLast();
        	}
        	while(!max.isEmpty()&&max.peekLast()<nums[right]) {
        		max.pollLast();
        	}
        	min.offerLast(nums[right]);
        	max.offerLast(nums[right]);
        	
        	while(max.peekFirst()-min.peekFirst()>limit) {
        		if(max.peekFirst()==nums[left]) {
        			max.pollFirst();
        		}
        		if(min.peekFirst()==nums[left]) {
        			min.pollFirst();
        		}
        		left++;
        	}
        	ans = ans>(right-left+1)?ans:(right-left+1);
        }
        return ans;
    }

    
    public static void main(String[] args) {
    	int[] case1 = {8,2,4,7}; int l1 = 4;
    	int[] case2 = {10,1,2,4,7,2}; int l2 = 5;
    	int[] case3 = {4,2,2,2,4,4,2,2};int l3 = 0;
    	int[] case4 = {18,100,79,85,88,90,11,57,31,49,56,51,22,42,57,17,80,63,28,16,56,77,69,53,
    	               16,85,38,36,32,49,96,72,1,25,68,57,75,3,4,81,78,32,34,27,23,37,19,
    	               70,26,35,40,75,97,33,88,58,22,70,46,63,54,16,99,27,74,50,27,37,
    	               14,4,16,73,96,2,70,38,87,98,93,84,18,10,65,48,74,40,56,65,87,46,98,68,42,1,16,57,92}; int l4 =55; 
    	               
    	int[] case5 =  {24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,
    			21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,
    			14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,
    			89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39};int l5 =87;//result =25
    	               
    	int[] test = case5;int l =l5;
    	int result = longestSubarray(test,l);
    	
    	System.out.println(result);
    }
}
