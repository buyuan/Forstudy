/**
 * 148. Sort List
Medium

5545

197

Add to List

Share
Given the head of a linked list, return the list after sorting it in ascending order.
 */
package LeetCode;

public class T148 {
		public class ListNode {
			int val;
			ListNode next;
			ListNode() {}
			ListNode(int val) { this.val = val; }
			ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		}

	    public ListNode sortList(ListNode head) {
	    	if(head==null ||head.next ==null) {
	    		return head;
	    	}
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while(fast!=null && fast.next!=null) {
	        	slow = slow.next;
	        	fast = fast.next.next;
	        }
	        ListNode mid = slow.next;
	        slow.next = null;
	        return merge(sortList(head),sortList(mid));
	    }
	    
	    private  ListNode merge(ListNode s1, ListNode s2) {
			// TODO Auto-generated method stub
	    	ListNode dummyHead = new ListNode();
	    	ListNode cur = dummyHead;//where it start
	    	while(s1!=null&&s2!=null) {
	    		if(s1.val<s2.val) {
	    			cur.next = s1;
	    			s1 = s1.next;
	    		}else {
	    			cur.next = s2;
	    			s2 = s2.next;
	    		}
	    		cur = cur.next;
	    	}	    	
	    	if(s1!=null) {
	    		cur.next = s1;
	    	}
	    	if(s2!=null) {
	    		cur.next = s2;
	    	}
			return dummyHead.next;
		}

		public static void main(String[] args) {
			int testcase[] = {-1,5,3,4,0};
			T148 outter= new T148();
			T148.ListNode head = outter.new ListNode();
			T148.ListNode cur =head;
	    	for(int i =0;i<testcase.length;i++) {
	    		cur.next = outter.new ListNode(testcase[i]);
	    		cur = cur.next;
	    	}
	    	T148.ListNode ans = outter.sortList(head.next);
	    	while(ans!=null) {
	    		System.out.println(ans.val);
	    		ans = ans.next;
	    	}
	    }
}
