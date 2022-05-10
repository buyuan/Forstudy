/**
 * [LeetCode] 346. Moving Average from Data Stream
 * easy
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class T346 {
    private static Queue<Integer> Q;
    int length;
    double sum;
	 /** Initialize your data structure here. */
    
	public T346(int size) {//MovingAverage
		Q =  new LinkedList<Integer>();
		this.length = size;
    }

    public double next(int val) {
    	if(Q.size()>=length) {
    		sum-=Q.poll();
    	}
		Q.offer(val);
		
		sum+=val;
    	return sum/(Q.size()*1.0);
    }
    
    public static void main(String[] arg) {
    	int[] tastcaseInput= {1,10,3,5,2,6,3,7};
    	double[] tastcaseOutput= {1,5.5,4.6666,6.0,3.3333,4.3333,3.6666,5.3333};

    	T346 Q = new T346(3);
    	for(int i=0;i<tastcaseInput.length;i++) {
    	//	System.out.println( Q.next(tastcaseInput[i])+" : "+tastcaseOutput[i]);
    		double compare = Q.next(tastcaseInput[i])-tastcaseOutput[i];
    		if(compare<0.001) {
    			System.out.println(true);
    		}else {
    			System.out.println(false);
    		}
    	}
    	
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
