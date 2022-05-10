/*
 * 395. Longest Substring with At Least K Repeating Characters
Medium

Given a string s and an integer k, return the length of the 
longest substring of s such that the frequency of each character in this 
substring is greater than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 
'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105
 */
package LeetCode;

import java.util.HashMap;

public class T395 {
    public static int longestSubstring_1(String s, int k) {
        //用双指针,加一个限制条件,就是子字符串有多少个子母,这样可以限制右边界的移动
    	int result =0;
    	for(int i=1;i<=26;i++) {//总共26个小写字母
    		int cur = getMaxofI(s, i,k);//用来找,包含i个不同字符的符合k条件的字符串的字符数量
    		result  = result>cur?result:cur;
    		
    	}
    	return result;
    }
    
    private static int getMaxofI(String s, int i, int k) {
    	//用来找,包含i个不同字符的符合k条件的字符串的字符数量
    	int result =0;
    	int size = s.length();
    	int r=0;
    	int count=0; //to record the number of character whose frequency >= k
    	HashMap<Character, Integer> hm = new HashMap<>();// char , fre
    	for (int l=0;l<size-i*k+1;l++) {//i*k is for reduce the number of loop. since there at least i*k character from i 
    		while(r<size&&hm.size()<=i) {
    			char cur = s.charAt(r);
    			int fre = hm.getOrDefault(cur,0)+1;
    			hm.put(cur, fre);
    			if(hm.get(cur)==k) {
    				count++;
    			}
    			if(count==i&&hm.size()==i) {
    				result = result>(r-l+1)?result:(r-l+1);
    			}		
    			r++;
    		}
    		//before going into the next loop, it is necessary to clear the influence of current left(first) character
    		char left = s.charAt(l);
    		hm.put(left, hm.get(left)-1);
    		if(hm.get(left)==k-1) {
    			//after remove this character, the repeating number is less than k
    			count--;
    		}
    		if(hm.get(left)==0) {
    			hm.remove(left);
    		}
    		
    		
    	}
		return result;
	}

    public static int longestSubstring_2(String s, int k) {
    	//用递归,基本思路是,如果某个字符,完全不可能是符合条件的, 则跳过他, 用同样的方式往后找
    	int result =0;
    	
    	HashMap<Character, Integer> base = new HashMap<>();
    	for(int i=0;i<s.length();i++) {
    		char c =s.charAt(i);
    		int fre = base.getOrDefault(c, 0)+1;
    		base.put(c, fre);
    	}
    	//如果这个字符串全符合条件,则可以返回了
    	boolean flag = true;
    	for(char c : base.keySet()) {
    		if(base.get(c)<k) {
    			flag =false;
    			break;
    		}
    	}
    	if(flag) {
    		return s.length();
    	}
    	
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		if(base.get(c)<k) {
    			//means no substrs fit the criteria from current i
    			continue;
    		}
    		//找到了起点
    		int j=i;
    		//找这一段的终点
    		
    		while(j<s.length()&&base.get(s.charAt(j))>=k) {
    			j++;
    		}
    		int cur = longestSubstring_2(s.substring(i, j),k);
    		result = result>cur?result:cur;
    		i=j;
    		
    	}
    	return result;
    	
    }
	public static void main(String[] args) {
		String s1 = "aaabb"; int k1 =3;
		String s2 = "ababbc" ; int k2 = 2;
		String s3 = "ababacb" ; int k3 = 3;
		
		String s = s2; int k=k2;
		System.out.println(longestSubstring_2(s,k));
		
    	
    }
}
