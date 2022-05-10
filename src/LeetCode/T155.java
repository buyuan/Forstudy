/**
 * 155. Min Stack
Easy

Design a stack that supports push, pop, top, 
and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
package LeetCode;

import java.util.Stack;

public class T155 {
	class MinStack {
		//关于如何存最小值,实际上是用一个新的stack,存每一次push时候的那个栈的最小值,因此,对应pop时,也是那个时候的最小值
		//还有另外一种方法是,发现了更小的值才push,pop的时候,当这个值被pop, min stack 才pop这个值
		private Stack<Integer> normalStack ;
		private Stack<Integer> minStack ;
	    public MinStack() {
	    	normalStack = new Stack<>();
	    	minStack = new Stack<>();
	    }
	    
	    public void push(int val) {
	    	normalStack.push(val);
	        if(minStack.isEmpty()) {
	        	minStack.push(val);
	        }else {
	        	int lastMin = minStack.peek();
	        	int curMin = lastMin<val?lastMin:val;
	        	minStack.push(curMin);
	        }
	    }
	    
	    public void pop() {
	    	normalStack.pop();
	    	minStack.pop();
	    }
	    
	    public int top() {
	        return normalStack.peek();
	    }
	    
	    public int getMin() {
	        return minStack.peek();
	    }
	    public boolean isEmpty() {//for test
	    	return(normalStack.isEmpty()&&minStack.isEmpty());
	    }
	}
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6};
		int[] nums2 = {6,5,4,3,2,1};
		int[] nums3 = {1,3,1,4,5,2,6};
		int[] nums4 = {5,3,1,4,5,1,2,6};
		
		int[] testcase = nums4;
 		T155 out  = new T155();
		MinStack ms = out.new MinStack();
		for(int i :testcase) {
			ms.push(i);
		}
		while(!ms.isEmpty()) {
			System.out.print(ms.getMin()+" : "+ms.top());
			ms.pop();
			System.out.println();
			System.out.println("=======================");
			
		}
		
	}
}

/**
 * /**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
