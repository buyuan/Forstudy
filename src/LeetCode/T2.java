/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */

package LeetCode;

public class T2 {
	public static void main(String[] args) {
		int[] a = {1,8};
		int[] b = {0};	
		ListNode l1 = new ListNode(a[0]);	
		ListNode last = l1;
		for(int i=1;i<a.length;i++) {
			ListNode node = new ListNode(a[i]);
			last.next = node;
			last      =  node;
		}
		ListNode l2 = new ListNode(b[0]);	
		last = l2;
		for(int i=1;i<b.length;i++) {
			ListNode node = new ListNode(b[i]);
			last.next = node;
			last      =  node;
		}
		
		ListNode ans = addTwoNumbers(l1,l2);
		System.out.println(ans);
		
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	boolean add=false;
    	ListNode ans = new ListNode(0);
    	ListNode tp =ans;
    	int temp = 0;
        while(l1!=null&&l2!=null) {    
        	if(add) {
        		temp=l1.val+l2.val+1;
        	}else {
        		temp=l1.val+l2.val;
        	}     	
        	if(temp>=10) {
        		add=true;
        		temp = temp-10;
        	}else {
        		add=false;
        	}
        	tp.next = new ListNode(temp);
        	tp = tp.next;
        	l1=l1.next;
        	l2=l2.next;
        	
        }
        //Below is wrong
        while(l1!=null) {
        	if(add) {
        		if(l1.val+1>=10) {
        			ListNode node = new ListNode(l1.val+1-10);
        			tp.next = node;
        			tp      =node;
        			l1=l1.next;
        			add = true;
        		}else {
        			ListNode node = new ListNode(l1.val+1);
        			tp.next = node;
        			tp      =node;
        			l1=l1.next;
        			add = false;
        		}
        	}else {
        		tp.next =l1;
        		break;
        	}
        }
        while(l2!=null) {
        	if(add) {
        		if(l2.val+1>=10) {
        			ListNode node = new ListNode(l2.val+1-10);
        			tp.next = node;
        			tp      =node;
        			l2=l2.next;
        			add = true;
        		}else {
        			ListNode node = new ListNode(l2.val+1);
        			tp.next = node;
        			tp      =node;
        			l2=l2.next;
        			add = false;
        		}
        	}else {
        		tp.next =l2;
        		break;
        	}
        }
        if(add) {
        	tp.next = new ListNode(1);
        }
        return ans.next;
    }	
  
}

/**
 * Defined in other class, just use it here
 * @author cbuyu
 *class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} 
 */



