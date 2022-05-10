/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
Medium
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */
package LeetCode;

import java.util.HashMap;

public class T106 {
	private int index;
	HashMap<Integer, Integer> hm;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
        	hm.put(inorder[i], i);
        }
        return helper(postorder,0,index);
    }
	private TreeNode helper(int[] postorder, int left, int right) {
		if(right<left) {
			//从右到左
			return null;
		}
		int val = postorder[index];
		index--;
		TreeNode root = new TreeNode(val);
		int idx = hm.get(val);
		//先右后作,因为根顺序是先右后左(index--)
		root.right=helper(postorder,idx+1,right);
		//注意不总是从0, 因为中间会分叉
		root.left=helper(postorder,left,idx-1);
		
		return root;
	}
}
