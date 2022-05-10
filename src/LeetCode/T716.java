/**
 716 Max Stack
 Easy

Design a max stack that supports the stack operations and supporting finding 
the push, pop, top, peekMax and popMax.

 1 push(x) -- Push element x onto stack.
2 pop() -- Remove the element on top of the stack and return it.
3 top() -- Get the element on the top.
4 peekMax() -- Retrieve the maximum element in the stack.
5 popMax() -- Retrieve the maximum element in the stack, and remove it. 
If you find more than one maximum elements, only remove the top-most one.
 

Example 1:

MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
 

Note:

-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
 */
package LeetCode;

import java.util.Stack;

public class T716 {
	class MaxStack {
		//用另一个栈来存出现过的更大值,类似155, 在popmax中,依次pop,然后把这些popo的值保存下来,在遇到确定的那个max之后,再把pop了的放回去
	    /** initialize your data structure here. */
		private Stack<Integer> normalStack;
		private Stack<Integer> maxStack;
	    public MaxStack() {
	    	normalStack = new Stack<>();
	    	maxStack    = new Stack<>();
	    }
	    //O(1);
	    public void push(int x) {
	    	normalStack.push(x);
	    	if(maxStack.isEmpty()||maxStack.peek()<=x) {
	    		maxStack.push(x);
	    	}
	    }
	    //O(1);
	    public int pop() {
	    	int x= normalStack.pop();
	    	if(x == maxStack.peek()) {
	    		maxStack.pop();
	    	}
	    	return x;
	    }
	    //O(1);
	    public int top() {
	    	return normalStack.peek();
	    }
	    //O(1);
	    public int peekMax() {
	    	return maxStack.peek();
	    }
	    //O(n);
	    public int popMax() {
	    	Stack<Integer> temp = new Stack<>();
	    	int max = maxStack.peek();
	    	while(normalStack.peek()!=max) {
	    		temp.push(normalStack.pop());
	    	}
	    	int result = normalStack.pop();//the max
	    	maxStack.pop();
	    	while(!temp.isEmpty()) {
	    		//put them back
	    		//注意要用push,因为在放回来的过程中,要找这一组回来数据的最大值
	    		push(temp.pop());
	    	}
	    	return result;
	    }
	    
	    public boolean isEmpty() {//for test
	    	return normalStack.isEmpty();
	    }
	    
	    public Stack<Integer> getStack(){
	    	return normalStack;
	    }
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6,7};
		int[] nums2 = {5,2,6,1,9,3,4};
		int[] nums3 = {7,6,5,4,3,2,1};
		
		
		T716 out = new T716();
		MaxStack ms = out.new MaxStack();
		int[] testcase = nums2;
		for(int i:testcase) {
			ms.push(i);
		}
		display(ms.getStack());
		System.out.println("top: "+ms.top()+" // peekmax: "+ms.peekMax());
		System.out.println("popMax: "+ms.popMax());
		display(ms.getStack());
		System.out.println("popMax: "+ms.popMax());
		display(ms.getStack());
		System.out.println("popMax: "+ms.popMax());
		display(ms.getStack());
		System.out.println("popMax: "+ms.popMax());
		display(ms.getStack());
		System.out.println("popMax: "+ms.popMax());
		display(ms.getStack());
		System.out.println("popMax: "+ms.popMax());
		display(ms.getStack());
	}

	private static void display(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		Stack<Integer> temp = new Stack<>();
		while(!stack.isEmpty()) {
			int x = stack.pop();
			temp.push(x);
			System.out.print(x+",");
		}
		
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		System.out.println();
	}


}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
