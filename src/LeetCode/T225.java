/**
 * 225. Implement Stack using Queues
Easy
Implement a last-in-first-out (LIFO) stack using only two queues. 
The implemented stack should support all the functions of a normal 
stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, 
peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a 
queue using a list or deque (double-ended queue) as long as you use only a queue's standard 
operations.
Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 */
package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class T225 {
	class MyStack {
		//用q2存最后一个入队的数,如果连续top,则记得从q1把最后一个入队的数据存到q2然后再返回
		private static Queue<Integer> q1,q2;
		//push,peek,pop, size, isempty
	    public MyStack() {
	    	q1 = new LinkedList<Integer>();
	    	q2 = new LinkedList<Integer>();
	    }
	    
	    public void push(int x) {
	        q2.offer(x);
	        while(q2.size()>1) {
	        	q1.add(q2.poll());
	        }
	    }
	    
	    public int pop() {
	        int result = top();
	        q2.poll();
	        return result;
	    }
	    
	    public int top() {
	        if(q2.isEmpty()) {
	        	int size = q1.size();
	        	for(int i=0;i<size-1;i++) {
	        		q1.offer(q1.poll());
	        	}
	        	q2.offer(q1.poll());
	        }
	        return q2.peek();
	    }
	    
	    public  boolean empty() {
	        return q1.isEmpty()&q2.isEmpty();
	    }
	}
	class MyStack_oneQ {
		//用q2存最后一个入队的数,如果连续top,则记得从q1把最后一个入队的数据存到q2然后再返回
		private static Queue<Integer> q;
		//push,peek,pop, size, isempty
	    public MyStack_oneQ() {
	    	q = new LinkedList<Integer>();
	    }
	    
	    public void push(int x) {
	    	q.offer(x);
	    	for(int i=0;i<q.size()-1;i++) {
	    		q.offer(q.poll());
	    	}
	    }
	    
	    public int pop() {
	    	return q.poll();
	    }
	    
	    public int top() {
	    	
	    	return q.peek();
	    }
	    
	    public  boolean empty() {
	        return q.isEmpty();
	    }
	}

	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6,7};
	
		MyStack ms = init(nums1);
		dispay(ms);
		ms.push(8);
		dispay(ms);
		System.out.println(ms.top());
		dispay(ms);
		System.out.println(ms.pop());
		dispay(ms);
		System.out.println(ms.empty());
		System.out.println("=============================================");		
		MyStack_oneQ ms2 = init2(nums1);
		dispay2(ms2);
		ms2.push(8);
		dispay2(ms2);
		System.out.println(ms2.top());
		dispay2(ms2);
		System.out.println(ms2.pop());
		dispay2(ms2);
		System.out.println(ms2.empty());
	}

	private static void dispay2(MyStack_oneQ ms) {
		for(int x:ms.q) {
			System.out.print(x+",");
		}
		System.out.println();
	}

	private static void dispay(MyStack ms) {
		// TODO Auto-generated method stub
		for(int x:ms.q1) {
			System.out.print(x+",");
		}
		for(int x:ms.q2) {
			System.out.print(x+",");
		}
		System.out.println();
	}

	private static MyStack init(int[] nums1) {
		T225 out = new T225();
		MyStack result = out.new MyStack();
		for(int i:nums1) {
			result.push(i);
		}
		return result;
	}
	private static MyStack_oneQ init2(int[] nums1) {
		T225 out = new T225();
		MyStack_oneQ result = out.new MyStack_oneQ();
		for(int i:nums1) {
			result.push(i);
		}
		return result;
	}
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */