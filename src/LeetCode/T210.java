/*
 * 210. Course Schedule II
Medium

6355

231

Add to List

Share
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class T210 {
	private static HashMap<Integer,ArrayList<Integer>> course = new HashMap<>();
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] res = new int[numCourses];
    	if(prerequisites.length==0) {
    		for(int i=0;i<numCourses;i++) {
    			res[i]=i;
    		}
    		return res;
    	}
        for(int[] c:prerequisites) {
        	ArrayList<Integer> cur = course.getOrDefault(c[0], new ArrayList<Integer>());
        	cur.add(c[1]);
        	course.put(c[0], cur);
        }
        //0 for unvisited, 1for visiting, 2 for visited, then added the list
        int[] courseState = new int[numCourses];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<numCourses;i++) {
        	if(dfs(i,courseState,result)) {
        		//
        		return new int[0];
        	}
        }      
        for(int i=0;i<numCourses;i++) {
        	res[i] = result.get(i);
        }
        return res;
    }
    
    private static boolean dfs(int i, int[] courseState, ArrayList<Integer> result) {
		// TODO Auto-generated method stub
    	if(courseState[i]==1) {
    		return true;
    	}
    	if(courseState[i]==2) {
    		return false;
    	}
    	courseState[i]=1;
    	if(course.containsKey(i)) {
    		ArrayList<Integer> cur = course.get(i);
    		for(int x:cur) {
    			if(dfs(x,courseState,result)){
    				return true;
    			}
    		}
    	}
    	courseState[i]=2;
    	result.add(i);
		return false;
	}

	public static void main(String[] args) {
    	int n1 = 2;int[][] p1 = {{1,0}};
    	int n2 = 4;int[][] p2 = {{1,0},{2,0},{3,1},{3,2}};	
    	int n3 = 1;int[][] p3 = {};
    	int n4 = 2;int[][] p4 = {{1,0},{0,1}};
    	int numCourses = n4;int[][] prerequisites = p4;
    	int[] ans = findOrder( numCourses,  prerequisites);
    	if(ans.length==0) {
    		System.out.println("null");
    	}else {
        	disp(ans);
    	}


    }

	private static void disp(int[] ans) {
		// TODO Auto-generated method stub
    	System.out.println();
		for(int i:ans) {
			System.out.print(i+",");
		}
    	System.out.println();
	}
}
