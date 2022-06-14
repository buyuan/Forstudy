/*
 * 341. Flatten Nested List Iterator
Medium

You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
Your code will be tested with the following pseudocode:

initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
If res matches the expected flattened list, then your code will be judged as correct.

 

Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 

Constraints:

1 <= nestedList.length <= 500
The values of the integers in the nested list is in the range [-106, 106].
 */
package LeetCode;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class T341 {
	//用栈,然后遇到非integer的,将这个内容解开放到栈之中,
	class NestedIterator implements Iterator<Integer> {
		Stack<NestedInteger> stk = new Stack<>();
	    public NestedIterator(List<NestedInteger> nestedList) {
	       for(int i=nestedList.size()-1;i>=0;i--) {
	    	   stk.add(nestedList.get(i));
	       }
	    }

	    @Override
	    public Integer next() {
	    	if(!hasNext()) {
	    		throw new NoSuchElementException();
	    	}
	    	return stk.pop().getInteger();
	    }

	    @Override
	    public boolean hasNext() {
	    	//如果当前栈为空或者是一个折叠的元素,就在下面这个方法中展开
	        flatInteger();
	        //展开后,如果还是没有元素,说明没了
	        return !stk.isEmpty();
	    }

		private void flatInteger() {
			// 如果目前栈顶已经是integer,就不用处理了
			//用while,防止某一个nestedInteger是空
			while(!stk.isEmpty()&&!stk.peek().isInteger()) {
				List<NestedInteger> cur = stk.pop().getList();
				for(int i=cur.size()-1;i>=0;i--) {
					stk.add(cur.get(i));
				}
			}
			
			
			
		}
	}
}
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

}
