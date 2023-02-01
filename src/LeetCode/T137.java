package LeetCode;

import java.util.HashMap;

public class T137 {
	public static void main(String[] args) {
		int n1=4;int n2=0;
		
		int n=n2;
		System.out.println(tribonacci(n));
	}
    public static int tribonacci(int n) {
        //1 Top down
    	HashMap<Integer, Integer> memo = new HashMap<>();
    	//return dp(memo,n);
    	
    	// bottom up，注意第一个数是0,所以第n个是n+1
        if(n<3){
            switch (n){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 1;  
            }
        }
    	int[] me = new int[n+1];
    	me[1]=1;
    	me[2]=1;
    	for(int i=3;i<=n;i++) {
    		me[i] = me[i-3]+me[i-2]+me[i-1];
    	}
    	return me[n];
    }

	private int dp(HashMap<Integer, Integer> memo, int n) {
		if(n==0) {
			return 0;
		}
		if(n==1||n==2) {
			return 1;
		}
		if (!memo.containsKey(n)) {
			int res = dp(memo,n-3)+dp(memo,n-2)+dp(memo,n-1);
			memo.put(n, res);
		}
		return memo.get(n);
	}
}

/*
1137. N-th Tribonacci Number
Easy

2027

116

Add to List

Share
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

*/