/*
 * 270. Closest Binary Search Tree Value
Easy
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
 */
package LeetCode;

public class T270 {
	int  result;
	double diff=Long.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {  	
        DFS(root,target);
        return result;
    }
	private void DFS(TreeNode node, double target) {
		// TODO Auto-generated method stub
		if(node==null) {
			return;
		}
		DFS(node.left,target);
		double cur = Math.abs(node.val-target);
		if(cur<diff) {
			result = node.val;
			diff=cur;
		}
		DFS(node.right,target);
	}
}
