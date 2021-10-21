/**
 * 
 * Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */

package LeetCode;

public class T67 {
	public static void main(String[] args) {
		String a = "1010";
		String b = "1011";
		
		
		String c =addBinary( a,  b);
		System.out.print(c);
	}
	//I define the situations of 1+0, 1+1,0+0, not via integer calculation
	public static String addBinary(String a, String b) {
		 int indexA = a.length();
		 int indexB = b.length();
		 char[] ans = new char[indexA>indexB?indexA:indexB];
		 int indexAns = ans.length;
		 boolean add = false;	
		 while(indexA>0&&indexB>0) {
			 if (a.charAt(indexA-1)=='1'&&b.charAt(indexB-1)=='1') {
				 if(add) {
					 ans[indexAns-1]='1';
				 }else {
					 ans[indexAns-1]='0';
				 }
				 add = true;				
			 }else if(a.charAt(indexA-1)=='0'&&b.charAt(indexB-1)=='0'){
				 if(add) {
					 ans[indexAns-1]='1';
				 }else {
					 ans[indexAns-1]='0';
				 }
				 add = false;				 
			 }else {
				 if(add) {
					 ans[indexAns-1]='0';
					 add=true;
				 }else {
					 ans[indexAns-1]='1';
					 add=false;
				 }
			 }
			 indexA--;
			 indexB--;
			 indexAns--;
		 }
		 if(indexA==0&&indexB>0) {
			 for(int i=b.length()-a.length()-1;i>=0;i--) {
				 ans[i]=b.charAt(i);
				 if(add) {
					 if(ans[i]=='0') {
						 ans[i]='1';
						 add = false;
					 }else {
						 ans[i]='0';
						 add=true;
					 }
				 }
			 }
		 }else if(indexB==0&&indexA>0){
			 for(int i=a.length()-b.length()-1;i>=0;i--) {
				 ans[i]=a.charAt(i);
				 if(add) {
					 if(ans[i]=='0') {
						 ans[i]='1';
						 add = false;
					 }else {
						 ans[i]='0';
						 add=true;
					 }
				 }
			 }
		 }else {
			 
		 }   
		 if(add) {
			 return "1"+String.valueOf(ans);
		 }else {
			 return String.valueOf(ans);
		 } 
	}
}
