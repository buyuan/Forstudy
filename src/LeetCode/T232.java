/**
 * 232. Implement Queue using Stacks
Easy

2743

195

Add to List

Share
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 */
package LeetCode;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class T232 {
	class MyQueue {
		private Stack<Integer> mainStack;
		private Stack<Integer> fisrtValueStack;
		

	    public MyQueue() {
	    	mainStack 		= new Stack<>();
	    	fisrtValueStack = new Stack<>();
	    }
	    
	    public void push(int x) {
	    	fisrtValueStack.push(x);
	        while(fisrtValueStack.size()>1) {
	        	mainStack.push(fisrtValueStack.pop());
	        }
	    }
	    
	    public int pop() {
	    	int result = fisrtValueStack.pop();
	    	peek();
	    	return result;

	    }
	    
	    public int peek() {
	    	//在peek加上当firstValue为空时候,将normal 的第一个值放进来的逻辑要比放在pop处理好点,放在pop,有时候为空,有时候不为空,然后pop之后又为空,需要额外判断
	    	if(fisrtValueStack.isEmpty()) {
	    		if(mainStack.size()==0) {
	    			return 0;
	    		}
	    		Stack<Integer> temp= new Stack<>();
	    		int size = mainStack.size();
	    		for(int i=0;i<size-1;i++) {
	    			temp.push(mainStack.pop());
	    		}
	    		if(mainStack.size()>0) {
		    		fisrtValueStack.push(mainStack.pop());
	    		}
	    		size = temp.size();
	    		for(int i=0;i<size;i++) {
	    			mainStack.push(temp.pop());
	    		}
	    	}
	        return fisrtValueStack.peek();
	    }
	    
	    public boolean empty() {
	        return (mainStack.isEmpty()&&fisrtValueStack.isEmpty());
	    }
	    public Stack<Integer> getStack1() {//for test
	        return mainStack;
	    }
	    public Stack<Integer> getStack2() {//for test
	        return fisrtValueStack;
	    }
	}
	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		T232 out = new T232();
		MyQueue mq = out.new MyQueue();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("input choice");
			int chose =sc.nextInt();		
			switch(chose) {
				case 1:
					//push
					System.out.println("push value");
					int temp =sc.nextInt();
					mq.push(temp);
					break;
				case 2:
					//peek
					System.out.println("peek:"+mq.peek());
					break;
				case 3:
					//pop
					System.out.println("Pop:"+mq.pop());
					break;
				case 4:
					//display
					display(mq);
					break;
				default:
					System.out.println("finish");
					break;
			}
		}
	}
	private static void display(MyQueue mq) {
		 for(int i:mq.getStack2()) {
			 System.out.print(i+",");
		 }
		 System.out.println();
		 System.out.println("===================");
		 for(int i:mq.getStack1()) {
			 System.out.print(i+",");
		 }
		
	}
}
