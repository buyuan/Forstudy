package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T1560 {
    public static List<Integer> mostVisited(int n, int[] rounds) {
    	
    	//思路，看这些round一共跑了多少步，然后把步数按照n来拆
    	int totalsteps=0;//起点算1
    	for(int i=0;i<rounds.length-1;i++) {
    		if(rounds[i+1]<rounds[i]) {
    			//套圈了
    			totalsteps+=n+rounds[i+1]-rounds[i];
    		}else {
    			totalsteps+=rounds[i+1]-rounds[i];
    		}
    	}
    	//开始跑，每逢n取模
    	int maxFre=0;
    	int[] res = new int[n];
    	//从某一点开始，一共到多少步
    	int start = rounds[0];
    	while(totalsteps>=0) {
    		int index = start%n;
    		res[index]++;
    		start++;
    		totalsteps--;
    		maxFre = maxFre>res[index]?maxFre:res[index];
    	}
        List<Integer> result = new ArrayList<>();
        boolean flag=false;//因为0是最大的，所以如果0入选，放在最后
        for(int i=0;i<res.length;i++) {
        	if(res[i]==maxFre) {
        		if(i==0) {
        			flag=true;
        		}else {
        			result.add(i);
        		}
        		
        	}
        }    	
        if(flag) {
        	result.add(n);
        }
        return result;
    	/*
        //HashMap<Integer,Integer> res = new HashMap<>();
        int[] res = new int[n];
        int maxFrq=0;
        int len = rounds.length;
        for(int i=0;i<len-1;i++) {
        	int start = rounds[i];
        	int end = rounds[i+1];
        	if(end<start) {
        		//套一圈了
        		end=end+n;
        	}
        	for(int j=start;j<=end;j++) {
        		//取模==0，实际上就是secter n
        		int index = j%n;
        		res[index]++;
        		maxFrq = maxFrq>res[index]?maxFrq:res[index];
        	}
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<res.length;i++) {
        	if(res[i]==maxFrq) {
        		if(i==0) {
        			result.add(n);
        		}else {
        			result.add(i);
        		}
        		
        	}
        }
        return result;
        /*
         * 下面是整个排序，其实如果只要找最大的，直接用Hashmap找最大就好
     
        //转一个次数和index的二维数组，然后用次数排序,需要用一位数组转二维，因为可能有的index没有累加
        int[][] temp = new int[n][2];
        for(int i=0;i<n;i++) {
        	temp[i][0]=res[i+1];
        	temp[i][1]=i+1;
        }
        //sort by the first value
        for(int i=0;i<n-1;i++) {
        	int cur = temp[i+1][0];
        	int j = i+1;
        	while(j>0 && cur<temp[j][0]) {
        		temp[j][0]=temp[j-1][0];
        		j--;
        	}
        	temp[j][0]=cur;
        }
        List<Integer> result = new ArrayList<>();
        for(int[] x:temp) {
        	result.add(x[1]);
        }
        return result;、
        */
    }
    public static void main(String[] args) {
    	int n1 = 4; int[] rounds1 = {1,3,1,2};
    	int n2 = 2; int[] rounds2 = {2,1,2,1,2,1,2,1,2};
    	int n3 = 7; int[] rounds3 = {1,3,5,7};
    	
    	int n = n1; int[] rounds = rounds1;
    	 List<Integer> result =mostVisited( n, rounds);
    	 System.out.println(result);
    	 
    }
}


/*
1560. Most Visited Sector in a Circular Track
Easy

Given an integer n and an integer array rounds. We have a circular track which consists of n sectors labeled from 1 to n. A marathon will be held on this track, the marathon consists of m rounds. The ith round starts at sector rounds[i - 1] and ends at sector rounds[i]. For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]

Return an array of the most visited sectors sorted in ascending order.

Notice that you circulate the track in ascending order of sector numbers in the counter-clockwise direction (See the first example).

 

Example 1:


Input: n = 4, rounds = [1,3,1,2]
Output: [1,2]
Explanation: The marathon starts at sector 1. The order of the visited sectors is as follows:
1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of round 3 and the marathon)
We can see that both sectors 1 and 2 are visited twice and they are the most visited sectors. Sectors 3 and 4 are visited only once.
Example 2:

Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
Output: [2]
Example 3:

Input: n = 7, rounds = [1,3,5,7]
Output: [1,2,3,4,5,6,7]
 

Constraints:

2 <= n <= 100
1 <= m <= 100
rounds.length == m + 1
1 <= rounds[i] <= n
rounds[i] != rounds[i + 1] for 0 <= i < m
*/