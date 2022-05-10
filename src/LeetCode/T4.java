/**
 * 4. Median of Two Sorted Arrays
Hard

Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
 */
package LeetCode;

public class T4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	//思路就是用merge sort,然后直接找到第中间的数值(因为下标直接能知道)
    	int sizeN1 = nums1.length;
    	int sizeN2 = nums2.length;
    	if((sizeN1==0)&&(sizeN2==0)) {
    		return 0;
    	}
    	if(sizeN1==0) {
    		if(sizeN2%2==0) {
    			return (nums2[sizeN2/2]+nums2[sizeN2/2-1])/2.0;
    		}else {
    			return nums2[sizeN2/2]/1.0;
    		}
    	}
    	if(sizeN2==0) {
    		if(sizeN1%2==0) {
    			return (nums1[sizeN1/2]+nums1[sizeN1/2-1])/2.0;
    		}else {
    			return nums1[sizeN1/2]/1.0;
    		}
    	}
    	
        int size = sizeN1+sizeN2;
        if(size%2==0) {
        	double[] value = getValue(size/2,nums1,nums2);//find the first data and the index {data,index1,index2}
            double cur = value[0];
            int indexN1 = (int)value[1];
            int indexN2 = (int)value[2];
        	double next = 0;
        	if(indexN1 == nums1.length){
        		//说明最后一次循环, indexN1到达了nums1.length-1,即取值结束了
        		next = nums2[indexN2];
        	}else if(indexN2 == nums2.length) {
        		next = nums1[indexN1];
        	}else {
        		next = nums1[indexN1]<nums2[indexN2]?nums1[indexN1]:nums2[indexN2];
        	} 
        	return (cur+next)/2;        	
        }else {
        	double[] value = getValue(size/2+1,nums1,nums2);
        	return value[0];
        }
//        int count =0;//use to find the serials
//        int indexN1=0;
//        int indexN2=0;
//        double cur=0;;
//        if(size%2==0) {
//        	int serials1 = size/2;
//        	while(count<serials1){
//        		if(indexN1<nums1.length&&indexN2<nums2.length) {
//            		if(nums1[indexN1]>nums2[indexN2]){
//            			cur = nums2[indexN2];
//            			indexN2++;
//            			count++;
//            		}else{
//            			cur = nums1[indexN1];
//            			indexN1++;
//            			count++;
//            		}
//        		}else if(indexN1 == nums1.length) {
//        			cur = nums2[indexN2];
//        			indexN2++;
//        			count++;      			
//        		}else if(indexN2 == nums2.length) {
//        			cur = nums1[indexN1];
//        			indexN1++;
//        			count++;        			
//        		}
//        		else {
//        			break;
//        		}
//        	}
//        	double next = 0;
//        	if(indexN1 == nums1.length){
//        		//说明最后一次循环, indexN1到达了nums1.length-1,即取值结束了
//        		next = nums2[indexN2];
//        	}else if(indexN2 == nums2.length) {
//        		next = nums1[indexN1];
//        	}else {
//        		next = nums1[indexN1]<nums2[indexN2]?nums1[indexN1]:nums2[indexN2];
//        	} 
//        	return (cur+next)/2;
//        }else {
//        	int serials = size/2+1;
//        	while(count<serials){
//        		if(indexN1<nums1.length&&indexN2<nums2.length) {
//            		if(nums1[indexN1]>nums2[indexN2]){
//            			cur = nums2[indexN2];
//            			indexN2++;
//            			count++;
//            		}else{
//            			cur = nums1[indexN1];
//            			indexN1++;
//            			count++;
//            		}
//        		}else if(indexN1 == nums1.length) {
//        			cur = nums2[indexN2];
//        			indexN2++;
//        			count++;      			
//        		}else if(indexN2 == nums2.length) {
//        			cur = nums1[indexN1];
//        			indexN1++;
//        			count++;        			
//        		}
//        		else {
//        			break;
//        		}
//        	}
//        	return cur;
//        }
    }
    public static double[] getValue(int serials, int[] nums1, int[] nums2) {
        int count =0;//use to find the serials
        int indexN1=0;
        int indexN2=0;
        double cur =0;
    	while(count<serials){
    		if(indexN1<nums1.length&&indexN2<nums2.length) {
        		if(nums1[indexN1]>nums2[indexN2]){
        			cur = nums2[indexN2];
        			indexN2++;
        			count++;
        		}else{
        			cur = nums1[indexN1];
        			indexN1++;
        			count++;
        		}
    		}else if((indexN1 == nums1.length)||(indexN1 == nums1.length-1)) {// 其实应该用 indexN1<= nums1.length
    			cur = nums2[indexN2];
    			indexN2++;
    			count++;      			
    		}else if((indexN2 == nums2.length)||(indexN2 == nums2.length-1)) {
    			cur = nums1[indexN1];
    			indexN1++;
    			count++;        			
    		}
    		else {
    			break;
    		}
    	}
    	double[] result = {cur,indexN1,indexN2};
    	return result;
    }    
    public static void main(String[] args) {
    	int[] numsA1 = {1,3};
    	int[] numsA2 = {2};
    	int[] numsB1 = {1,2};
    	int[] numsB2 = {3,4};
    	int[] numsC1 = {};
    	int[] numsC2 = {1};
    	int[] numsD1 = {1};
    	int[] numsD2 = {};
    	int[] numsE1 = {2,3};
    	int[] numsE2 = {};
    	int[] numsF1 = {1};
    	int[] numsF2 = {2,3};
    	int[] numsG1 = {2,3,4};
    	int[] numsG2 = {1};    	
    	
    	int[] testcase1 = numsG1;
    	int[] testcase2 = numsG2;
    	
    	double result = findMedianSortedArrays(testcase1,testcase2);
    	System.out.println(result);
    }
}
