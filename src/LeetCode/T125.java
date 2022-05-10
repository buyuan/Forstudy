/*
 * 125. Valid Palindrome
Easy
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
package LeetCode;

public class T125 {
    public static boolean isPalindrome(String s) {
        //两个指针从两头往中间走,如果不等,则false,指针碰面则true   	
    	int size = s.length();
    	int r=size-1;
    	int l=0;
    	while(l<r) {
    		while(!isAlphabet(s.charAt(l))){
    			if(l<size-1) {
    				l++;
    			}else{
                    break;
                }

    		}
    		while(!isAlphabet(s.charAt(r))){
    			if(r>0) {
    				r--;
    			}else{
                    break;
                }
    			
    		}
            if(l>=r){
                return true;
            }
    		char ll = s.charAt(l);
    		char rr = s.charAt(r);
    		if(isEqual(s.charAt(l),s.charAt(r))) {
    			l++;
    			r--;
    		}else {
    			return false;
    		}
    	}
    	return true;
    }

	private static boolean isEqual(char c1, char c2) {
		// TODO Auto-generated method stub
		if (c1>='a') {
			c1-=32;
		}
		if (c2>='a') {
			c2-=32;
		}
		//都是数字不用处理
		if(c1==c2) {
			return true;
		}
		return false;
	}


	private static boolean isAlphabet(char c) {
		// TODO Auto-generated method stub
		if(c>='a'&&c<='z') {
			return true;
		}
		if(c>='A'&&c<='Z') {
			return true;
		}
		if(c>='0'&&c<='9') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = " ";
		String s4 = "., ";
		String s5 = "9,8";
		
		String s = s5;
		System.out.println(isPalindrome(s));
	}
}
