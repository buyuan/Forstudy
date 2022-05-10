/*
 * 444. Sequence Reconstruction
Medium

445

1378

Add to List

Share
You are given an integer array nums of length n where nums is a permutation of the integers in the range [1, n]. You are also given a 2D integer array sequences where sequences[i] is a subsequence of nums.

Check if nums is the shortest possible and the only supersequence. The shortest supersequence is a sequence with the shortest length and has all sequences[i] as subsequences. There could be multiple valid supersequences for the given array sequences.

For example, for sequences = [[1,2],[1,3]], there are two shortest supersequences, [1,2,3] and [1,3,2].
While for sequences = [[1,2],[1,3],[1,2,3]], the only shortest supersequence possible is [1,2,3]. [1,2,3,4] is a possible supersequence but not the shortest.
Return true if nums is the only shortest supersequence for sequences, or false otherwise.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [1,2,3], sequences = [[1,2],[1,3]]
Output: false
Explanation: There are two possible supersequences: [1,2,3] and [1,3,2].
The sequence [1,2] is a subsequence of both: [1,2,3] and [1,3,2].
The sequence [1,3] is a subsequence of both: [1,2,3] and [1,3,2].
Since nums is not the only shortest supersequence, we return false.
Example 2:

Input: nums = [1,2,3], sequences = [[1,2]]
Output: false
Explanation: The shortest possible supersequence is [1,2].
The sequence [1,2] is a subsequence of it: [1,2].
Since nums is not the shortest supersequence, we return false.
Example 3:

Input: nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
Output: true
Explanation: The shortest possible supersequence is [1,2,3].
The sequence [1,2] is a subsequence of it: [1,2,3].
The sequence [1,3] is a subsequence of it: [1,2,3].
The sequence [2,3] is a subsequence of it: [1,2,3].
Since nums is the only shortest supersequence, we return true.
 

Constraints:

n == nums.length
1 <= n <= 104
nums is a permutation of all the integers in the range [1, n].
1 <= sequences.length <= 104
1 <= sequences[i].length <= 104
1 <= sum(sequences[i].length) <= 105
1 <= sequences[i][j] <= n
All the arrays of sequences are unique.
sequences[i] is a subsequence of nums.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T444 {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        //这是一个拓扑排序的题,但是需要保证,所有的顶点都有连接,不然没有唯一的supersequence,保证nums的顺序和拓扑排序的顺序一致,
    	//这样才能是最短(一样就是从入度为0的开始)
    	int n = nums.length;
    	//vertex, and the vertexs directed 
    	HashMap<Integer,ArrayList<Integer>> vertex = new HashMap<>();
    	//vertex graphh and the indegree
    	HashMap<Integer,Integer> indegree = new HashMap<>();
    	for(List<Integer> ls:sequences) {
    		int size=ls.size();
    		if(size==1) {
    			int vert = ls.get(0);
    			if(!vertex.containsKey(vert)) {
    				vertex.put(ls.get(0), new ArrayList<Integer>());
    			}
    			if(!indegree.containsKey(vert)) {
    				indegree.put(vert,0);
    			}
    			
    		}
    		for(int i =0;i<size-1;i++) {
    			//这个部分代码不太好,如果seq只有一个顶点,就进不了,所以在前面加一个size的判断,要不要特别加入
    			int one = ls.get(i);
    			int two = ls.get(i+1);
    			ArrayList<Integer> cur = vertex.getOrDefault(one, new ArrayList<Integer>());
    			cur.add(two);
    			vertex.put(one, cur);
    			if(!vertex.containsKey(two)) {
    				//incase miss some vertex
    				vertex.put(two, new ArrayList<Integer>());
    			}
    			if(!indegree.containsKey(one)) {
    				//initial the in degree
    				indegree.put(one, 0);
    			}
    			Integer temp = indegree.getOrDefault(two, 0);
    			indegree.put(two, temp+1);
    		}
    		
    	}
    	
    	Queue<Integer> topS = new LinkedList<>();
    	
    	//start topology sort
    	for(int i:indegree.keySet() ) {
    		if(indegree.get(i)==0) {
    			topS.add(i);
    		}
    	}
     	if(topS.size()>1) {
     		//有两个入度大于0的,说明没有固定的先后顺序,所以没有唯一的supersecquency
     		return false;
     	}
     	int count =0;//用来跑完后判断top排序后的长度是不是等于n
     	while(!topS.isEmpty()) {
     		if(topS.size()>1) {
         		return false;
         	}
     		int cur = topS.poll();
     		count++;
     		for(int ver:vertex.get(cur)) {
     			int inde = indegree.get(ver);
     			indegree.put(ver, --inde);
     			if(inde==0) {
     				//去掉一个入度后这个顶点入度为0
     				topS.add(ver);
     			}
     		}
     	}
     	return count==n;
    }
}
