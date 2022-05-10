/*
 * 167. Two Sum II - Input Array Is Sorted
Medium
Given a 1-indexed array of integers numbers that is already sorted
 in non-decreasing order, find two numbers such that they add up to 
 a specific target number. Let these two numbers be numbers[index1]
  and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by 
one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You
 may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. 
We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3.
 We return [1, 3].
Example 3:


Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. 
We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */
package LeetCode;

import java.util.HashMap;

public class T167 {
    public static int[] twoSum_pointer(int[] numbers, int target) {
    	int left =0; int right =numbers.length-1;
    	int[] result = new int[2];
    	while(left<right) {
    		int sum = numbers[left]+numbers[right];
    		if (sum==target){
    			result[0]=left+1;
    			result[1]=right+1;
    			break;
    		}
    		if(sum>target) {
    			right--;
    		}else {
    			left++;
    		}
    	}
    	return result;
    }
    
    public static int[] twoSum_hash(int[] numbers, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();//value,index
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++) {
        	if(hm.containsKey(target-numbers[i])) {
        		result[0] = i+1;
        		result[1] = hm.get(target-numbers[i])+1;
        		break;
        	}        	
        	hm.put(numbers[i], i);
        }     
        return result;
    }
    
    public static void main(String[] args) {
    	int[] n1 = {2,7,11,15};int t1 = 9;
    	int[] n2 = {2,3,4};int t2 = 6;
    	int[] n3 = {-1,0};int t3 = -1;
    	
    	int[] n = n3;int t =t3;
    	
    	int[] res = twoSum_pointer(n,t);
    	display(res);
    	
    }

	private static void display(int[] res) {
		// TODO Auto-generated method stub
		for(int x:res) {
			System.out.print(x+",");
		}
		
	}
}
