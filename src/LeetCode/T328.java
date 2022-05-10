/**
 * 328. Odd Even Linked List
Medium

Given the head of a singly linked list, group all the nodes with odd indices together
followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain 
as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 */
package LeetCode;

public class T328 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
    public static ListNode oddEvenList(ListNode head) {
        //思路是把偶结点后面那个奇节点移到前面的奇节点后面,然后这个移过来的奇节点指向原来的最后一个奇节点的下一个节点(就是一开始的第二个节点)
    	//之后再各自向后移动一步
    	if(head==null||head.next==null) {
    		return head;
    	}
    	ListNode odd = head;
    	ListNode even = head.next;
    	while(even!=null&&even.next!=null) {
    		ListNode firstEven = odd.next;//这个其实永远是第一个偶节点
    		odd.next = even.next;//奇数节点指向下一个奇数节点,就是把下一个奇数节点移到这个奇数节点后面
    		even.next = even.next.next;//偶数节点指向下一个偶数节点,保证链表不断
    		odd.next.next = firstEven;//移动过来的奇数节点连上第一个偶数节点.
    		odd = odd.next;//当前的节点移动到下一个节点(之前移过来的原本是下一个奇数节点的那个节点,准备下一次循环
    		even = even.next;//当前节点指向下一个节点,原本的第二个偶数节点
    	}
    	return head;
    }
    public static ListNode oddEvenList2(ListNode head) {
    	//其实造出两条连,各自是奇数节点偶数节点,然后相连
       	if(head==null||head.next==null) {
    		return head;
    	}
    	ListNode odd = head;
    	ListNode even =head.next;
    	ListNode evenStart = head.next;
    	while(even!=null&&even.next!=null) {
    		odd.next = even.next;
    		odd = odd.next;
    		even.next = odd.next;
    		even = even.next;
    	}
    	odd.next = evenStart;
    	return head;
    }
    public static void main(String[] args) {
    	int[] nums1 = {1,2,3,4,5,6,7};
    	int[] nums2 = {1};
    	int[] nums3 = {};
    	int[] nums4 = {1,2,3,4,5,6};
    	
    	ListNode testcase = init(nums3);
    	System.out.println();
    	display(oddEvenList2(testcase));
    	
    }
	private static void display(ListNode head) {
		ListNode cur = head;
		while(cur!=null) {
			System.out.print(cur.val+",");
			cur = cur.next;
		}
		
	}
	private static ListNode init(int[] nums1) {
		ListNode head=null;
		ListNode cur =null;
		T328 out = new T328();
		for(int i : nums1) {
			System.out.print(i+",");
			if(head==null) {
				head = out.new ListNode(i);
				cur = head;
				continue;
			}
			cur.next = out.new ListNode(i);;
			cur =cur.next;
		}
		return head;
	}
}
