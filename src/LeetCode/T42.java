package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class T42 {
	public int trap(int[] height) {
        //1	双指针，先找出最高的柱子，然后以此划分左右，因为左边只要有低地，就能蓄水，右边也是如此
		//以左边为例，当发现一个比左边更矮的格子，说明可以蓄水，矮几格，蓄几格，
		//当发现比左边最高还要高的柱子，更新这个柱子为左最高，然后继续往后扫描
		int peakIndex=0;
		int len = height.length;
		for (int i=0;i<len;i++) {
			if(height[i]>height[peakIndex]) {
				peakIndex = i;
			}
		}
		int ans=0;
		//#left part
		int leftPeak=0;
		for(int i=0;i<peakIndex;i++) {
			if(height[i]<leftPeak) {
				ans+=leftPeak-height[i];
			}else {
				leftPeak=height[i];
			}
		}
		//right part
		int right=len-1;
		int rightPeak=0;
		for(int i=right;i>peakIndex;i--) {
			if(height[i]<rightPeak) {
				ans+=rightPeak-height[i];
			}else {
				rightPeak=height[i];
			}
		}
		return ans;
		
    }
	public int trap_2(int[] height) {
		/*
		#这个思路是用栈，就是一旦发现有坑（小-》大），则去计算这两个之间大存水，取完水之后，相当于就把这个坑填平了，
		在往回走，如果还是坑，还是继续计算。填平大意思是，如果两个柱子之间有小大柱子之间有坑，则是按照这个小柱子大高度计算水。
		而再往前大大柱子高度计算水，是减去后面的小柱子顶部，不会减到两个大坑之间的最低点
		*/
		Deque<Integer> stk = new ArrayDeque<>();
		int ans=0;
		int curIndex=0;
		int len = height.length;
		while(curIndex<len) {
			if(stk.isEmpty()) {
				stk.push(curIndex++);
			}else {
				if(height[stk.peek()]<height[curIndex]) {
					//遇到了高的柱子，要计算水量了
					int hole = stk.pop();
					if (stk.isEmpty()) {
						//只有这一个柱子，不会储水，
						stk.push(curIndex++);
					}else {
						int left = stk.peek();
						//关于高度，要找最矮的那个柱子，
						ans+= (curIndex-left-1)*(Math.min(height[left],height[curIndex])-height[hole]);
					}
				}else {
					stk.push(curIndex++);
				}
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		
	}
}


/*

42. Trapping Rain Water
Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/