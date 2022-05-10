/**
 * 179. Largest Number
Medium

Given a list of non-negative integers nums, arrange them such that they
 form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.
 */
package LeetCode;

public class T179 {
	public static void main(String[] args) {
		int[] nums1 = {10,2};
		int[] nums2 = {3,30,34,5,9};
		int[] nums3 = {34323,3432};
		int[] nums4 = {999999998,999999997,999999999};
		int[] nums5 = {0,9,8,7,6,5,4,3,2,1};
		int[] nums6 = {0,0};
		
		int[] testcase = nums6;
		String result = largestNumber(testcase);
		System.out.println(result);
	}
    public static String largestNumber(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
        	for(int j=0;j<nums.length-i-1;j++) {
        		if(compare(nums[j],nums[j+1])) {
        			int temp  = nums[j+1];
        			nums[j+1] = nums[j];
        			nums[j]   = temp;
        		}
        	}
        }
        if(nums[0]==0) { // in case all the element is 0
        	return "0";
        }
        String result = "";
        for(int ele:nums) {
        	result+=ele;
        }
        return result;
    }
	private static boolean compare(int i, int j) {
		// TODO Auto-generated method stub
		long ij = getLong(i,j);
		long ji = getLong(j,i);
		if(ij>=ji) {
			return false;
		}else {
			return true;
		}
		
	}
	private static long getLong(long i, long j) {
		// TODO Auto-generated method stub
		if(j==0) {
			return i*10; 
		}
		int digits = 1;
		long temp =j;
		while(temp>0) {
			temp = temp/10;
			digits *=10;
		}
		
		return i*digits+j;
	}

}
