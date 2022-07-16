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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Test {
	public List<List<String>> partition(String s){
		List<List<String>> res = new ArrayList<>();
		
		helper(res, s, new ArrayList<String>(),0);
		return res;
		
	}

	private void helper(List<List<String>> res, String s, ArrayList<String> cur, int l) {
		// TODO Auto-generated method stub
		if(l==s.length()) {
			res.add(new ArrayList(cur));
			return;
		}
		int len=s.length();
		for(int r=l;r<len;r++) {
			if(isP(s,l,r)) {
				cur.add(s.substring(l,r+1));
				helper(res,s,cur,r+1);
				//backtrace
				cur.remove(cur.size()-1);
			}
		}
		
		
	}

	private boolean isP(String s, int l, int r) {
		while(l<=r) {
			if(s.charAt(l)!=s.charAt(r)) {
				return false;
			}
		}
		return true;
	}
}

