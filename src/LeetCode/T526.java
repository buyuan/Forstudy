package LeetCode;

public class T526 {
	private static int result=0;
    public static int countArrangement(int n) {
    	//从1开始,暴力查找，
    	boolean[] visited = new boolean[n+1];
    	helper(visited,n, 1);
    	//leetcode 是跑多个case，result会一直累加，所以需要清空一下
    	int res = result;
    	result=0;
    	return res;
    }

	private static void helper(boolean[] visited, int n, int startIndex) {
		// TODO Auto-generated method stub
		if(startIndex>n) {
			//说明n的值的位置都有了
			result++;
			return;
		}
		for(int i=1;i<=n;i++) {
			if(!visited[i]&&(startIndex%i==0||i%startIndex==0)) {
				//找到符合条件的数值,然后就往下找
				visited[i]=true;
				helper(visited,n,startIndex+1);
				visited[i]=false;
			}
		}
	}

	public static void main(String[] args) {
		int n1=2;
		int n=n1;
		
		int res = countArrangement(n);
		System.out.println(res);
	}
}
/*
526. Beautiful Arrangement
Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

 

Example 1:

Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 15
*/