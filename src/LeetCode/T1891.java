/**
 * Leetcode 1891. Cutting rope

Given an array of integers ribbons And an integer k, Array per item ribbons[i] It means the first one i The length of the rope .

For each rope , You can cut anything into a series of parts with a positive integer length , Or choose not to cut .

for example , If you are given a length of 4 The rope of , You can ：

Keep the length of the rope 4 unchanged ;
Cut into a length of 3 And a length of 1 The rope of ;
Cut into two strips with a length of 2 The rope of ;
Cut into a length of 2 And two strips of length 1 The rope of ;
Cut into four strips with a length of 1 The rope of .
Your task is to finally get k strip Completely equally The rope of , Their length is the same positive integer .
If there is any residue after the rope is cut , You can just throw away the excess .

For this k A rope , Return to the rope you can get Maximum length ;
If you can't get k A rope of the same length , return 0.

 Example  1:
 Input : ribbons = [9,7,5], k = 3
 Output : 5
 explain :
-  Cut the first rope in two , A length of  5, A length of  4;
-  Cut the second rope in two , A length of  5, A length of  2;
-  The third rope is not cut ;
 Now? , You got it.  3  The length of the bar is  5  The rope of .

 Example  2:
 Input : ribbons = [7,5,9], k = 4
 Output : 4
 explain :
-  Cut the first rope in two , A length of  4, A length of  3;
-  Cut the second rope in two , A length of  4, A length of  1;
-  Cut the second rope into three parts , A length of  4, A length of  4, There is also a length of  1;
 Now? , You got it.  4  The length of the bar is  4  The rope of .

 Example  3:
 Input : ribbons = [5,7,9], k = 22
 Output : 0
 explain :  Since the rope length needs to be a positive integer , You can't get  22  A rope of the same length .
 
 Tips :
1 <= ribbons.length <= 10^5
1 <= ribbons[i] <= 10^5
1 <= k <= 10^9
 */
package LeetCode;

public class T1891 {
	 public static int maxLength(int[] ribbons, int k) {
		 //思路就是, 先找以恶搞判断中间数,如果可以用中间数切k段,那么长一点可不可以?如果不行,那么短一点找找看
		 int sum=0;
		 for(int i:ribbons) {
			 sum+=i;
		 }
		 if(sum<k) {
			 return 0;//绳子长度都不够1米一个
		 }
		 int l =1; int r = Integer.MAX_VALUE;
		 while(l<r) {
			 int mid = l+(r-l)/2;
			 if(OkToCut(ribbons,k,mid)) {
				 l=mid;//往更长的找找看
			 }else {
				 r = mid-1;//往短了找试试
			 }
		 }
		 return l;
	 }
	 
	 private static boolean OkToCut(int[] ribbons, int k, int len) {
		// TODO Auto-generated method stub
		 int numberOfRope=0;
		 for(int i : ribbons) {
			 numberOfRope+=i/len;
		 }
		 return numberOfRope>=k;

	}

	public static void main(String[] args) {
		 int[] r1 = {9,7,5}; int k1=3;
		 int[] r2 = {7,5,9}; int k2=4;
		 int[] r3 = {5,7,9}; int k3=22;
		 
		 int[] r = r3; int k = k3;
		 System.out.println(maxLength(r,k));
 	 }
}
