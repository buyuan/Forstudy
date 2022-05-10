/*
 * 18. 4Sum
Medium
Given an array nums of n integers, return an array of all the unique 
quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	HashSet<List<Integer>> st = new HashSet<>();
        sort(nums);
        int size = nums.length;
        for(int i = 0;i<size-3;i++) {
        	if(i>0&&nums[i]==nums[i-1]) {
        		//剪枝
        		//不能用 nums[i]==nums[i+1]
        		continue;
        	}
        	for(int j=i+1;j<size-2;j++) {
            	if(j>i+1&&nums[j]==nums[j-1]) {
            		continue;
            	}
        		int l = j+1; int r =size-1;
        		while(l<r) {
            		int sum = nums[i]+nums[j]+nums[l]+nums[r];
        			int test1 = nums[l];
        			int test2 = nums[r];
        			if(sum==target) {
        				int t1 = nums[l];
        				int t2 = nums[r];
        				st.add(Arrays.asList(nums[i],nums[j],t1,t2));
   
        				while(l<r&&t1==nums[l+1]) {
        					l++;
        				}
        				while(l<r&&t2==nums[r-1]) {
        					r--;
        				}
        				l++;
        				r--;
        			}else if(sum>target) {
        				r--;
        			}else {
        				l++;
        			}    			
        		}
        	}
        }
		for (List<Integer> e: st) {
			result.add(e);
		}
        return result;
    }
    
    private static void sort(int[] nums) {
		// TODO Auto-generated method stub
    	int size = nums.length;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size-i-1;j++) {
    			if (nums[j+1]<nums[j]) {
    				int temp = nums[j];
    				nums[j]=nums[j+1];
    				nums[j+1]=temp;
    			}
    		}
    	}
		
	}

	public static void main(String[] args) {
    	int[] n1 = {1,0,-1,0,-2,2}; int t1 = 0;
    	int[] n2 = {2,2,2,2,2}; int t2 = 8;
    	int[] n3 = {-2,-1,-1,1,1,2,2}; int t3 = 0;
    	int[] n4 = {-3,-1,0,2,4,5}; int t4 = 2;
    	
    	int[] n =n4; int t =t4;
    	sort(n);
    	List<List<Integer>> result =fourSum(n,t);
    	dispay(result);
    }

	private static void dispay(List<List<Integer>> result) {
		// TODO Auto-generated method stub
		for(List<Integer> l : result) {
			for(int x :l) {
				System.out.print(x+",");
			}
			System.out.println();
		}
		
	}


}
