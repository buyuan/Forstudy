/**
 * 767. Reorganize String
Medium
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */
package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class T767 {
    public static String reorganizeString(String s) {
    	class myCom implements Comparator<pair>{
    		@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return o2.time - o1.time;
			}
    	}      
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        int size = s.length();
        for(int i=0;i<size;i++) {
        	char c = s.charAt(i);
        	int times = hm.getOrDefault(s.charAt(i),0);        	
        	hm.put(c, times+1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(new myCom());
        T767 out = new T767();
        for(char key:hm.keySet()) {
        	pq.offer(out.new pair(key,hm.get(key)));
        }
        String result = "";
        while(pq.size()>1) {
        	if(pq.peek().time>(1+size/2)){
        		//相同字符已经超过总数的一半,不可能不挨着了
        		return "";
        	}
        	pair top = pq.poll();
        	pair second = pq.poll();
        	result+= Character.toString(top.chr)+ Character.toString(second.chr);
        	if(--top.time>0) {
        		pq.offer(top);
        	}
        	if(--second.time>0) {
        		pq.offer(second);
        	}       	
        }
        if(!pq.isEmpty()) {
        	pair last = pq.poll();
        	if(last.time>1) {
        		return "";
        	}
        	result+=Character.toString(last.chr);
        }      
        return result;
    }
    class pair{
    	Character chr;
    	Integer time;
    	pair(Character chr,Integer time){
    		this.chr = chr;
    		this.time = time;
    	}
    }
    public static void main(String[] args) {
    	String s1 = "aab";
    	String s2 = "aaab";
    	
    	String s =s2;
    	System.out.println(s);
    	String result = reorganizeString(s);
    	System.out.println(result);
    }
}
