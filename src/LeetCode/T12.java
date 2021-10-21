
/**
 * 12. Integer to Roman
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Example 2:

Input: num = 4
Output: "IV"
Example 3:

Input: num = 9
Output: "IX"
Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
package LeetCode;

public class T12 {
	public static void main(String[] args) {
		int num = 58;
		String s = intToRoman(num);
		System.out.println(s);
	}
	//force to solve, but too slow
    public static String intToRoman(int num) {
        String ans="";
        int temp=0;
        while(num>0) {
        	temp = cut(num);
        	num = num-temp;
        	ans+=getString(temp);    	
        }
        return ans;
    }
	private static String getString(int temp) {
		// TODO Auto-generated method stub
		switch(temp){
	case 1000:
		return "M";
	case 900:
		return "CM";
	case 800:
		return "DCCC";
	case 700:
		return "DCC";
	case 600:
		return "DC";
	case 500:
		return "D";
	case 400:
		return "CD";
	case 300:
		return "CCC";
	case 200:
		return "CC";
	case 100:
		return "C";
	case 90:
		return "XC";
	case 80:
		return "LXXX";
	case 70:
		return "LXX";
	case 60:
		return "LX";
	case 50:
		return "L";
	case 40:
		return "XL";
	case 30:
		return "M";
	case 20:
		return "M";
	case 10:
		return "X";
	case 9:
		return "IX";
	case 8:
		return "VIII";
	case 7:
		return "VII";
	case 6:
		return "VI";
	case 5:
		return "V";
	case 4:
		return "IV";
	case 3:
		return "III";
	case 2:
		return "II";
	case 1:
		return "I";
	default:
		return "false";
		}
		
	}
	private static int cut(int num) {
		// TODO Auto-generated method stub
		int[] std = {1000,900,800,700,600,500,400,100,90,80,70,60,50,40,10,9,8,7,6,5,4,3,2,1};
		for(int i=0;i<std.length;i++) {
			if((num-std[i])>=0) {
				return std[i];
			}
		}
		return 0;
	}
    
}

















