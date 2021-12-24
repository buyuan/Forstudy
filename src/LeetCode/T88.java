/**
 * 88. Merge Sorted Array
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */

package LeetCode;

public class T88 {
	public static  void main(String[] args) {
		int[] nums1 = {0,0,3,0,0,0,0,0,0};
		int m=3;
		int[] nums2 = {-1,1,1,1,2,3};
		int n=6;
		merge(nums1, m, nums2, n);

	}
	//start from the end ,find the max then move to end of nums1
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int index1=m-1;
		int index2=n-1;
		int k=m+n-1;
		while(index1>=0&&index2>=0) {
			if(nums1[index1]>nums2[index2]) {
				nums1[k]=nums1[index1];
				index1--;
			}else {
				nums1[k]=nums2[index2];
				index2--;
			}
			k--;
		}
		while(index2>=0) {
			nums1[k--]=nums2[index2--];
		}
		//No need to do setps below since the rest numbers of nums1 are already there
//		while(index1>=0) {
//			nums1[k--]=nums1[index1];
//		}
	}
	
	//find a place ,remove numbers in nums1, then insert the number of nums2
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int moveStep=0;
        boolean found =false; 
        int start=0;//not start yet
        int largest1 = 0;
        if(m>0) {
        	 largest1 = nums1[m-1];
        }
       
        for(int i=0;i<n;i++) {
        	int a = nums2[i];
        	if(nums2[i]>=largest1) {
        		int x=0;
        		for(int l=n-1;l>=i;l--) {
        			nums1[m+n-1-x]=nums2[l];
        			x++;
        		}
        		break;
        	}
        	for(int j=start;j<m+n-1;j++) {
        		int b = nums1[j];
        		if(nums1[j]>nums2[i]) {
        			start=j;
        			found=true;
        			break;
        		}
        	}
        		if(found) {
        			for(int k=m+n-1;k>start;k--) {
        				nums1[k]=nums1[k-1];
        			}
        			nums1[start]=nums2[i];
        			found = false;
        		}      		
        }
    }
}
