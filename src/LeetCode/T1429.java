/**
 * Leetcode 1429. First Unique Number
 medium
You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
void add(int value) insert value to the queue.

Example 1:

Input:
[“FirstUnique”,“showFirstUnique”,“add”,“showFirstUnique”,“add”,“showFirstUnique”,“add”,“showFirstUnique”]
[[[2,3,5]],[],[5],[],[2],[],[3],[]] 
Output:
[null,2,null,2,null,3,null,-1]
Explanation:
FirstUnique firstUnique = new FirstUnique([2,3,5]);
firstUnique.showFirstUnique(); // return 2
firstUnique.add(5); // the queue is now [2,3,5,5]
firstUnique.showFirstUnique(); // return 2
firstUnique.add(2); // the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique(); // return 3
firstUnique.add(3); // the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique(); // return -1

Example 2:

Input:
[“FirstUnique”,“showFirstUnique”,“add”,“showFirstUnique”]
[[[809]],[],[809],[]] 
Output:
[null,809,null,-1]
Explanation:
FirstUnique firstUnique = new FirstUnique([809]);
firstUnique.showFirstUnique(); // return 809
firstUnique.add(809); // the queue is now [809,809]
firstUnique.showFirstUnique(); // return -1

Example 3:

Input:
[“FirstUnique”,“showFirstUnique”,“add”,“add”,“add”,“add”,“add”,“showFirstUnique”]
[[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
Output:
[null,-1,null,null,null,null,null,17]
Explanation:
FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
firstUnique.showFirstUnique(); // return -1
firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7]
firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3]
firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3,3]
firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7,3,3,7]
firstUnique.add(17); // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
firstUnique.showFirstUnique(); // return 17

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^8
1 <= value <= 10^8
At most 50000 calls will be made to showFirstUnique and add.
 */
package LeetCode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class T1429 {
	//基本思路就是,用linkedHashSet的有序这个特性,如果HashSet显示是新数据(add, return true),添加到LinkedHashSet里面来, 
	//如果发现是一个重复的数据,则可以从LinkedHashSet中去掉,这样,遍历完之后,第一个就是firstUnique
	private Set<Integer> unique = new LinkedHashSet<Integer>();
	private Set<Integer> flag = new HashSet<Integer>();
	
	public T1429(int[] nums) {//FirstUnique
		for(int i:nums) {
			add(i);
		}
	}

	public int showFirstUnique() {
		if(unique.isEmpty()) {
			return -1;
		}
//		for(int i:unique) {
//			return i;
//		}
		return unique.iterator().next();
	}

	public void add(int value) {
		if(flag.add(value)) {
			unique.add(value);
		}else {
			unique.remove(value);
		}
	}
	
	public static void main(String[] args) {
		 int[] numsA1 = {2,3,5};
		 int[] numsA2 = {5,2,3};
		 int[] numsB1 = {809};
		 int[] numsB2 = {809};
		 int[] numsC1 = {7,7,7,7,7,7};
		 int[] numsC2 = {7,3,3,7,17};
		 
		 int[] testcase1 = numsC1;
		 int[] testcase2 = numsC2;
		 
		 T1429 uniq = new T1429(testcase1);
		 System.out.println("first: "+uniq.showFirstUnique());
		 for(int i :testcase2) {
			 uniq.add(i);
			 System.out.println("first: "+uniq.showFirstUnique());
		 }
		
		
		 
		 
	}

}

 /**
* Your FirstUnique object will be instanti ted and called as such:
* FirstUnique obj = new FirstUnique(nums);
* int param_1 = obj.showFirstUnique();
* obj.add(value);
 */
