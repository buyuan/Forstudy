/*
 * 144. Binary Tree Preorder Traversal
Easy

3858

122

Add to List

Share
Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T144 {
	private List<Integer> result  = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //preorder, 中,左,右
    	dfs(root);
    	return result;   	
    }
	private void dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		result.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}
}
