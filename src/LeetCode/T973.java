/**
 * 973. K Closest Points to Origin
Medium
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, 
return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104
Accepted
664,642
Submission
 */
package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;


public class T973 {
	//用priority queue,定义比较方法,入队时就能自动排序,指定队列的优先级,这样的话,只要peek一次就是目标
    public static int[][] kClosest(int[][] points, int k) {
    	//重写comparator
    	class newCompare implements Comparator<int[]>{
    		@Override
    		public int compare(int[] a, int[] b) {
    			return b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1];
    		}
    	}
    	newCompare mycom = new newCompare();
    	PriorityQueue<int[]> pq = new PriorityQueue(mycom);
    	for(int[] x:points) {
    		pq.offer(x);
    		while(pq.size()>k) {
    			pq.poll();
    		}
    	}
    	int[][] result = new int[k][k];
    	int size = pq.size();
    	for(int i=0;i<size;i++) {
    		result[i] = pq.poll();
    	}
    	return result;
    }
    public static int[][] kClosest_straight(int[][] points, int k) {
    	//直接计算,排序,但是这个会超时
    	for(int i=0;i<points.length-1;i++) {
    		for(int j=i+1;j<points.length;j++) {
    			if(compare(points[i],points[j])) {
    				int[] temp = points[i];
    				 points[i] = points[j];
    				 points[j] = temp;
    			}
    		}
    	}
    	int[][] result = new int[k][k];
		for(int i=0;i<k;i++) {
			result[i] = points[i];
		}
		return result;
    }
    private static boolean compare(int[] is, int[] is2) {
    	return (is[0]*is[0]+is[1]*is[1]-is2[0]*is2[0]-is2[1]*is2[1])>0?true:false;
	}
	public static void main(String[] args) {
    	int[][] case1 = {{1,3},{-2,2}}; int k1 = 1;
    	int[][] case2 = {{3,3},{5,-1},{-2,4}}; int k2 = 2;
    	
    	
    	int[][] testcase = case1;int k=k1;
    	int[][] result = kClosest_straight(testcase, k);
    	for(int[] x:testcase) {
    		for(int y:x) {
    			System.out.print(y+",");
    		}
    		System.out.print("|");
    	}
    	System.out.println();
    	for(int[] x:result) {
    		for(int y:x) {
    			System.out.print(y+",");
    		}
    		System.out.print("|");
    	} 	
    }
	
}

