/*
 * 104. Maximum Depth of Binary Tree
Easy

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
package LeetCode;

public class T104 {
	private int result=0;
    public int maxDepth(TreeNode root) {
    	int step=0;
        dfs(root,step);
        return result;
    }
	private void dfs(TreeNode node,int step) {
		// TODO Auto-generated method stub
		if (node==null) {
			result=result>step?result:step;
			return;
		}
		step++;
		dfs(node.left,step);
		dfs(node.right,step);
	}
	
	public int maxDepth_2(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left = 1+maxDepth_2(root.left);
		int right = 1+maxDepth_2(root.right);
		return left>right?left:right;		
	}
}
