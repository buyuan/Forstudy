/**
 * 895. Maximum Frequency Stack
Hard
Design a stack-like data structure to push elements to the stack and 
pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to 
the stack's top is removed and returned.
 

Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]

Explanation
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 

Constraints:

0 <= val <= 109
At most 2 * 104 calls will be made to push and pop.
It is guaranteed that there will be at least one element in the stack before calling pop.
 */
package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class T895 {
	//思路是每一个frequency的都用栈记录
	class FreqStack {
		HashMap<Integer,Integer> val_fre ;//value / frequency
		HashMap<Integer,Stack<Integer>> fre_lst;//frequency / value list
		int maxFre;
	    public FreqStack() {
	    	val_fre = new HashMap<>();
	    	fre_lst = new HashMap<>();
	    	maxFre =0;
	    }
	    public void push(int val) {
	    	int fre = val_fre.getOrDefault(val, 0)+1;
	    	maxFre = maxFre>fre?maxFre:fre;
	    	
	    	val_fre.put(val, fre);
	    	Stack<Integer> cur = fre_lst.getOrDefault(fre, new Stack<>());
	    	cur.push(val);
	    	fre_lst.put(fre, cur);
	    }
	    
	    public int pop() {
	    	Stack<Integer> cur = fre_lst.get(maxFre);
	    	int result = cur.pop();
	    	int fre = val_fre.get(result);
	    	val_fre.put(result,fre-1 );
	    	if(fre_lst.get(fre).isEmpty()) {
	    		maxFre--;
	    	}
	    	return result;
	    }
	}

	public static void main(String[] args) {
		T895 out =new T895();
		FreqStack temp = out.new FreqStack();
		temp.push(5);
		temp.push(7);
		temp.push(5);
		temp.push(7);
		temp.push(4);
		temp.push(5);
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
		System.out.println(temp.pop());
	}
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
