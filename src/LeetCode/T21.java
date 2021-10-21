package LeetCode;

public class T21 {
	public static void main(String[] args) {
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(4);
		ListNode L2 = new ListNode(1);
		L2.next = new ListNode(3);
		L2.next.next = new ListNode(4);
		ListNode ans = 	mergeTwoLists(L1,  L2);
		ListNode temp = ans;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ListNode head = new ListNode();
		 ListNode cur  = head;
		 while(l1!=null&&l2!=null) {
			 if(l1.val<l2.val) {
				 cur.next = l1;
				 l1=l1.next;
			 }else {
				 cur.next = l2;
				 l2=l2.next;
			 }
			 cur = cur.next;
		 }
		 if(l1==null) {
			 cur.next = l2;
		 }else {
			 cur.next = l1;
		 }
		 return head.next;
	 }
}
/**
 * Take out in a seperate class
 * @author cbuyu
 *class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

 */
