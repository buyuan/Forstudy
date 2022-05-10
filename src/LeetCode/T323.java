/*
 * 323. Number of Connected Components in an Undirected Graph
Medium
You have a graph of n nodes. You are given an integer n and an
 array edges where edges[i] = [ai, bi] indicates that there is an edge 
 between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T323 {
    public int countComponents(int n, int[][] edges) {
        //最重要的是要创建adjacent list,即某个节点的所有相邻节点,
    	//这样每个节点用DFS遍历,当遍历玩以后,如果发现未遍历的节点
    	//即重新开始DFS,那么说明是一个新的未联通的component
    	
    	
    	boolean[] visitedNodes = new boolean[n];//for record the nodes and check if visited default is false
    	List<Integer>[] adjList = new ArrayList[n];//the index is for node and list is for the adjacent node
    	//initial the array
    	for(int i=0;i<n;i++) {
    		adjList[i]=new ArrayList<Integer>();
    	}
    	for(int i=0;i<edges.length;i++) {
        	//initial the list  ,
    		//node(the first value of edges as the list index->
    		// the second value as adj node(as the list value))
    		adjList[edges[i][0]].add(edges[i][1]);
    		//the second as index, the first as the adj node
    		adjList[edges[i][1]].add(edges[i][0]);
    	}
    	
    	int result=0;
    	for(int i=0;i<n;i++) {
    		if(!visitedNodes[i]) {
    			//not visited, start a new DFS
    			result++;
    			visitedNodes[i]=true;
    			dfs(i,adjList,visitedNodes);
    			
    		}
    	}
    	return result;
    }

	private void dfs(int node, List<Integer>[] adjList, boolean[] visitedNodes) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<adjList[node].size();i++) {
			int nextNode = adjList[node].get(i);
			if(!visitedNodes[nextNode]) {
				//a un visited node
				visitedNodes[nextNode]=true;
				dfs(nextNode,adjList,visitedNodes);
			}
		}
	}
}
