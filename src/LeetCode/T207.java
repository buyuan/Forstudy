/*
 * 207. Course Schedule
Medium
There are a total of numCourses courses you have to take,
 labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 
0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course
 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class T207 {
	private static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
    	if(prerequisites.length==0) {
    		return true;
    	}
        //create the graph, the course and the related course
    	for(int[] c:prerequisites) {
    		ArrayList<Integer> cur= graph.getOrDefault(c[0], new ArrayList<Integer>()) ;
    		cur.add(c[1]);
			graph.put(c[0],cur);
    	}
    	//status of course, index is course, value 0 for unvisited, 1 for visiting 2 for visited
    	int[] course = new int[numCourses];
    	
    	for(int i=0;i<numCourses;i++) {
    		if(dfs(i,course)) {
    			return false;
    		}
    	}
    	return true;
    }
	private static boolean dfs(int i, int[] course) {
	//if found cycle ,return true;
		if(course[i]==1) {
			// come to a visiting node, means cycle
			return true;
		}
		if(course[i]==2) {
			return false;
		}
		course[i]=1;
		if(graph.containsKey(i)) {
			//未包含的就是单独的点,直接访问即可
			for(int cs : graph.get(i)) {
				if(dfs(cs,course)) {
					return true;
				}
			}
		}

		course[i]=2;
		return false;
	}
	
	public static void main(String[] args) {
		int n1 = 2; int[][] p1 = {{1,0}};
		int n2 = 1; int[][] p2 = {};
		int n3 = 2; int[][] p3 = {{0,1}};
		
		int numCourses = n3; int[][] prerequisites =p3;
		
		System.out.println(canFinish( numCourses,  prerequisites));
	}
}
