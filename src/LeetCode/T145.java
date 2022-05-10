/*
 * 145. Binary Tree Postorder Traversal
Easy

3967

135

Add to List

Share
Given the root of a binary tree, return the postorder traversal of its nodes' values.

 
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T145 {
	private List<Integer> result  = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //Inorder, 右,左,中
    	dfs(root);
    	return result;   	
    }
	private void dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		dfs(root.left);	
		dfs(root.right);
		result.add(root.val);
	}
}
