/**
 * 69. Sqrt(x)
Easy

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, 
and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, 
such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., 
and since the decimal part is truncated, 2 is returned.
 */
package LeetCode;

public class T69 {
    public static int mySqrt(int x) {
    	if(x==0||x==1) {
    		return x;
    	}
        int up = x;
        int down =0;
        while(down<up) {
        	int mid = down+(up-down)/2;
        	if(mid==(x/mid)) {
        		return mid;
        	}
        	if(mid<(x/mid)) {
        		down = mid+1;
        	}else {
        		up = mid;
        	}
        }
        return up-1;
    }
    
    public static void main(String[] args) {
    	int x1 = 4;
    	int x2 = 8;
    	int x3 = 1;
    	
    	int x = x2;
    	System.out.println(mySqrt(x));
    }
}
