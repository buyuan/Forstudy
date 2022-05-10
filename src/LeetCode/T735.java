/**
 * 735. Asteroid Collision
Medium

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents 
its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller 
one will explode. If both are the same size, both will explode. Two asteroids moving in the same
 direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
package LeetCode;

import java.util.Stack;

public class T735 {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ast = new Stack<>();
        int size = asteroids.length;
        for(int i=0;i<size;i++) {
        	int cur = asteroids[i];
        	int last=0;
        	if(!ast.isEmpty()) {
        		last = ast.peek();  
        	}else {
        		ast.push(cur);
        		continue;
        	}   	
        	if(last>0&&cur<0) {//collision will happen
            	while(last>0&&cur<0&&!ast.isEmpty()) {
            		//result after collision
            		if((last+cur)==0) {
            			ast.pop();
            			cur=0;
            			break;
            		}
        			cur=last>(-1*cur)?last:cur;
        			ast.pop();
            		if(!ast.isEmpty()) {//find the last asteroid if exist
                		last = ast.peek();
            		}
            	}
            	if(cur!=0) {ast.push(cur);}
        	}else {
        		ast.push(cur);
        	}
        }
        int[] result = new int[ast.size()];
        int count =0;
        for(int x:ast) {
        	result[count++]= x;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	int[] case1 = {5,10,-5};
    	int[] case2 = {8,-8};
    	int[] case3 = {10,2,-5};
    	int[] case4 = {10,2,-5,5,-3};
    	int[] case5 = {10,2,5,-5,-3};
    	int[] case6 = {-2,-1,1,2};
    	int[] case7 = {-2,-2,2,-1};
    	int[] case8 = {1,-1,-2,-2};

    	int[] testcase = case1;
    	int[] result = asteroidCollision(testcase);
    	for(int x:testcase) {
    		System.out.print(x+",");   		
    	}
    	System.out.println();  
    	System.out.println("============================");  
    	for(int x:result) {
    		System.out.print(x+",");   		
    	}
    }
}
