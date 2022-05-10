/**
 * [LeetCode] 281. Zigzag Iterator 
 * medium
Given two 1d vectors, implement an iterator to return their elements alternately.

Example:
Input
v1 = [1,2]
v2 = [3,4,5,6]

Output:[1,3,2,4,5,6]

Explanation:
By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,3,2,4,5,6].

Follow up: 
What if you are given k 1d vectors? How well can your 
code be extended to such cases?


Clarification for the follow up question:
The "Zigzag" order is not clearly defined and is ambiguous for 
k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". 

For example:
Input:
[1,2,3]
[4,5,6,7]
[8,9]
Output: 
[1,4,8,2,5,9,3,6,7]
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T281 {
	private static Queue<Integer> Q;
	public T281(List<Integer> v1 , List<Integer> v2) {
		Q = new LinkedList<Integer>();
		int n1 =  v1.size();
		int n2 =  v2.size();
		int n = n1>n2?n1:n2;
		for(int i=0;i<n;i++) {
			if(i<n1) {Q.offer(v1.get(i));}
			if(i<n2) {Q.offer(v2.get(i));}
		}
		
    }
	
	public int next() {
		return Q.poll();
	}
	
	public boolean hasNext() {
		if(Q.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] v1 = {1,2,3,4,5,6,7};
		int[] v2 = {10,20,30,40,50,60,70};
		ArrayList<Integer> L1 = new ArrayList<>();
		ArrayList<Integer> L2 = new ArrayList<>();
		for(int i:v1) {
			L1.add(i);
		}
		for(int i:v2) {
			L2.add(i);
		}
		T281 Q = new T281(L1,L2);
		while(Q.hasNext()) {
			System.out.print(Q.next()+",");
		}
	}
}

/**
 *Your ZigzagIterator object will be instantiated and called as such:
ZigzagIterator i = ZigzagIterator(v1, v2), []
while(i.hasNext()) v[f()] = i.next() 
 * 
 */

