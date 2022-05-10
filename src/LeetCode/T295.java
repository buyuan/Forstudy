/**
 * 295. Find Median from Data Stream
Hard

The median is the middle value in an ordered integer list. 
If the size of the list is even, there is no middle value and the median is the mean 
of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of 
the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */
package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T295 {
	class MedianFinder {
		//注意,实际给的不是一个有序数组
		//思路就是用PQ, 一个小堆,一个大堆,大堆从小到大,放前半部分数据,小堆从大到小,放后半部分数据,这样的话,两个堆的顶就是中间
		PriorityQueue<Integer> LagPop;
		PriorityQueue<Integer> SmlPop;
	    public MedianFinder() {
	    	LagPop = new PriorityQueue<>((x,y)->(y-x));
	    	SmlPop = new PriorityQueue<>();
	    }
	    
	    public void addNum(int num) {
	    	//要保证大的和小的是连续的,保证大堆顶的数字都比小堆顶小
	        LagPop.offer(num);
	        SmlPop.offer(LagPop.poll());
	        if(LagPop.size()<SmlPop.size()) {
	        	//说明最终小堆要比大堆多一个,或者相等
	        	LagPop.offer(SmlPop.poll());
	        }
	    }
	    
	    public double findMedian() {
	    	double result ;
	        if(SmlPop.size()<LagPop.size()) {
	        	result = LagPop.peek();
	        }else {
	        	result = (SmlPop.peek()+LagPop.peek())/2.0;
	        }
        	return result;
	    }
	}
	public static void main(String[] args) {
		T295 out = new T295();
		MedianFinder result = out.new MedianFinder();
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> dip = new ArrayList<>();
		while(true) {
			System.out.println("choose function, 1. add. 2 findMedian");
			int inp = sc.nextInt();
			switch(inp) {
				case 1:
					System.out.println("Input number");
					int num = sc.nextInt();
					dip.add(num);
					display(dip);
					result.addNum(num);
					break;
				case 2:
					System.out.println(result.findMedian());
			}
		}
	}
	private static void display(ArrayList<Integer> dip) {
		for(int x:dip) {
			System.out.print(x+",");
		}
		System.out.println();
		
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
