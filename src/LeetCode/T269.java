/*
 * 269. Alien Dictionary
Hard
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.

 

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T269 {
    public static String alienOrder(String[] words) {
        //通过所给的单词,找到字母表顺序, 
    	//1.先简历字母之间的前后顺序,只需要找这个词和下一个词的关系就好,不需要这个词
    	//一直往后找到头,因为这个词找到的顺序,会比下个词往下的顺序优先,
    	//所以,串起来就能找到第一个词后续所有的关系
    	//##有一个疑问,这样找的全吗??为什么不是每一个词往后都循环一遍找关系?##
    	//2找到字母顺序关系,相当于能够创建有向图,如果进行拓扑排序,还需要注意找到入度
    	
    	//1.创建需要的数据结构,一个hashmap,用来存字符和遍历出来的后续字符
    	//创建一个入度的hashmap,用来BFS
    	HashMap<Character,List<Character>> vertex = new HashMap<>();
    	HashMap<Character,Integer> indegree = new HashMap<>();
    	//initial the indegree as 0,and the vertex to new list
    	for(String word : words) {
    		for(char c : word.toCharArray()) {
    			indegree.put(c,0);
    			vertex.put(c,new ArrayList<Character>());
    		}
    	}
    	
    	//build the graph, I need edges and indgrees
    	for(int i=0;i<words.length-1;i++) {
    		String wOne = words[i];
    		String wTwo = words[i+1];
    		//判断两个词是否矛盾,题目说,词是按照顺序排列的,但如果后一个词
    		//是前一个词的前缀,说明后一个词比前一个词小,应该靠前,
    		//比如 abc 和ab, abc比ab靠后,所以这种词找不到正确顺序
    		if(wOne.length()>wTwo.length()&&wOne.startsWith(wTwo)) {
    			return "";
    		}
    		
    		int len = wOne.length()<wTwo.length()?wOne.length():wTwo.length();
    		for(int j =0;j<len;j++) {
    			char c1 = wOne.charAt(j);
    			char c2 = wTwo.charAt(j);
    			if(c1!=c2) {
    				vertex.get(c1).add(c2);
    				indegree.put(c2, indegree.get(c2)+1);
    				break;
    			} 			
    		}
    	}
    	
    	
    	//start BFS
    	
    	Queue<Character> ver = new LinkedList<>();
    	for(Character x : indegree.keySet()) {
    		if(indegree.get(x)==0) {
    			ver.add(x);
    		}
    	}
    	StringBuilder result = new StringBuilder();
    	while(!ver.isEmpty()) {
    		char cur = ver.poll();
    		result.append(cur);
    		for(Character v:vertex.get(cur)) {
    			int idg = indegree.get(v)-1;
    			indegree.put(v,idg);//入度减一
    			if(idg==0) {
    				ver.add(v);
    			}
    		}
    	}
    	//如果有环,则result长度比所有字符还少
    	if(result.length()<indegree.size()) {
    		return "";
    	}
    	return result.toString();
    	
    }
    public static void main(String[] args) {
    	String[] w1 = {"wrt","wrf","er","ett","rftt"};
    	String[] w2 = {"z","x"};
    	String[] w3 = {"z","x","z"};
    	String[] w4 = {"ac","ab","zc","zb"};
    	String[] w5 = {"z","x","a","zb","zx"};
    	String[] words = w5;
    	System.out.println(alienOrder( words));
    }
    
}
