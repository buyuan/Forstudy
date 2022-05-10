/*
 * 127. Word Ladder
Hard

7617

1626

Add to List

Share
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */
package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(beginWord.equals(endWord)) {
			return 0;
		}
        HashSet<String> wList = new HashSet<>();

        for(String s: wordList) {
        	wList.add(s);
        }
		if(!wList.contains(endWord)) {
			return 0;
		}
        int result = 1;
        Queue<String> qu = new LinkedList<String>();
        qu.add(beginWord);
        while(!qu.isEmpty()) {
        	result++;
        	int size = qu.size();
        	for(int i=0;i<size;i++) {
        		String cuW = qu.poll();
        		for(int k=0;k<cuW.length();k++) {
        			char[] tChar = cuW.toCharArray();
        			for(char ch='a';ch<='z';ch++) {
        				tChar[k]=ch;
        				String temp = String.valueOf(tChar);
        				if(temp.equals(endWord)) {
        					return result;
        				}
        				if(wList.contains(temp)) {
        					qu.add(temp);
        					wList.remove(temp);
        				}
        			}
        		      			
        		}
        	}        	
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	 String b1 = "hit"; String e1 = "cog";
    	 String[] w1 = {"hot","dot","dog","lot","log","cog"};
    	
    	 String beginWord = b1 ; String endWord = e1;

    	 List<String>  wordList =getList(w1);
    	 display(wordList);
    	 System.out.println(ladderLength(beginWord, endWord, wordList));
    	
    }



	private static void display(List<String> wordList) {
		// TODO Auto-generated method stub
		for(String s:wordList) {
			System.out.print(s+",");
		}
		System.out.println();
	}

	private static List<String> getList(String[] w1) {
		// TODO Auto-generated method stub
		List<String> res = new LinkedList<String>();
		for(String s :w1) {
			res.add(s);
		}
		return res;
	}
}
