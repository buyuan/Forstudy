/**
 * 264. Ugly Number II
Medium

3611

198

Add to List

Share
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class T264 {
    public static long nthUglyNumber(int n) {
    	//这个会溢出,
    	PriorityQueue<Long> pq = new PriorityQueue<>();
    	/**
    	 * 实际上,每一轮都是再找这一轮最小的数,
		然后用这个最小的数计算下一个最小的数,所以下一轮开始计算之前,要保证目前拿出来的这个数是去重之后最小的,不然下一轮又要用同一个数字来计算了.
    	 */
    	pq.offer((long)1);
    	for(int i=1;i<n;i++) {
    		long temp = pq.poll();
    		while(!pq.isEmpty()&&temp == pq.peek()) {
    			pq.poll();
    		}
//    		//避免溢出
//    		int non_neg= temp*2;
//    		if(non_neg>0) {
//    			pq.offer(non_neg);
//    		}
//    		non_neg= temp*3;
//    		if(non_neg>0) {
//    			pq.offer(non_neg);
//    		}    		
//    		non_neg= temp*5;
//    		if(non_neg>0) {
//    			pq.offer(non_neg);
//    		}
    		pq.offer(temp*2);
    		pq.offer(temp*3);
    		pq.offer(temp*5);

    	}

    	return pq.peek();
    }
    static ArrayList<Integer> result = new ArrayList<>();
    public static int nthUglyNumber_new(int n) {
    	//思路是,每次用2,3,5计算最小的丑数,
    	//被用到的那个方式的下标加1,
    	//静态变量再反复调用时候,仅作增量部分计算,所以过多个testcase的时候,减少计算量,但是需要在方法中让静态变量可以跑增量(比如超过size这类)
    	
    	int index2 =0;
    	int index3 =0;
    	int index5 =0;
    	int size =n;
    	result.add(1);
    	while(result.size()<n) {
    		int i2 =  result.get(index2)*2;
    		int i3 =  result.get(index3)*3;
    		int i5 =  result.get(index5)*5;
    		int min = i2<i3?(i2<i5?i2:i5):(i3<i5?i3:i5);
    		result.add(min);
    		if(min == i2) {index2++;}
    		if(min == i3) {index3++;}
    		if(min == i5) {index5++;}
    	}
    	return result.get(n-1);
    }
    
    public static void main(String[] args) {
    	int n1=10;
    	int n2=1;
    	int n3 = 1407;
    	int n4 = 1600;
    	int n5 = 11;
    	int tn = n3;
    	int res = nthUglyNumber_new(tn);
    	System.out.println(res);
    	
    	long res2 = nthUglyNumber(tn);
    	System.out.println(res);
    }

}
