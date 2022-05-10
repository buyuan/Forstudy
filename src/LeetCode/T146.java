/**
 * 146. LRU Cache
Medium
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, 
add the key-value pair to the cache. If the number of keys exceeds the capacity from 
this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
 */
package LeetCode;

import java.util.LinkedHashMap;
import java.util.Set;

public class T146 {
	//用 linkedHashmap, 因为他用链表记录了放入的先后顺序,那么表尾的那个就是最先放进去的,(更新是把旧的去掉,重新加入,相当于新放进去)
	class LRUCache {
		private LinkedHashMap<Integer,Integer> LRC ;
		private int cap;
	    public LRUCache(int capacity) {
	        this.cap = capacity;
	        this.LRC= new LinkedHashMap<>();
	    }
	    
	    public int get(int key) {
	        if(LRC.containsKey(key)) {
	        	int value = LRC.get(key);
	        	LRC.remove(key);
	        	put(key,value);
	        	return value;
	        }else {
	        	return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	    	if(LRC.size()>=cap&&(!LRC.containsKey(key))) {
	    		//drop the last
//	    		Set<Integer> ks = LRC.keySet();
//	    		if(ks.iterator().hasNext()) {
//	    			Integer lkey = ks.iterator().next();
//	    			LRC.remove(lkey);
//	    		}
	    		LRC.remove(LRC.keySet().iterator().next());//remove the item that was put at first
	    	}
	    	LRC.remove(key);
	    	LRC.put(key, value);
	    }
	}
	
	public static void main(String[] args) {
		T146 out =new T146();
		LRUCache lrc = out.new LRUCache(2);
		lrc.put(1,1);
		lrc.put(2,2);
		int a = lrc.get(1);
		System.out.println(a);
		lrc.put(3,3);
		a = lrc.get(2);
		System.out.println(a);
		lrc.put(4,4);
		a = lrc.get(1);
		System.out.println(a);
		a= lrc.get(3);
		System.out.println(a);
		a = lrc.get(4);
		System.out.println(a);
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
