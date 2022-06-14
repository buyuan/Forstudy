/*
 * 98. Validate Binary Search Tree
Medium
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T98 {
    public boolean isValidBST_1(TreeNode root) {
    	if(root==null) {
    		return true;
    	}
    	return valid(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

	private boolean valid(TreeNode node, long high, long low) {
		if(node==null) {
			return true;
		}
		if(node.val<=low||node.val>=high) {
			return false;
		}
		return valid(node.left,node.val,low)&&valid(node.right,high,node.val);
	}
	
	public boolean isValidBST_2(TreeNode root) {
		//遍历树,如果不是有序的,说明不是BST
		return inorder(root,null);
		
	}

	private boolean inorder(TreeNode node,TreeNode preNode) {
		if(node==null) {
			return true;
		}
		
		boolean left = inorder(node.left,preNode);
		if(!left) {
			return left;
		}
		if(preNode!=null) {
			if(node.val<=preNode.val) {
				return false;
			}
		}
		preNode = node;	
		return inorder(node.right,preNode);
	}
	
	public boolean isValidBST_3(TreeNode root) {
		//遍历树,如果不是有序的,说明不是BST
		List<Integer> lst = new ArrayList<>();
		inrecur(root,lst);
		for(int i=0;i<lst.size()-1;i++) {
			if(lst.get(i+1)<=lst.get(i)) {
				return false;
			}
		}
		return true;
		
	}

	private void inrecur(TreeNode root, List<Integer> lst) {
		if(root==null) {
			return ;
		}
		inrecur(root.left,lst);
		lst.add(root.val);
		inrecur(root.right,lst);
	}
}
