/**
 * 1095. Find in Mountain Array
Hard

(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that
 mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a 
MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.
 Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index,
 which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 */
package LeetCode;

public class T1095 {
    class MountainArray implements Mountain{
    	int[] arr;
    	MountainArray(int[] nums){
    		arr = nums;
    	}
		@Override
		public int get(int index) {
			
			return arr[index];
		}

		@Override
		public int length() {
			// TODO Auto-generated method stub
			return arr.length;
		}
    	
    }
    public static int findInMountainArray(int target, MountainArray mountainArr) {
    	int size = mountainArr.length();
    	int left =0; 
    	int right = size-1;
    	int top=-1;
    	while(left<right) {
    		int mid = left+(right-left)/2;
    		if(mountainArr.get(mid)<mountainArr.get(mid+1)) {
    			//go right
    			left = mid+1;
    		}else {
    			//go left
    			right=mid;
    		}
    	}
    	top = left; 
    	if(mountainArr.get(top)==target) {
    		return top;
    	}
    	int l1 = 0;int r1=top-1;//left
    	int l2 = top+1;int r2=size-1;//right
    	int top1 =-1; int top2 =-1;
    	while(l1<r1){
    		//find in the left part,ascending;  		
    		int mid = l1+(r1-l1)/2;
    		int cur =mountainArr.get(mid);
    		if(cur>target) {
    			r1 = mid;
    		}else if(cur==target) {
    			top1=mid;
    			break;
    		}else {
    			l1=mid+1;
    		}
    	};  		

    	if(mountainArr.get(l1)==target) {
    		top1 = l1;
    	}
    	
        while(l2<r2){
    		//find in the right part,descending
        	int mid = l2+(r2-l2)/2;
        	int cur = mountainArr.get(mid);
    		if(cur>target) {
    			l2 = mid+1;
    		}else if(cur==target) {
    			top2=mid;
    			break;
    		}else {
    			r2=mid;
    		}
        }
        
    	if(mountainArr.get(l2)==target) {
    		top2 = l2;
    	}
    	if(top1>0&&top2>0) {
    		return top1<top2?top1:top2;
    	}else if(top1<0&&top2<0) {
    		return -1;
    	}else {
    		return top1*top2*(-1);
    	}
    	
    }
    interface Mountain {
        public int get(int index);
        public int length();
    }
    
    public static void main(String[] args) {
    	int[] nums1 = {1,2,3,4,5,4,1};int tar1 = 3;
    	int[] nums2 = {0,1,2,4,2,1};  int tar2 = 3;
    	int[] nums3 = {1,5,2};  int tar3 = 2;
 		int[] nums4 = {0,5,3,1};  int tar4 = 1; 
 		int[] nums5 = {1,5,2};  int tar5 = 0; 
 		
 		
    	int[] nums =nums5;int tar=tar5;
    	T1095 out = new T1095();
    	MountainArray mountainArr = out.new MountainArray(nums);
    	System.out.println(findInMountainArray(tar,mountainArr));
    	
    }
}
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */