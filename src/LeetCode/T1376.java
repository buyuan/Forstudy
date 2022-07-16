
/*
 * 1376. Time Needed to Inform All Employees
Medium
A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.

 

Example 1:

Input: n = 1, headID = 0, manager = [-1], informTime = [0]
Output: 0
Explanation: The head of the company is the only employee in the company.
Example 2:


Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
Output: 1
Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown.
 

Constraints:

1 <= n <= 105
0 <= headID < n
manager.length == n
0 <= manager[i] < n
manager[headID] == -1
informTime.length == n
0 <= informTime[i] <= 1000
informTime[i] == 0 if employee i has no subordinates.
It is guaranteed that all the employees can be informed.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class T1376 {
	//这个题的意思，其实就是有可能深度为1，但是time不一定为1，相当于有权重的树,注意，这个时间是leader通知所有下属的总时间
	
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //1. 建立树，其实就是每个节点和直接子节点的关系
    	HashMap<Integer,ArrayList<Integer>> org = new HashMap<>();
    	for(int i=0;i<manager.length;i++) {
    		int leader = manager[i];
    		if(leader==-1) {
    			//boss has no leader
    			continue;
    		}
    		ArrayList<Integer> tmp = org.getOrDefault(leader, new ArrayList<Integer>());
    		tmp.add(i);
    		org.put(leader, tmp);
    		
    	}
    	//2.遍历树，遍历过程中记录最大的权重值
    	Queue<int[]> qu = new LinkedList<>();
    	int[] first = {headID,informTime[headID]};//这个意思是，head通知到下属到总时间
    	qu.add(first) ;
    	Set<Integer> st = new HashSet<>();//Use  to store visited point
    	int res =0;
    	while(!qu.isEmpty()) {
    		//BSF from head，means everytime, from the header to employee level by level
    		//find the largest time every round
    		int size = qu.size();	
    		//不能一层一层取最大值这么走，因为可能某一层某个特别慢，其他多层的已经跑完了，】=
    		//所以，可以记录走到某个节点，然后这个节点往下走的总时间，
    		//应该用通知到所有人为止的思路
    		for(int i=0;i<size;i++) {
    			int[] cur = qu.poll();
    			int ID = cur[0];
    			int time = cur[1];
    			
    			
    			if(!org.containsKey(ID)) {
    				//没有进leader map，说明已经到达了底层员工，所以这次循环可以跳过
    				continue;
    			}
    			res = Math.max(res,time);//到当前为止的最大时间
    			
    			for(int e:org.get(ID)) {
    				//存这个点到下个点的总
    				int[] ele = {e,informTime[e]+time};
    				qu.add(ele);
    			}
    		}
    		
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	//test 1
    	int n1= 7; int headID1 = 6;
    	int[] manager1 = {1,2,3,4,5,6,-1};
    	int[] inforTime1 = {0,6,5,4,3,2,1};
    	//test2
    	int n2= 11; int headID2 = 4;
    	int[] manager2 = {5,9,6,10,-1,8,9,1,9,3,4};
    	int[] inforTime2 = {0,213,0,253,686,170,975,0,261,309,337};//
    	
    	//test
    	int n = n2; int headID = headID2;
    	int[] manager = manager2;
    	int[] inforTime = inforTime2;
    	
    	System.out.println(numOfMinutes(n,headID,manager, inforTime));
    }

}
