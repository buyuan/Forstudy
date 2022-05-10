/*
 * 815. Bus Routes
Hard
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 
1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
You will start at the bus stop source (You are not on any bus initially), and you want to go to
 the bus stop target. You can travel between bus stops by buses only.

Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

 

Example 1:

Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Example 2:

Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
Output: -1
 

Constraints:

1 <= routes.length <= 500.
1 <= routes[i].length <= 105
All the values of routes[i] are unique.
sum(routes[i].length) <= 105
0 <= routes[i][j] < 106
0 <= source, target < 106
 */
package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class T815 {
    public static int numBusesToDestination_old(int[][] routes, int source, int target) {
    	/*
    	 * 题容易进的一个误区就是把 routes 直接当作邻接链表来进行图的遍历，其实是不对的，因为 routes 
    	数组的含义是，某个公交所能到达的站点，而不是某个站点所能到达的其他站点。这里出现了两种不同的结点，分别是站点和公交。而 routes 
    	数组建立的是公交和其站点之间的关系，那么应该将反向关系数组也建立出来，即要知道每个站点有哪些公交可以到达。由于这里站点的标号不一定是连续的，
    	所以可以使用 
    	HashMap，建立每个站点和其属于的公交数组之间的映射。
    	由于一个站点可以被多个公交使用，所以要用个数组来保存公交。既然这里求的是最少使用公交的数量，那么就类似迷宫遍历求最短路径的问题，
    	BFS 应该是首先被考虑的解法。
    	---摘自https://www.cnblogs.com/grandyang/p/10293947.html
    	 */
    	//
    	if(source==target) {return 0;}
        //#1 建立公交站和可到达该公交站的公交车的关系
    	HashMap<Integer,Set<Integer>> staAndBus = new HashMap<>();
    //	HashMap<Integer,Boolean> visitedSta = new HashMap<>();
    	Set<Integer> visitedSta = new HashSet<>();//记录到过的站
    	//用做过的公交车来标记才不会超时, 不然可能一个站一个站的遍历
    	boolean[] visitedBus = new boolean[routes.length];
    	for(int i=0;i<routes.length;i++) {
    		for(int j=0;j<routes[i].length;j++) {
    			Set<Integer> sta = staAndBus.getOrDefault(routes[i][j],new HashSet<Integer>());
    			sta.add(i);
    			staAndBus.put(routes[i][j], sta);  			
    		}
    	}
    	
    	//#2 start to BFS
    	
    	int result =1;//循环中是在跑完一轮才+1,因此实际最后一轮无法加入,所以在此加1
    	//add station to queue
    	Queue<Integer> station = new LinkedList<Integer>();
    	station.add(source);
    	station.add(null);//null作为新的一次车站探索的开始标志
    	while(!station.isEmpty()) {
    		Integer curSta = station.poll();
    		if(curSta==null) {
    			result++;
    			if(station.size()>0) {
    				//still more station need to traverse
    				station.add(null);
    			}
    			continue;
    		}
    		//visitedSta.add(curSta);
    		Set<Integer> bus = staAndBus.get(curSta);
    		for(Integer i :bus) {
    			if(visitedBus[i]) {
    				//这趟车做过了
    				continue;
    			}  	
    			visitedBus[i]=true;
    			for(int j=0;j<routes[i].length;j++) {
    				//find the possible station
    				int sta=routes[i][j];
    				if(sta==target) {
    					return result;
    				}
    				station.add(routes[i][j]);
    			}
    		}
    	}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
    	int[][] r1 = {{1,2,7},{3,6,7}}; int  s1 = 1; int t1 = 6;
    	int[][] r2 = {{7,12},{4,5,15},{6},{15,19},{9,12,13}};  int  s2 = 15; int t2 = 12;

    	int[][] routes = r1;int source = s1 ; int  target = t1;
    	
    	System.out.println(numBusesToDestination_old(routes, source, target));
    	
    }
}
