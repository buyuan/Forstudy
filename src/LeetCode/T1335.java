package LeetCode;

import java.util.Arrays;

public class T1335 {
	private int difLen, d;
	private int[][] dpMemo;
	private int[] jobDifficulty;
	private int[] hardestJobRemaining;
	private int dp(int i, int day) {
		//base case for the last day, the difficult is 
		//从第i个工作开始，剩余工作中，最难第工作
		//dp(i,day)表示，在第day天开始，从第i个job开始做最终得到第最小难度总和
		if(day ==d) {
			return hardestJobRemaining[i];
		}
		if(dpMemo[i][day]==-1) {
			int best = Integer.MAX_VALUE;
			int hardest =-1;
			//找从第i个工作开始，在day天可能做的工作第最难第那个
			for(int j=i;j<difLen-(d-day);j++) {
				hardest = Math.max(hardest, jobDifficulty[j]);
				best = Math.min(best, hardest+dp(j+1,day+1));
			}
			dpMemo[i][day]=best;
		}
		return dpMemo[i][day];
	}
    public int minDifficulty(int[] jobDifficulty, int d) {
    	difLen = jobDifficulty.length;
    	if(difLen<d) {
    		return -1;//不可能每天都有job
    	}
    	hardestJobRemaining = new int[difLen];
    	int hardestjob = 0;
    	for( int i=difLen-1;i>=0;i--) {
    		hardestjob = Math.max(hardestjob, jobDifficulty[i]);
    		hardestJobRemaining[i] = hardestjob;
    	}
    	
    	dpMemo = new int[difLen][d+1];
    	for(int i=0;i<difLen;i++) {
    		Arrays.fill(dpMemo[i], -1);
    	}
    	this.d=d;
    	this.jobDifficulty = jobDifficulty;
    	return dp(0,1);
    } 
}

/*
1335. Minimum Difficulty of a Job Schedule
Hard
、
You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.

You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

 

Example 1:


Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7 
Example 2:

Input: jobDifficulty = [9,9,9], d = 4
Output: -1
Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
Example 3:

Input: jobDifficulty = [1,1,1], d = 3
Output: 3
Explanation: The schedule is one job per day. total difficulty will be 3.
 

Constraints:

1 <= jobDifficulty.length <= 300
0 <= jobDifficulty[i] <= 1000
1 <= d <= 10
*/