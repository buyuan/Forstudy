/**
 * 692. Top K Frequent Words
Medium
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words 
with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with
the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i] <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class T692 {
    class newList{
    	String str ;
    	Integer it;
    	newList(String key, Integer fre){
    		this.str = key;
    		this.it  = fre;
    	}

    	public String getStr() {
    		return str;
    	}

    	public void setStr(String str) {
    		this.str = str;
    	}

    	public Integer getIt() {
    		return it;
    	}

    	public void setIt(Integer it) {
    		this.it = it;
    	}
    }
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> mp = new HashMap<>();
        for(String x:words) {
        	int frequency = mp.getOrDefault(x,0);
        	frequency++;
        	mp.put(x, frequency);
        }
        class myCom implements Comparator<newList>{
        	@Override
        	public int compare(newList a,newList b) {
        		if(a.getIt()==b.getIt()) {
        			return a.getStr().compareTo(b.getStr());
        		}
        		return b.getIt()-a.getIt();
        	}
        }

        PriorityQueue<newList> res = new PriorityQueue<>(new myCom());
        T692 out = new T692();
        for(String key : mp.keySet()) {
        	res.offer(out.new newList(key, mp.get(key)));
        }
        List<String> result = new ArrayList<>();
        while(k>0) {
        	k--;
        	result.add(res.poll().getStr());
        }
       //sorted by lexicographical order if frequency is equal
        
//        List<String> result = new ArrayList<>();
//        newList cur = res.poll();
//        result.add(cur.getStr());
//        int preF = cur.getIt();
//        while(k>1) {
//        	k--;
//        	cur = res.poll();
//        	String curS = cur.getStr();
//        	int curF = cur.getIt();
//        	if(preF==curF) {
//        		//sorted by lexicographical order
//        		String pre = result.get(result.size()-1);       		
//        		if(pre.compareTo(curS)<0) {
//        			result.add(curS);
//        		}else {
//        			result.remove(result.size()-1);
//        			result.add(curS);
//        			result.add(pre);
//        		}     	       		
//        	}else {
//        		result.add(curS);
//        	}
//        	preF =  curF;
//        	
//        }
        return result;
    }
    
    public static void main(String[] args) {
    	String[] words1 = {"i","love","leetcode","i","love","coding"};int k1=2;
    	String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};int k2 = 4;
    	
    	String[] words = words1;int k =k1;
    	
    	List<String> result = topKFrequent(words, k) ;
    	for(String x:result) {
    		System.out.print(x+",");
    	}
    }

}
