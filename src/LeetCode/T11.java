/**
 * 11. Container With Most Water

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2
 */
package LeetCode;

public class T11 {
	public static void main(String[] args) {
		int[] h = {1,2,1};
		int A = maxArea(h);
		System.out.println(A);
	}
	//complexity is too big 
    public static int maxArea_old(int[] height) {
        int ans=0;
        int temp=0;
        for(int i=0;i<height.length;i++) {
        	for(int j=i;j<height.length;j++) {
        		temp = (j-i)*lst(height[i],height[j]);
        		if(ans<temp) {
        			ans=temp;
        		}
        	}
        }
        return ans;
    }
	private static int lst(int i, int j) {
		// TODO Auto-generated method stub
		return i<j?i:j;
	}
	 public static int maxArea(int[] height) {
		 int ans =0;
		 int left =0;
		 int right = height.length-1;
		 while(left<right) {
			 ans = max(ans,(right-left)*lst(height[left],height[right]));
			 if(height[left]<height[right]) {
				 left++;
			 }
			 else {
				 right--;
			 }
		 }
		 return ans;
	 }
	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return a>b?a:b;
	}
}


















