/**
 * 299. Bulls and Cows
Medium

You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is.
 When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are 
located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged 
such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
 Note that both secret and guess may contain duplicate digits.

 

Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"
Example 2:

Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 */
package LeetCode;

public class T299 {
    public static String getHint(String secret, String guess) {
        //思路,先找bull,相同index相同值,
    	//再找cow, 用一个数组,10位数,每一位的index代表值(0-9),secret的数字出现,就要在数组中的相应位置+1,guess出现过,-1
    	//,判断时候,如果用secret判断,若数组value小于0,说明在guess出现过,用guess判断时候,如果大于0,则说明secret出现过
    	int A=0;
    	int B=0;
    	int[] num =new int[10];
    	int size = secret.length();
    	for(int i=0;i<size;i++) {
    		int s = secret.charAt(i)-'0';
    		int g = guess.charAt(i)-'0';
    		if(s==g) {
    			A++;
    		}else {
    			if(num[s]-- >0) {//只有g会导致大于0
    				B++;
    			}
    			if(num[g]++<0) {//只有S会导致小于0
    				B++;
    			}
    		}
    	}
    	return A+"A"+B+"B";
    }
    
    public static void main(String[] args) {
    	String s1 = "1807";String g1="7810";
    	String s2 = "1123";String g2="0111";
    	
    	String s = s2;String g =g2;
    	String result = getHint(s,g);
    	System.out.println(result);
    }
}
