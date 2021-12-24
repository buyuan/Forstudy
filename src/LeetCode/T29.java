/**
 * 29. Divide Two Integers
Medium

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
Example 3:

Input: dividend = 0, divisor = 1
Output: 0
Example 4:

Input: dividend = 1, divisor = 1
Output: 1
 */

package LeetCode;

public class T29 {
	public static void main(String[] arg) {
		int a= 23;
		int b =44;
		System.out.println(a^-1);
		System.out.println(a^1);
		System.out.println(b^-1);
		System.out.println(b^1);
		
	}
	public static int divide_2(int dividend, int divisor) {
		//思路 x / y =z---> x/ (y*2) = t  , t = z*2
    	int min_int = -2147483648;
    	int max_int = 2147483647;
    	if(divisor ==1) {return dividend;}
    	if(divisor ==-1) {
    		if (dividend==min_int) {
    			return max_int;
    		}
    		if(dividend==max_int) {
    			return min_int;
    		}
    	}
        int ans = 0;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;//^, 相同为0(false),不同为1(true)
        long divisor2 = divisor;//since -2147483648 * -1 =2147483648, exceed max  2147483647
        long dividend2=dividend;
        if(dividend<0) {
        	dividend2 = -1*dividend;
        }
        if(divisor<0) {
        	divisor2 = -1*divisor;
        }
        while(dividend2-divisor2>=0) {
        	long tempD = divisor2;
        	long temp = 1;
        	while(dividend2>= (tempD<<1)) {
        		tempD<<=1;
        		temp<<=1;
        	}
        	ans+=temp;
        	dividend2 -=tempD;
        }
		return ans*sign;
	}
    public static int divide_1(int dividend, int divisor) {
    	int min_int = -2147483648;
    	int max_int = 2147483647;
    	if(divisor ==1) {return dividend;}
    	if(divisor ==-1) {
    		if (dividend==min_int) {
    			return max_int;
    		}
    		if(dividend==max_int) {
    			return min_int;
    		}
    	}
        int ans = 0;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;//^, 相同为0(false),不同为1(true)
        if(dividend<0) {
        	dividend = -1*dividend;
        }
        if(divisor<0) {
        	divisor = -1*divisor;
        }
        while(dividend-divisor>=0) {
        	dividend = dividend -divisor;
        	ans++;
        }
        return ans*sign;
    }
}
