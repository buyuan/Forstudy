/*
 * [LeetCode] 1060. Missing Element in Sorted Array
media


Given a sorted array A of unique numbers,
find the K-th missing number starting from the leftmost number of the array.

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
Note:

1 <= A.length <= 50000
1 <= A[i] <= 1e7
1 <= K <= 1e8
 */
package LeetCode;

public class T1060 {
	public static int missingElement(int[] nums, int k) {
		int l=0;int r=nums.length-1;
		//缺失在r之后的情况
		int missAmount = nums[r]-nums[0]-r;
		if(k>missAmount) {
			return nums[r]+k-missAmount;
		}
		while(l<r) {
			//这个只能找到缺失在在l和r之间的情况
			//要找到刚好左右夹住那个第K个数字的左右位置;
			int mid = l+(r-l)/2;
			missAmount=nums[mid]-nums[0]-mid;//不缺的数量减去实际的index,得出到底miss了几个
			if(missAmount>=k) {
				//means the kth is in the left part
				r = mid;
				
			}else {
				//means the kth is in the right part
				l=mid+1;
			}
		}
		//出来以后,实际上, l-1 和r之间就是缺失数字的地方, -1是因为最后一次循环加回去了
		//l-1之后要加几,取决于, l-1之前已经有了几个missing
		int missRemain = k-(nums[l-1]-nums[0]-(l-1));
		return nums[l-1]+missRemain;
		
	}
	
	public static void main(String[] args) {
		int[] n1 = {4,7,9,10}; int k1 =1;
		int[] n2 = {4,7,9,10}; int k2 =3;
		int[] n3 = {1,2,4};    int k3 =3;
		
		int[] n=n1;int k =k1;
		System.out.println(missingElement(n,k));
		
	}
}
