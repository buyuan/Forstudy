/**
 * 350. Intersection of Two Arrays II
Easy

Given two integer arrays nums1 and nums2, return an array of their intersection.
 Each element in the result must appear as many times as it shows in both arrays and you 
 may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;



public class T350 {
	//注意理解题目,找出两个数组中相同的数字,和位置,排列关系都无关
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int value;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i:nums1) {
        	value = hm.getOrDefault(i, 0);
        	value++;
        	hm.put(i,value);
        }
        for(int i:nums2) {
        	value = hm.getOrDefault(i, 0);
        	if(value>0) {
        		result.add(i);
        	}
        	value--;
        	hm.put(i,value);
        }
        
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++) {
        	res[i] = result.get(i);
        }
        return res;
    } 
    
    public static void main(String[] args) {
    	int[] casea1 = {1,2,2,1};int[] caseb1 = {2,2};
    	int[] casea2 = {4,9,5};int[] caseb2 = {9,4,9,8,4};
    	
    	
    	int[] testA = casea2;int[] testB = caseb2;
    	
    	int[] result = intersect(testA,testB);
    	for(int i:result) {
    		System.out.print(i+",");
    	}
    	
    }
}
