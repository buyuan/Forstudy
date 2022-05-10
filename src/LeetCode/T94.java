/*
 * 94. Binary Tree Inorder Traversal
Easy

7281

325

Add to List

Share
Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T94 {
	private List<Integer> result  = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //Inorder, 左,中,右
    	dfs(root);
    	return result;   	
    }
	private void dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		dfs(root.left);
		result.add(root.val);
		dfs(root.right);
	}
}
