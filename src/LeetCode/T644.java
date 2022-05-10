/*
 * 644. Maximum Average Subarray II 
 

Given an array consisting of n integers, find the contiguous subarray whose length is greater than or equal to k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation:
when length is 5, maximum average value is 10.8,
when length is 6, maximum average value is 9.16667.
Thus return 12.75.
 

Note:

1 <= k <= n <= 10,000.
Elements of the given array will be in range [-10,000, 10,000].
The answer with the calculation error less than 10-5 will be accepted.
 */

package LeetCode;

public class T644 {
	 public static double findMaxAverage(int[] nums, int k) {
		 //暴力解, k的子序列看看,k+1,看看,一直到k = nums.length,即,用不同大小的框分别循环
		 int size = nums.length;
		 double sum =0.0;
		 double cur = 0.0;
		 double result =Integer.MIN_VALUE;
		 for(int i=k;i<=size;i++) {//times, not index
			 for(int j=0;j<size-i+1;j++) {//index 
				 int times = 0;
				 int index=j;
				 while(times<i) {
					 sum+=nums[index++];
					 times++;
				 }
				 cur = sum/i;
				 sum =0;
				 result = result>cur?result:cur;
			 }
		 }
		 return result;
	 }
	 public static double findMaxAverage_update(int[] nums, int k) {
		 //从某个点出发,看这个点起始的可以列举出来的框的都算一遍,然后再往下个点走
		 double result = Integer.MIN_VALUE;
		 int size = nums.length;
		 for(int i=0;i<size-k+1;i++) {
			 double sum = 0.0; 
			 for(int j=i;j<size;j++) {
				 sum+=nums[j];
				 int window = j-i+1;
				 if(window>=k) {//数量足够是符合要求的框了
					 double cur = sum/window;
					 result = result>cur?result:cur;
				 }				
			 }
		 }
		 return result;
		 
	 }
	 public static void main(String[] args) {
		 int[] test = {1,12,-5,-6,50,3}; 
		 int k1 = 4;int k2 = 5; int k3 = 6;
		 
		 int k =k3;
		 System.out.println(findMaxAverage_update(test,k));
	 }
}
