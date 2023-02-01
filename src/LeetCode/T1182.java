package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T1182 {
	public static void main(String[] args) {
		int[] c1= {2,1,2,2,1};
		int[][] q1= {{1,1},{4,3},{1,3},{4,2},{2,1}};
		
		int[] colors=c1; int[][] queries=q1;
		
		List<Integer> result = shortestDistanceColor(colors, queries);
		for(int x:result) {
			System.out.println(x);
		}
	}
    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        //用hashMap存每个颜色所在的位置数组。
    	//然后题目就变成了，在这个数组中，目标颜色离第一个位置最近的位置
    	HashMap<Integer,List<Integer>> mp = new HashMap<>();
    	for(int i=0;i<colors.length;i++) {
    		List<Integer> cur = mp.getOrDefault(colors[i], new ArrayList<>());
    		cur.add(i);
    		mp.put(colors[i], cur);
    	}
		List<Integer> result = new  ArrayList<>();
		for(int i=0;i<queries.length;i++) {
			if(!mp.containsKey(queries[i][1])){
				//没有这个颜色
				result.add(-1);
				continue;
			}
			int target = queries[i][0];
			List<Integer> curList = mp.get(queries[i][1]);
			//在这个list中，因为是有序的，（存的时候是从小到大位置存找到左边比target小，右边比target大的两个值，差距小的那个是答案
			//也可以遍历，不过会慢
			//用二分法查找这两个值
			/*
			 * 不用二分法，不用转数组了
		    int[] curArr = new int[curList.size()];
		    int index=0;
		    for(int x:curList) {
		    	curArr[index++] = x;
		    }
		    */
		   if(target<=curList.get(0)) {
			   //在最小的左边，那么第一个就是
			   result.add(curList.get(0)-target) ;
		   }else if(target>=curList.get(curList.size()-1)) {
			   //比最大的大，那么最大这个最近
			   result.add(target-curList.get(curList.size()-1)) ;
		   }else {
			   //在中间
			   //下面这个超时
			   /*
			   int res=Integer.MAX_VALUE;
			   for(int x:curArr) {
				   if(x>=target) {
					   res=res<(x-target)?res:x-target;
				   }else {
					   res=res<(target-x)?res:target-x;
				   }
			   }
			   result.add(res);
			   */
			   //剪枝一下，找到前大后小即可
               //人工二分法，强行剪枝
			   int mid = (curList.size()-1)/2;
			   int LEdge=0;int REdge=curList.size()-1;
			   if(curList.get(mid)<target) {
				   LEdge = mid;
			   }else {
				   REdge=mid;
			   }
               mid = LEdge+(REdge-LEdge)/2;
               if(curList.get(mid)<target) {
				   LEdge = mid;
			   }else {
				   REdge=mid;
			   }
               mid = LEdge+(REdge-LEdge)/2;
               if(curList.get(mid)<target) {
				   LEdge = mid;
			   }else {
				   REdge=mid;
			   }
               mid = LEdge+(REdge-LEdge)/2;
               if(curList.get(mid)<target) {
				   LEdge = mid;
			   }else {
				   REdge=mid;
			   }
			   int left=0;int right=0;
			   for(int i1=LEdge;i1<=REdge;i1++) {
				   if(curList.get(i1)<=target && curList.get(i1+1)>=target) {
					   left =curList.get(i1);
					   right=curList.get(i1+1);
					   break;
				   }
			   }
               result.add( Math.min(target-left, right-target));
			   /*
			    * 容易死xun huan
			    
			    
			   int l=0; int r=curArr.length-1;
			   int left=0; int right=0;
			   while(l<r) {
				   left=l; right=r;
				   int mid = l+(r-l)/2;
				   if(curArr[mid]>target) {
					   r=mid;
				   }else {
					   l=mid;
				   }
			   }
			   //上面的left，right就是边界
			   result.add( Math.min(target-curArr[left], curArr[right]-target));
			   */
		   }
		   
		}
		return result;
    	//也可找到这个颜色的所有位置，然后遍历，找最近的；
    	
    }
}
/*
1182. Shortest Distance to Target Color
Medium

453

20

Add to List

Share
You are given an array colors, in which there are three colors: 1, 2 and 3.

You are also given some queries. Each query consists of two integers i and c, return the shortest distance between the given index i and the target color c. If there is no solution return -1.

 

Example 1:

Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
Output: [3,0,3]
Explanation: 
The nearest 3 from index 1 is at index 4 (3 steps away).
The nearest 2 from index 2 is at index 2 itself (0 steps away).
The nearest 1 from index 6 is at index 3 (3 steps away).
Example 2:

Input: colors = [1,2], queries = [[0,3]]
Output: [-1]
Explanation: There is no 3 in the array.
 

Constraints:

1 <= colors.length <= 5*10^4
1 <= colors[i] <= 3
1 <= queries.length <= 5*10^4
queries[i].length == 2
0 <= queries[i][0] < colors.length
1 <= queries[i][1] <= 3
*/