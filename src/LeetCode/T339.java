/*
 * 339. Nested List Weight Sum
Medium
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.

Return the sum of each integer in nestedList multiplied by its depth.

 

Example 1:


Input: nestedList = [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
Example 2:


Input: nestedList = [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
Example 3:

Input: nestedList = [0]
Output: 0
 

Constraints:

1 <= nestedList.length <= 50
The values of the integers in the nested list is in the range [-100, 100].
The maximum depth of any integer is less than or equal to 50.
 */
package LeetCode;

import java.util.List;
import java.util.Stack;

public class T339 {
	//遍历每一个元素,如果是integer, X factor 加上,如果不是integer,同样的方法往深入遍历,但是ifactor +1
	private int result=0;
    public int depthSum(List<NestedInteger> nestedList) {
    	int factor =1;
    	for(int i=0;i<nestedList.size();i++) {
    		cal(nestedList.get(i),factor);
    	}
    	return result;
    }
	private void cal(NestedInteger ele, int factor) {
		// TODO Auto-generated method stub
		if(ele.isInteger()) {
			result+=ele.getInteger()*factor;
		}else {
			factor++;
			List<NestedInteger> cur = ele.getList();
			for(int i=0;i<cur.size();i++) {
				cal(cur.get(i),factor);
			}
		}
	}
}

/*
 * public interface NestedInteger {
     // Constructor initializes an empty nested list.
     public NestedInteger();

     // Constructor initializes a single integer.
     public NestedInteger(int value);

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value);

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni);

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
 */
