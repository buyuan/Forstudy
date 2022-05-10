/**
 * 349. Intersection of Two Arrays
Easy

Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class T349 {
	//于350不同之处,就是重复数字仅仅返回一次
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int i :nums1) {
        	hm.put(i,true);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i:nums2) {
        	if(hm.getOrDefault(i,false)) {
        		al.add(i);
        		hm.put(i,false);
        	}
        }
        int[] result = new int[al.size()];
        for(int i=0;i<al.size();i++) {
        	result[i]=al.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
    	int[] casea1 = {1,2,2,1};int[] caseb1 = {2,2};
    	int[] casea2 = {4,9,5};int[] caseb2 = {9,4,9,8,4};
    	
    	
    	int[] testA = casea1;int[] testB = caseb1;
    	
    	int[] result = intersection(testA,testB);
    	for(int i:result) {
    		System.out.print(i+",");
    	}
    	
    }
}
