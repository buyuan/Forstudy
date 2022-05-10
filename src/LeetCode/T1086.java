/**
 * 1086. High Five
 * easy
 * Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.

Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.

A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.

Example 1:

Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average

Example 2:

Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
Output: [[1,100],[7,100]]

Constraints:

1 <= items.length <= 1000
items[i].length == 2
1 <= IDi <= 1000
0 <= scorei <= 100
For each IDi, there will be at least five scores.
 */
package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class T1086 {
	public static int[][] highFive(int[][] items) {
		HashMap<Integer,PriorityQueue<Integer>> scores = new HashMap<>();
		class mycom implements Comparator<Integer>{
			@Override
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		}
		for(int[] x:items) {
			int index = x[0];
			PriorityQueue<Integer> scor = scores.getOrDefault(index,new PriorityQueue<Integer>(new mycom()));
			scor.offer(x[1]);
			scores.put(index, scor);
		}
		int size = scores.size();
		int[][] result = new int[size][2];
		int indx=0;
		for(int key:scores.keySet()) {
			PriorityQueue<Integer> item = scores.get(key);
			int aver=0;int count =5;int realSize=0;
			while(count>0&&item.size()>0) {
				count--;
				aver+=item.poll();
				realSize++;
			}
			aver/=realSize;
			result[indx][0]=key;
			result[indx++][1]=aver;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] case1 = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int[][] case2 = {{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100}};
		int[][] case3 = {{1,100},{7,100},{1,100},{7,100}};
		
		
		int[][] testcase = case3;
		int[][] result = highFive(testcase);
		for(int[] x:result) {
			for(int y:x) {
				System.out.print(y+",");
			}
			System.out.println();
		}
		
	}
}
