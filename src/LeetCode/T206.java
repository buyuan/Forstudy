/**
 * 206. Reverse Linked List
Easy
Given the head of a singly linked list, reverse the list, and return the reversed list.
Follow up: A linked list can be reversed either iteratively or recursively.
 Could you implement both?
 */


package LeetCode;

public class T206 {
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

    public ListNode reverseList(ListNode head) {//iteration
    	ListNode pre = null;
    	ListNode cur = head;
    	ListNode next = null;
    	//要做的事情就是,依次找到节点,找到一个,把他反转指向前面一个节点
    	while(cur!=null) {
    		next = cur.next;//把下一个节点先存起来,以免丢失
    		cur.next = pre;//将当前节点反转,指向前面一个节点
    		pre =cur;//cur要往后走了,当cur往后走之后,cur的前一个节点就是现在的cur
    		cur = next;//cur往后走
    	}
    	//走完以后,当前节点走到了null,他的前一个节点就是新的头
    	return pre;
    }
    //递归的大体思路是,每一次调用,反转当前的节点, 在最深的那一次调用,拿到啊那个节点实际是新的头, 往上的调用是在反转当前的节点,而一直返回的是最深的那次调用获得的尾节点
    public ListNode reverseList_recursive(ListNode head) {//recursive
    	//base case
    	if(head==null) {//空节点
    		return head;
    	}
    	if(head.next==null) {//最后一个节点或者只有一个节点的链表
    		return head;
    	}
    	// start to recursive
    	ListNode reversedNode = reverseList_recursive(head.next);
    	head.next.next = head;//head.next是下一个节点, 这里做的就是将下一个节点指回head自己,(即下一个节点的下一个节点是head)
    	head.next = null;//断掉原来head.next指向的那个节点. 
    	
    	return reversedNode;//返回反转后的头部,
    }
    
    public static void main(String[] args) {
    	
    }
}
