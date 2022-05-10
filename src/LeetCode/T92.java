/**
 * 92. Reverse Linked List II
Medium

Given the head of a singly linked list and two integers left and right where left <= right,
 reverse the nodes of the list from position left to position right,
  and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
 */
package LeetCode;

public class T92 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	//思路是把需要反转的链表截出来,保留左边界和右边界,然后反转后左边连左边,右边连右边,但是注意如果从第一个开始反转,这个时候没有左边界的情况
    public static ListNode reverseBetween(ListNode head, int left, int right) {
    	ListNode leftEdge = null;
    	ListNode rightEdge = null;
    	ListNode cur =null;
    	int tempLeft = left;
    	while(tempLeft-1>0) {
    		tempLeft--;
    		if(cur == null) {//first time initial the cur 
    			cur = head;
    			continue;
    		}
//    		if(cur==null){
//    			return head;//in case the left is bigger than the size of the link
//    		}
    		cur = cur.next;
    	}
    	leftEdge = cur;//find the left adjacent to the node that should be reversed
    	//start to reverse the node 
    	ListNode pre = null;
    	ListNode next = null;
    	if(cur!=null) {
    		cur = cur.next;//the first position of the link to be reversed 
    	}else {
    		cur = head;//means start from the first node, left ==1 or only one node
    	}
    	
    	ListNode rightBound = cur;//	
    	int count = right-left +1;
    	for(int i=0;i<count;i++) {//reverse the next count node
    		if(i ==count-1) {
    			rightEdge = cur.next;//the node right adjacent to the right edge;
    		}
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	if(leftEdge!=null) {
    		leftEdge.next = pre;    	 //combine the left part to left edge of the reversed link,if it exist
    	}else {
    		head = pre;//start from the first node, so pre is the new first node
    	}
    	rightBound.next =rightEdge;//combine the right part
    	
    	return head;
    }	  
    
	//优化一下, 如果在前面加油一个dummy节点,用上面截断的思路来避免单独处理边界问题,中间反转用的是新建的连
    public static ListNode reverseBetween_update(ListNode head, int left, int right) {
		T92 out = new T92();
    	ListNode dummy = out.new ListNode(-1);
    	ListNode pre = dummy;
    	dummy.next = head;
    	
    	for(int i=0;i<left-1;i++) {
    		//走到需要反转前的位置的前面一个
    		pre = pre.next;
    	}
    	ListNode leftEdge = pre;//use to link the reversed link
    	ListNode rightBound=null;//use to link right part;
    	ListNode rightEdge =null;//the first node of the part;
    	ListNode cur = null;
    	if(pre.next!=null) {
        	cur =pre.next;//in case pre gets to the last node or the second last, 
        	rightBound = cur;
    	}else {
    		return head;//second last node, then no need to reverse the node after, since only one or zero
    	}
    	ListNode next = null;
    	ListNode before=null;
    	int count = right-left+1;
    	for(int i=0;i<count;i++) {//reverse the next count node
    		if(i ==count-1) {
    			rightEdge = cur.next;//the node right adjacent to the right edge;
    		}
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	rightBound.next =rightEdge;
    	leftEdge.next = pre;    
    	return dummy.next;   	
    }
	//优化一下, 如果在前面加油一个dummy节点,那么就用同一套逻辑了,不需要单独考虑从1开始的情况,相当于一次遍历,走到该反转的地方就反转,也不用单独截出来,中间逆序用的是交换的
    //概念,没有建立一个新的链表,和之前的全链反转不一样,在旧的链上处理
    public static ListNode reverseBetween_update2(ListNode head, int left, int right) {
		T92 out = new T92();
    	ListNode dummy = out.new ListNode(-1);
    	ListNode pre = dummy;
    	dummy.next = head;
    	
    	for(int i=0;i<left-1;i++) {
    		//走到需要反转前的位置
    		pre = pre.next;
    	}
    	ListNode cur = null;
    	if(pre.next!=null) {
        	cur =pre.next;//in case pre gets to the last node or the second last, 
    	}else {
    		return head;//second last node, then no need to reverse the node after, since only one or zero
    	}
    	ListNode next = null;

    	for(int i=left;i<right;i++) {//start to reverse,.next一方面是指向它,另一方面也是后面的节点往后走了一步
    		next = cur.next;//next =3
    		cur.next = next.next;//2->4
    		next.next = pre.next;//3->2, 
    		pre.next = next;//1->3
    	}	
    	return head;   	
    }

	public static void main(String[] args) {
		//test case
		int[] nums1 = {1,2,3,4,5};
		int left1 = 2;
		int right1 = 4;
		//---
		int[] nums2 = {5};
		int left2 =1;
		int right2 = 1;
		//---
		int[] nums3 = {1,2,3,4,5};
		int left3 =1;
		int right3 = 4;
		//testcase initialize
		ListNode testHead = init(nums1);
		int tLeft = left1;
		int tRight = right1;
		//start test
		//display(testHead);
		ListNode result = reverseBetween_update(testHead, tLeft, tRight);
		display(result);
		
	}

	private static void display(ListNode testHead) {
		ListNode cur = testHead;
		while(cur!=null) {
			System.out.print(cur.val+",");
			cur = cur.next;
		}
		System.out.println();
		System.out.println("=================================");
	}

	private static ListNode init(int[] nums) {
		ListNode head = null;
		ListNode cur = null;
		T92 out = new T92();
		for(int e:nums) {
			if(head == null) {
				head = out.new ListNode(e);
				cur = head;
				continue;
			}
			cur.next = out.new ListNode(e);
			cur = cur.next;
		}
		return head;
	}
}
