/**
 * 160. Intersection of Two Linked Lists
Easy

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. 
If you correctly return the intersected node, then your solution will be accepted.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T160 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //把长的那个链表,指针移动到和短的那个等长的地方,开始遍历就好,因为长的链条的长出来的那部分不可能和短的相交,因为相交之后的部分,长短链条长度是相等的
    	int lengthA = getLength(headA);
    	int lengthB = getLength(headB);
    	int step =0;
    	if(lengthA>lengthB) {
    		for(int i=0;i<lengthA-lengthB;i++) {
    			headA=headA.next;
    		}
    	}else {
    		for(int i=0;i<lengthB-lengthA;i++) {
    			headB=headB.next;
    		}
    	}
    	while(headA!=null&&headB!=null&&headA!=headB) {
    		headA=headA.next;
    		headB=headB.next;
    	}
    	
    	return (headA!=null&&headB!=null)?headA:null;
    }
    
    private static int getLength(ListNode head) {
		// TODO Auto-generated method stub
    	ListNode cur = head;
    	int count =0;
    	while(cur!=null) {
    		cur = cur.next;
    		count++;
    	}
		return count;
	}
    public static ListNode initialLink(int[] nums) {
    	if(nums.length==0) {
    		return null;
    	}
    	ListNode head = null;
    	ListNode cur = null;
    	T160 out = new T160();
    	for(int ele : nums) {
    		if(head == null) {
    			head = out.new ListNode(ele);
    			cur  = head;
    			continue;
    		}
    		cur.next = out.new ListNode(ele); 		
    		cur = cur.next;
    		
    	}
    	return head;
    	
    	
    }
    public static void display(ListNode head) {
    	ListNode cur = head;
    	while(cur!=null) {
    		System.out.print(cur.val+",");
    		cur = cur.next;
    	}
    	System.out.println("display finished");
    }
    
    public static ArrayList<ListNode> initTestcase(int[] nums1, int[] nums2,int[] mix){
    	ListNode headA=null;
    	ListNode headB=null;
    	ArrayList<ListNode> result = new ArrayList<>();
    	headA = initialLink(nums1);
    	headB = initialLink(nums2);
    	append(mix,headA,headB);
    	result.add(headA);
    	result.add(headB);
    	return result;
    }
	private static void append(int[] mix, ListNode headA,ListNode headB) {
		// TODO Auto-generated method stub
		T160 out = new T160();
		ListNode cur =headA;
		ListNode lastB = headB;
		while(cur.next!=null) {
			cur = cur.next;
		}
		while(lastB.next!=null) {
			lastB = lastB.next;
		}
		cur.next =initialLink(mix);
		lastB.next=cur.next;
		
	}

	public static void main(String[] args) {
    	int[] Anums1 = {1,2,3,4,5,6,};
    	int[] Anums2 = {4,5,6};
    	int[] Amix = {7,8};
    	
    	ArrayList<int[]> testcase = createTestcase(Anums1,Anums2,Amix);
 
    	ArrayList<ListNode> result = initTestcase(testcase.get(0),testcase.get(1),testcase.get(2));
    	ListNode headA = result.get(0);
    	ListNode headB = result.get(1);
    	display(headA);
    	display(headB);
    	ListNode ans = getIntersectionNode(headA,headB);
    	display(ans);
    }

	private static ArrayList<int[]> createTestcase(int[] nums1, int[] nums2, int[] mix) {
		// TODO Auto-generated method stub
		ArrayList<int[]> testcase = new ArrayList<>();
		testcase.add(nums1);
		testcase.add(nums2);
		testcase.add(mix);
		return testcase;
	}
}
