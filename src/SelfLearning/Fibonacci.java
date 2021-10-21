package SelfLearning;

public class Fibonacci {
	public static void main(String[] args) {
		int que =46;
		long curt=0;
		long cost =0;
		
		
		curt = System.currentTimeMillis();
		System.out.println(Fib2(que));
		cost = System.currentTimeMillis()-curt;
		System.out.println("non-Recursive:"+" "+cost);
		
		
		curt = System.currentTimeMillis();
		System.out.println(Fib(que));
		cost = System.currentTimeMillis()-curt;
		System.out.println("Recursive:"+" "+cost);

	}
	public static long Fib(int n) {
		if(n==1||n==2) {
			return 1;
		}
		return Fib(n-1)+Fib(n-2);
		
	}
	
	public static long Fib2(int n) {
		if(n==1||n==2) {
			return 1;
		}
		//start from the 3rd month
		long last =1;
		long cur=1;
		long total=0;
		for(int i=3;i<=n;i++) {
			total = last+cur;
			last = cur;
			cur = total;
		}
		return total;
	}
}
