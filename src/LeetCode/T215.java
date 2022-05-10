/**
 * Medium

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
package LeetCode;

public class T215 {
    public static int findKthLargest(int[] nums, int k) {
        //用快速排序,能够快速的找到是否有第K个,例如用patitionIndex比K小还是比K大来判断
    	int patitionIndex = patition(nums, 0, nums.length-1);
    	//K is the serial number, must transfer to subscript
    	int serialK = k-1;
    	while(patitionIndex!=(serialK)) {
        	if(patitionIndex>serialK) {
        		//go left
        		patitionIndex = patition(nums, 0, patitionIndex-1);    		
        	}else {
        		//go right
        		//serialK = serialK-patitionIndex;
        		patitionIndex = patition(nums, patitionIndex+1, nums.length-1);        		
        	}
    	}
    	return nums[patitionIndex];
//    	if(patitionIndex==k) {
//    		return nums[patitionIndex];
//    	}
//    	if(nums[patitionIndex]>k) {
//    		//go right
//    		k = k-patitionIndex;
//    		patitionIndex = patition(nums, patitionIndex-1, nums.length-1);
//    	}else {
//    		//go left
//    		patitionIndex = patition(nums, 0, patitionIndex+1);
//    		
//    	}
    }
    public static int[] quickSort(int[] nums,int left, int right) {
    	//用交换两次来实现放在左边,第一次放在pivot旁边,第二次交换这个值和pivot,这样减少空间使用
    	if(left<right) {
        	int patitionIndex = patition(nums, left, right);
        	quickSort(nums,left,patitionIndex-1);
        	quickSort(nums,patitionIndex+1,right);
    	}
    	return nums;
    }
    private static int patition(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
    	int pivot = left;
    	int lastIndext = pivot+1;;
    	for(int i=lastIndext;i<=right;i++) {
    		if(nums[i]>nums[pivot]) {
    			swap(nums,i,lastIndext);
    			lastIndext++;
    		}
    	}
    	swap(nums, lastIndext-1,pivot);//因为在使用前已经减一,但是没有被使用,所以这里加回来
		return lastIndext-1;
	}

	private static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[j];
		nums[j]  = nums[i];
		nums[i]  = temp;
	}
	public static void main(String[] args) {
    	int[] nums1 = {3,2,3,1,2,4,5,5,6};int k1 = 4;
    	int[] nums2 = {3,2,1,5,6,4};int k2 = 2;
    	int[] nums3 = {3,5,1};
    	int[] nums4 = {7,6,5,4,3,2,1};int k4 = 5;
    	
    	int[] testcase = nums2;
    	int K = k2;
    	
    	int result = findKthLargest(testcase, K);
    	
    	int[] retults = quickSort(testcase,0,testcase.length-1);
    	for(int i :retults) {
    		System.out.print(i+", ");
    	}
    	System.out.println();
    	System.out.println("========= K="+K+" ================");
    	System.out.println(result);
    }	
}
