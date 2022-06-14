/*
 * 284. Peeking Iterator
Medium
Design an iterator that supports the peek operation on an existing iterator in addition to the hasNext and the next operations.

Implement the PeekingIterator class:

PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
int next() Returns the next element in the array and moves the pointer to the next element.
boolean hasNext() Returns true if there are still elements in the array.
int peek() Returns the next element in the array without moving the pointer.
Note: Each language may have a different implementation of the constructor and Iterator, but they all support the int next() and boolean hasNext() functions.

 

Example 1:

Input
["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 2, 2, 3, false]

Explanation
PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
peekingIterator.hasNext(); // return False
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
All the calls to next and peek are valid.
At most 1000 calls will be made to next, hasNext, and peek.
 
 */
package LeetCode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class T284 {

}

class PeekingIterator implements Iterator<Integer> {
	    private Iterator<Integer> iter;
	    private Integer peekValue=null;
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		    iter = iterator;
		}
		
	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        if(peekValue==null) {
	        	if(!iter.hasNext()) {
	        		throw new NoSuchElementException();
	        	}
	        	//在next中,会检查next是否存在peek中
	        	peekValue = iter.next();
	        }
	        return peekValue;
	        
		}
		
		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			if(peekValue!=null) {
				Integer retn = peekValue;
				peekValue=null;
				return retn;
			}
			if(!iter.hasNext()) {
				throw new NoSuchElementException();
			}
			
			return iter.next();
		}
		
		@Override
		public boolean hasNext() {
		    return peekValue!=null||iter.hasNext();
		}
}
