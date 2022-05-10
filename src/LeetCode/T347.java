/**
 * 347. Top K Frequent Elements
Medium
Given an integer array nums and an integer k, 
return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */
package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class T347 {
    public static int[] topKFrequent(int[] nums, int k) {
    	//number , frequency ,map
    	HashMap<Integer,Integer> counts = new HashMap<>();
    	for(int x:nums) {
    		counts.put(x,counts.getOrDefault(x,0)+1);
    	}
    	//->表达式, 箭头前面是参数,箭头后面是用什么方式操作参数,返回值(相当于传一个函数)
    	PriorityQueue<int[]> res = new PriorityQueue<int[]>((x,y)->(x[1]-y[1]));
    	for(int x:counts.keySet()) {
    		int[] item = {x,counts.get(x)};
    		res.offer(item);
    		while(res.size()>k) {
    			res.poll();
    		}
    	}
    	int[] result = new int[k];
    	int index =0;
    	while(!res.isEmpty()) {
    		result[index++]=res.poll()[0];
    	}
    	return result;
    	
    }
    
    public static void main(String[] args) {
    	int[] case1 = {1,1,1,2,2,3};int k1 = 2;
    	int[] case2 = {1};int k2 = 1;
    	
    	int[] testcase = case1;int k = k1;
    	int[] result =  topKFrequent(testcase,k);
    	
    	for(int x:result) {
    		System.out.print(x+",");
    	}
    }
}
