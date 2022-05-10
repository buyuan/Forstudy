/**362. Design Hit Counter
 * medium
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
Each function accepts a timestamp parameter (in seconds granularity) and you may assume
 that calls are being made to the system in chronological order (ie, the timestamp is
  monotonically increasing). You may assume that the earliest timestamp starts at 1.
It is possible that several hits arrive roughly at the same time.
Example:
HitCounter counter = new HitCounter();
// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301); 

Follow up:
What if the number of hits per second could be very large? Does your design scale?
 */
package LeetCode;

import java.util.Random;

public class T362 {
	// 问题是存过去5分钟的点击数,所以,当时间到了7分钟时,就是2分钟到7分钟这段时间的点击数,就是头尾时间戳差值小于等于300
	//方法,用两个数组,一个存时间戳,一个存点击数,以300为mod, 超过300的时间戳,点击数重制.
	//两个数组相同下标的值的含义就是,时间数组的这个时间点,发生了点击数组时间点的点击次数
	
	/**
	 * 注意:
	 * 目前该方法只能实现,300内,任意时间之前的点击数, 以及300之后,600秒之内,前300的点击数
	 * 
	 */
	
	 /** Initialize your data structure here. */
	private int[] timeRec;
	private int[] hitCounts;
	
    public T362 () {//HitCounter
    	this.timeRec = new int[301];
    	this.hitCounts = new int[301];
    	
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
    	int curTime = timestamp%300;
    	if(timeRec[curTime]!=timestamp) {//next round,over 300
    		timeRec[curTime] = timestamp;
    		hitCounts[curTime] =1;   		
    	}else {
    		hitCounts[curTime] ++;
    	}  	
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	int result =0;
    	int left = timestamp>300?(timestamp-300):1;
    	int right = timestamp;
    	int indexLeft = left%300;
    	
    	int count = right-left+1;
    	while(count>0) {
    		count--;
    		result +=hitCounts[indexLeft++];
    		if(indexLeft==300) {
    			indexLeft =0;
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	T362 instance = new T362();
    	int length1 = 310;
    	int timeStemp1 = 310;
    	int length2 = 5;
    	int timeStemp2 = 3;
    	int length3 = 290;
    	int timeStemp3 = 290;
    	int length4 = 4;
    	int timeStemp4 =4;
    	int length5 = 700;
    	int timeStemp5 =700;
    	int length6 = 599;
    	int timeStemp6 =599; 	
    	
    	int testLength = length6;
    	int testTime = timeStemp6;
    	int[] testcase = initCase(testLength);
    	int targetResult = getResult(testcase,testTime);
    	//Start to test
    	for(int i=0;i<testcase.length;i++) {
    		for(int j=0;j<testcase[i];j++) {
    			instance.hit(i+1);
    		}
    	}
    	int output = instance.getHits(testTime);
    	
    	System.out.print(targetResult+" : "+ output);
    }

	private static int getResult(int[] testcase, int testTime) {
		int length = testcase.length;
		if(testTime>length) {
			testTime = length;
		}
		int result =0;
		int count =300;
		testTime = testTime-1;//此处转换为坐标
		while(testTime>=0&&count>0) {
			count--;
			result  += testcase[testTime--];
		}
		return result;
	}

	private static int[] initCase(int length) {
		// 生成一个 长度为length的值为随机数的数组
		Random rd = new Random();
		int[] result = new int[length];
		for(int i =0;i<length;i++) {
			result[i] = rd.nextInt(50);
		}
		return result;
	}
}

/**
 * /**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
