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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public List<List<Integer>> verticalOrder(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<>();
    	if(root==null) {
    		return res;
    	}
    	//for input the node in the same index
    	Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
    	//for track the boundary
    	int lowIndex=0;
    	int highIndex=0;
    	
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root,0));
        while(!qu.isEmpty()) {
        	Pair cur = qu.poll();
        	int idx = cur.index;       	
        	if(!mp.containsKey(idx)) {
        		mp.put(idx, new ArrayList<Integer>());
        	}
        	mp.get(idx).add(cur.tn.val);
        	lowIndex =Math.min(lowIndex, idx);
        	highIndex=Math.max(highIndex, idx);
        	if(cur.tn.left!=null) {
        		qu.add(new Pair(cur.tn.left,idx-1));
        	}
        	if(cur.tn.right!=null) {
        		qu.add(new Pair(cur.tn.right,idx+1));
        	}
        }
        for(int j=lowIndex;j<=highIndex;j++) {
        	res.add(mp.get(j));
        }
        return res;
    }
}

class Pair{
	TreeNode tn;
	Integer index;
	public Pair(TreeNode t, Integer i) {
		this.tn=t;
		this.index =i;
	}
}
