/**
 * 56. Merge Intervals

Share
Given an array of intervals where intervals[i] = [starti, endi],
 merge all overlapping intervals, and return an array of the non-overlapping 
 intervals that cover all the intervals in the input.
 */

package LeetCode;

import java.util.ArrayList;

public class T56 {
    public static int[][] merge(int[][] intervals) {
    	//Sort the arr by the left edge
        for(int i =0;i<intervals.length-1;i++) {
        	for(int j=0;j<intervals.length-i-1;j++) {
        		if(intervals[j][0]>intervals[j+1][0]) {
        			int temp[] = intervals[j+1];
        			intervals[j+1]=intervals[j];
        			intervals[j]=temp;
        		}
        	}
        }
        
        //Start to merge
        ArrayList<int[]> result = new ArrayList<>();
        int size =0;
        int[] cur = {intervals[0][0],intervals[0][1]};
        // int[] temp = intervals[0]; At the first time I use this, that is a address pass, intervals[0] will be edited if temp is edited.
        int[] last =cur;
       for(int i=1;i<intervals.length;i++) {
        	if(intervals[i][0]>cur[1]) {//no overlap
//        		result.add(cur);
//        		size++;
        		last = cur;
        		cur = intervals[i];		
        	}else if(intervals[i][1]<cur[1]) {//temp can fully cover intervals[i] 
//        		result.add(cur);
//        		size++;
        	}else {//partial overlap
        		last = cur;
        		cur[1] = intervals[i][1];
        	}
        	if(last!=cur) {
        		result.add(last);
        		last = cur;
        		size++;
        	}
        }
        //in case the last one is missing
        if(size==0||(cur[1]!=result.get(size-1)[1])){
        	result.add(cur);
        	size++;
        }
        
        int[][] resultInt = new int[size][];
        int i =0;
        for(int[] ele: result) {
        	resultInt[i++]=ele;
        }
        return resultInt;
    }
    
    //only insert when no overlap, or just adjust the edge
    public static int[][] merge2(int[][] intervals) {
    	//Sort the arr by the left edge
        for(int i =0;i<intervals.length-1;i++) {
        	for(int j=0;j<intervals.length-i-1;j++) {
        		if(intervals[j][0]>intervals[j+1][0]) {
        			int temp[] = intervals[j+1];
        			intervals[j+1]=intervals[j];
        			intervals[j]=temp;
        		}
        	}
        }
        
       
        //Start to merge
        ArrayList<int[]> result = new ArrayList<>();
        int size =0;
        int cur[] = {intervals[0][0],intervals[0][1]};
        for(int i =1;i<intervals.length;i++) {
        	if(intervals[i][0]>cur[1]) {
        		result.add(cur);
        		size++;
        		cur = intervals[i];
        	}else {//merge
        		cur[1] = cur[1]>intervals[i][1]?cur[1]:intervals[i][1];
        	}
        }
      //incase only one item in interval or the last one merge nor add
        if(size==0||(cur[1]!=result.get(size-1)[1])){
        	result.add(cur);
        	size++;
        }
        
        int[][] resultInt = new int[size][];
        int i =0;
        for(int[] ele: result) {
        	resultInt[i++]=ele;
        }
        return resultInt;
    }
    
	public static void main(String[] args) {
		//test case
		int[][] intervals4 = {{4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}};
		int[][] intervals1 ={{2,3},{4,5},{6,7},{8,9},{1,10}};
		int[][] intervals2 = {{4,5},{1,4}};
		int[][] intervals3= {{2,6},{8,10},{1,3},{15,18}};
		
		//start test
		int[][] testcase = intervals4;
		int[][] result = merge2(testcase);
		for(int[] ele:testcase) {
			System.out.print(ele[0]+ " "+ele[1]);
			System.out.println();
		}
		System.out.println("                            ");
		for(int[] ele:result) {
			System.out.print(ele[0]+ " "+ele[1]);
			System.out.println();
		}
	}
}
