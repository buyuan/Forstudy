/**
 * 380. Insert Delete GetRandom O(1)
Medium
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists 
when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 

Constraints:

-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class T380 {
	class RandomizedSet {
		ArrayList<Integer> value ;
		HashMap<Integer,Integer> kv;//value,index
	    public RandomizedSet() {
	    	value = new ArrayList<>();
	    	kv = new HashMap<>();
	    	
	    }
	    
	    public boolean insert(int val) {
	        if(kv.containsKey(val)) {
	        	return false;
	        }
	        value.add(val);
	        int index = value.size()-1;
	        kv.put(val, index);
	        return true;
	    }
	    
	    public boolean remove(int val) {
	        if(!kv.containsKey(val)) {
	        	return false;
	        }
	        int last = value.size()-1;
	        //swap the target item to the last place, to make sure the time is constant
	        //adjust the swapped value's index value in kv
	        
	        int index = kv.remove(val);//remove and get the value
	        if(index ==last ) {
	        	// if it is the last ,just remove, 
	        }else {
	        	// if not  the last, swap and update
		        int temp = value.get(last);
		        //adjust the index,and remove the item of the last val
		        kv.put(temp, index);
		        value.set(index,temp);
	        }
        	value.remove(last);

	        return true;
	    }
	    
	    public int getRandom() {
	    	Random rd = new Random();
	        return value.get(rd.nextInt(value.size()));
	    }
	}
	
	public static void main(String[] args) {
		T380 out = new T380();
		RandomizedSet rds =out.new RandomizedSet();
	
		rds.remove(0);
		rds.remove(0);
		rds.insert(0);
		rds.getRandom();
		rds.remove(0);
		rds.insert(0);
	}
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */