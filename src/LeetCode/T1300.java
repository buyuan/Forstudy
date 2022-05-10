/**
 * 1300. Sum of Mutated Array Closest to Target
Medium

Given an integer array arr and a target value target,
 return the integer value such that when we change all the integers 
 larger than value in the given array to be equal to value, the sum of 
 the array gets as close as possible (in absolute difference) to target.

In case of a tie, return the minimum such integer.

Notice that the answer is not neccesarilly a number from arr.

 

Example 1:

Input: arr = [4,9,3], target = 10
Output: 3
Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's
 the optimal answer.
Example 2:

Input: arr = [2,3,5], target = 10
Output: 5
Example 3:

Input: arr = [60864,25176,27249,21296,20204], target = 56803
Output: 11361
 

Constraints:

1 <= arr.length <= 104
1 <= arr[i], target <= 105
 */
/*
 * 
 */
package LeetCode;

public class T1300 {
    public static int findBestValue(int[] arr, int target) {
        //注意,要返回的值,不是数组中的数字,而是符合条件的数字,即,修改比这个数字大的数字已达到接近target
     	int sum=0;
    	int max=Integer.MIN_VALUE;
    	for(int a:arr) {
    		sum+=a;
    		max = max>a?max:a;
    	}
    	if(sum<=target) {
    		//怎么改都找不到合适的值
    		return max;
    	}
    	//int min = Integer.MIN_VALUE; 
    	int min = 0;//用0似乎也没啥问题,除非给的数组和target都是复数,暂时不考虑这个情况吧.
    	int res = 0;//initial
    	int diff = Integer.MAX_VALUE;
    	while(min<=max) {
    		//取等号,因为可能最后一次还能更新Res, 
    		int mid = min+(max-min)/2;
    		sum = calByMid(mid,arr);
    		if(sum>target) {
    			//尝试往小的方向走
    			max = mid-1;
    		}else {
    			min = mid+1;
    		}
    		
    		if(Math.abs(sum-target)<diff||Math.abs(sum-target)==diff&&mid<res) {
    			//更小的diff或者相同diff更小的res
    			diff = Math.abs(sum-target);
    			res =mid;
    		}
    	}
    	return res;
    			
    }
    
    private static int calByMid(int mid, int[] arr) {
    	int sum=0;
		for(int i:arr) {
			sum+=(mid<i)?mid:i;
		}
		return sum;
	}

	public static void main(String[] args) {
    	int[] a1 = {4,9,3}; int t1 = 10;
    	
    	int[] a =a1;int t =t1;
    	System.out.println(findBestValue(a,t)); 
     }
}
