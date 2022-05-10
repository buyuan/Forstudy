/**
 * 876. Middle of the Linked List
Easy
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
 */
package LeetCode;

public class T876 {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
    public static ListNode middleNode(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast!=null&&fast.next!=null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    public static void main(String[] args) {
    	int[] init1 = {1,2,3,4,5};
    	int[] init2 = {1,2,3,4,5,6};
    	ListNode head1 = initial(init1);
    	ListNode head2 = initial(init2);
    	
    	ListNode test = head2;
    	
    	display(test);
    	System.out.println();
    	ListNode result = middleNode(test);
    	System.out.println(result.val);
    	display(result);
    }
	private static void display(ListNode test) {
		// TODO Auto-generated method stub
		while(test!=null) {
			System.out.print(test.val+",");
			test = test.next;
		}
		
	}
	private static ListNode initial(int[] init) {
		// TODO Auto-generated method stub
		ListNode head = null;
		ListNode cur = null;
		T876 out = new T876();
		for(int e: init){
			if(head==null) {
				head = out.new ListNode(e);
				cur = head;
				continue;
			}
			cur.next =  out.new ListNode(e);
			cur = cur.next;
		}
		return head;
	}

}
