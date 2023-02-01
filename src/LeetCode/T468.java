package LeetCode;

import java.util.HashSet;

public class T468 {
	public static void main(String[] args) {
		String q1 = "172.16.254.1";
		String q2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
		String q3 = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
		String q4 = "192.0.0.1";
		String queryIP = q4;
		System.out.println(validIPAddress(queryIP));
	}
	private static HashSet<Character> st;
    public static String validIPAddress(String queryIP) {
    	if (queryIP.endsWith(":")||queryIP.endsWith(".")) {
    		return "Neither";
    	}
		st= new HashSet<>();
		for(int i =0;i<10;i++) {
			
			st.add((char)(i+48));
		}
		st.add('a');st.add('A');
		st.add('b');st.add('B');
		st.add('c');st.add('C');
		st.add('d');st.add('D');
		st.add('e');st.add('E');
		st.add('f');st.add('F');
    	if (queryIP.contains(".")) {
    		String[] para = queryIP.split("\\.");
    		if (para.length!=4) {
    			return "Neither";
    		}
    		for (String str : para) {
    			if(!validIPV4(str)) {
    				return "Neither";
    			}
    		}
    		return "IPv4";
    		
    	}else if(queryIP.contains(":")) {
    		String[] para = queryIP.split("\\:");
    		if (para.length!=8) {
    			return "Neither";
    		}
    		
    		for (int i =0;i<8;i++) {
    			if(!validIPV6(para[i])) {
    				return "Neither";
    			}
    		}
    		return "IPv6";
    	}else {
    		return "Neither";
    	}
        
    }

	private static boolean validIPV6(String str) {

		int len = str.length();
		if(len>4||len<1) {
			return false;
		}
		for(int i=0;i<len;i++) {
			char c = str.charAt(i);
			if (!st.contains(c)) {
				return false;
			}
		}
		return true;
	}

	private static boolean validIPV4(String str) {
		int len = str.length();
		if(len>3||len<1) {
			return false;
		}
		if(len>1&&str.startsWith("0")) {
			//for 192.0.0.1 this kind of issue
			return false;
		}
		int cur=0;
		for(int i = 0;i<len;i++) {
			char c = str.charAt(i);
			if(c>'9'||c<'0') {
				return false;
			}
			cur=cur*10+Character.getNumericValue(c);
		}
		if (cur>255) {
			return false;
		}
		return true;
	}
}


/*
468. Validate IP Address
Medium

716

2414

Add to List

Share
Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.

 

Example 1:

Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
 

Constraints:

queryIP consists only of English letters, digits and the characters '.' and ':'.
*/