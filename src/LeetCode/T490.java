/*
 * 490. The Maze
Medium
There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).

 

Example 1:


Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
Example 2:


Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
Output: false
Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
Example 3:

Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
Output: false
 

Constraints:

m == maze.length
n == maze[i].length
1 <= m, n <= 100
maze[i][j] is 0 or 1.
start.length == 2
destination.length == 2
0 <= startrow, destinationrow <= m
0 <= startcol, destinationcol <= n
Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
The maze contains at least 2 empty spaces.
 */
package LeetCode;

public class T490 {
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {//
    	//把maze的0变成-1标志为作为过start, 不是要把路径的点也改成-1,直接用这个function DFS
    	int row = start[0];
    	int col = start[1];
        if(row==destination[0]&&col==destination[1]) {
        	return true;
        }
        if(maze[row][col]==-1) {
        	return false;
        }
        maze[row][col]=-1;
        int rL = maze.length;
        int cL = maze[0].length;
        int l,r,u,d;//left. right, upwards,downwards
        //left
        l=col;
        while(l>=0&&maze[row][l]!=1) {
        	l--;
        }
        if(hasPath(maze,new int[] {start[0],l+1}, destination)) {
        	return true;
        }
        //right
        r=col;
        while(r<cL&&maze[row][r]!=1) {
        	r++;
        }
        if(hasPath(maze,new int[] {start[0],r-1}, destination)) {
        	return true;
        }
        //upwards
        u=row;
        while(u>=0&&maze[u][col]!=1) {
        	u--;
        }
        if(hasPath(maze,new int[] {u+1,start[1]}, destination)) {
        	return true;
        }
        //downwards
        d=row;
        while(d<rL&&maze[d][col]!=1) {
        	d++;
        }
        if(hasPath(maze,new int[] {d-1,start[1]}, destination)) {
        	return true;
        }
       return false; 
    }

    public static void main(String[] args) {
    	int[][] m1={{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};int[] s1= {0,4}; int[] d1 = {4,4};
    	
    	int[][] maze=m1;int[] start=s1;int[] destination=d1;
    	System.out.println(hasPath( maze,  start,  destination));
    }
    
}
