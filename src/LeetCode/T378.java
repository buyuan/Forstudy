/**
 * 378. Kth Smallest Element in a Sorted Matrix
Medium

Given an n x n matrix where each of the rows and columns is sorted in 
ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth
distinct element.

You must find a solution with a memory complexity better than O(n2).
Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], 
and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
 */
package LeetCode;

import java.util.PriorityQueue;

public class T378 {
    public int kthSmallest(int[][] matrix, int k) {
    	//too slow, should think about other method
        PriorityQueue<Integer> res = new PriorityQueue<Integer>();
        for(int[] x:matrix) {
        	for(int y:x) {
        		res.offer(y);
        	}
        }
        while(k>1) {
        	k--;
        	res.poll();
        	
        }
        return res.poll();
    }
    public static int kthSmallest_new(int[][] matrix, int k) {
    	//方法来自于https://www.youtube.com/watch?v=Lo23qFLhJNY
    	//从(0,0)开始,每次找到一个最小的,钱相邻(右,下)之中肯定有下一个最小的,从这些最小的值里面继续往下找
    	PriorityQueue<node> candidate = new PriorityQueue<>((x,y)->(x.val-y.val));
    	int mR = matrix.length;
    	int mC = matrix[0].length;
    	boolean[][] checked = new boolean[mR][mC];
    	T378 out = new T378();
    	node cur = out.new node(0,0,matrix[0][0]);
    	checked[0][0] = true;
    	for(int i=0;i<k-1;i++) {
    		int Px = cur.x;
    		int Py = cur.y;
    		if((Px+1<=mR-1)&&!checked[Px+1][Py]) {
    			candidate.offer(out.new node(Px+1,Py,matrix[Px+1][Py]));
    			checked[Px+1][Py] = true;
    		}
    		if((Py+1<=mC-1)&&!checked[Px][Py+1]) {
    			candidate.offer(out.new node(Px,Py+1,matrix[Px][Py+1]));
    			checked[Px][Py+1] = true;
    		}
    		cur = candidate.poll();
    	}
    	return cur.val;
    	
    }
    class node{
    	int x;
    	int y;
    	int val;
    	node(int x, int y,int val){
    		this.x =x;
    		this.y =y;
    		this.val = val;
    	}
    }
    public static int kthSmallest_bina(int[][] matrix, int k) {
    	//binary search
//    	long lower = Integer.MIN_VALUE;//也可以用左上角和右下角
//    	long upper = Integer.MAX_VALUE;
    	int lower = matrix[0][0];
    	int upper = matrix[matrix.length-1][matrix[0].length-1];
    	
    	while(lower<upper) {
    		//只有lower+才有效,是因为mid值是从小到达排列所以菜OK吗?因为lower+1 = mid, 实际要从小的增上去,而不能从大的减下来,且加上matrix是增序排列
    		//注意,我在找数据,并不是在移动位置,最终中跳出循环,lower值,就是那个目标值,而不是位置
    		int mid = lower+(upper-lower)/2;
    		//int mid = (upper+lower)/2;//用这个会死循环
    		int count = numberOfNoBiggerThan(mid,matrix);//卡不出k个数,说明k个数在这个数字的后面,卡出来,说明在前面,
    		if(count<k) {
    			lower = mid;
    		}else {
    			upper = mid-1;
    		}
    	}
    	return upper;
    }
    private static int numberOfNoBiggerThan(int mid,int[][] matrix) {
    	int x =0;
    	int y = matrix[0].length-1;
    	int count =0;
    	int size = matrix.length;
    	while(y>=0&&x<size) {
        	if(matrix[x][y]<=mid) {//这里要右等于,因为从上到下,包含自己那个也算
        		//往下走,且左边的数字全小于mid
        		count+=y+1;
        		x++;
        	}else {
        		//往左
        		y--;
        	}
    	}

		return count;
	}
	public static void main(String[] args) {
    	int[][] matrix1 = {{1,5,9},{10,11,13},{12,13,15}}; int k1 =8;
    	int[][] matrix2 = {{-5}}; int k2 =1;
    	int[][] matrix3 = {{1,5,9},{10,11,13},{12,13,100}}; int k3 =8;
    	
    	int[][] testcase = matrix3; int TK = k3;
    	display(testcase);
    	int result = kthSmallest_bina(testcase,TK);
    	System.out.println(result);
    }
	private static void display(int[][] testcase) {
		// TODO Auto-generated method stub
		for(int[] x:testcase) {
			for(int y:x) {
				System.out.print(y+",\t");
			}
			System.out.println();
		}
	}
}
