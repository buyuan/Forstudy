/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
package LeetCode;

public class T50 {
	public static double myPow(double x, int n) {
		if(x==1||x==0) {return x;}
		if(n==0) {return 1;}
		double ans =1.0;
		for(int i=n;i!=0;i=i/2) {
			if(i%2!=0) {
				ans*=x;//the first x if n is odd,  and the last time of the loop
			}
			x*=x;		
		}
		return n>0?ans:1/ans;
	}
	
	
	public static void main(String[] args) {
		System.out.println(myPow(2.00,-9));		
	}
}


















