/**
 * 1209. Remove All Adjacent Duplicates in String II
Medium

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal 
letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.
 */
package LeetCode;

import java.util.Stack;

public class T1209 {
    public static String removeDuplicates(String s, int k) {
    	//思路是用一个两个元素的数组存,一个存字符,一个存连续次数,这样避免了连续多个字符的时候,pop或者peek无法找到最早那个,这种问题
    	T1209 out = new T1209();
    	Stack<Pair> pr = new Stack<>();
    	int size = s.length();
    	Pair last =null;
    	pr.push(last);//in case the first letters will be removed , than the stack is empty    	
    	for(int i=0;i<size;i++) {
    		char c = s.charAt(i);
    		if(last==null) {
    			last = out.new Pair(c);
    			pr.push(last);
    			continue;
    		}
    		if(last.getChr()==c) {
    			last.times++;
    		}else {
    			last = out.new Pair(c);
    			pr.push(last);
    		}
    		if(last.getTimes()==k) {
    			pr.pop();
    			if(pr.isEmpty()) {
    				last=null;
    			}else {
    				last = pr.peek();
    			}  			
    		}
    	}
    	String result = "";
    	for(Pair p:pr) {
    		if(p!=null) {
        		for(int i=0;i<p.getTimes();i++) {
        			result+=p.getChr();
        		}
    		}
    	}
    	
    	return result;
    }
    class Pair{
    	Integer times;
    	Character chr;
    	
		public Pair(Character chr) {
			this.times = 1;
			this.chr = chr;
		}
		public Integer getTimes() {
			return times;
		}
		public void setTimes(Integer times) {
			this.times = times;
		}
		public Character getChr() {
			return chr;
		}
		public void setChr(Character chr) {
			this.chr = chr;
		}
    	
    }
    public static void main(String[] args) {
    	String s0 = ""; int k0 = 2;
    	String s1 = "abcd"; int k1 = 2;
    	String s2 = "deeedbbcccbdaa"; int k2 = 3;
    	String s3 = "pbbcggttciiippooaais"; int k3 = 2;
    			
    	String testS = s2; int testK = k2;
    	String result = removeDuplicates(testS,testK);
    	System.out.println(result);
    	
    }
}
