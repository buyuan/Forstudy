/**
 * 23. Merge k Sorted Lists
Hard
You are given an array of k linked-lists lists,
 each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []
Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */
package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T23 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
    public static ListNode mergeKLists(ListNode[] lists) {
    	if(lists==null||lists.length==0) {
    		return null;
    	}
    	class mycompare implements Comparator<ListNode>{
    		@Override
    		public int compare(ListNode a,ListNode b) {
    			return a.val - b.val;
    		}
    	}
    	
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new mycompare());
        //The method below cannot avoid double link that lead to dead loop
//        for(ListNode lst:lists) {
//        	ListNode cur = lst;
//        	while(cur!=null) {
//        		pq.offer(cur);
//        		cur = cur.next;
//        	}
//        }
        for(ListNode lst:lists) {
        	if(lst ==null) {
        		continue;
        	}
        	pq.offer(lst);
        }
        T23 out = new T23();
        ListNode dummy = out.new ListNode(0);
        ListNode cur = dummy;
      //The method below cannot avoid double link that lead to dead loop
//        while(!pq.isEmpty()) {
//        	cur.next = pq.poll();
//        	cur = cur.next;
//        }
        //This will avoid dead loop
        while(!pq.isEmpty()) {
        	ListNode temp = pq.poll();
        	cur.next = temp;
        	cur = cur.next;
        	if(temp.next!=null) {
        		pq.offer(temp.next);
        	}
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
    	int[][] case1 = {{1,4,5},{1,3,4},{2,6}};
    	int[][] case2 = {};
    	int[][] case3 = {{}};
    	int[][] case4 = {{-2,-1,-1,-1},{}};
    	
    	ListNode[] testcase = gen(case4);
    	ListNode result = mergeKLists(testcase);
    	display(result);
    }

	private static void display(ListNode result) {
		T23 out = new T23();
		ListNode cur = out.new ListNode();
		cur = result;
		while(cur!=null) {
			System.out.print(cur.val+",");
			cur = cur.next;
		}
		
	}

	private static ListNode[] gen(int[][] case1) {
		T23 out = new T23();
		ListNode[] result = new ListNode[case1.length];
		int count=0;
		for(int[] x:case1) {
			ListNode dummy = out.new ListNode(0);
			ListNode cur = dummy;
			for(int i:x) {
				cur.next = out.new ListNode(i);
				cur = cur.next;
			}
			result[count++] = dummy.next;
		}
		return result;
	}
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */