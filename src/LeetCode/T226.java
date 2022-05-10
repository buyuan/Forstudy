/*
 * 226. Invert Binary Tree
Easy
Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
package LeetCode;


public class T226 {
    public TreeNode invertTree(TreeNode root) {
    	//这是一个从上到下的倒置
    	if(root!=null){
    		swap(root);
    	}   	
    	return root;
    }

	private void swap(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		TreeNode temp = new TreeNode();
		temp = root.left;
		root.left=root.right;
		root.right=temp;
		swap(root.left);
		swap(root.right);
	}
	 public TreeNode invertTree_fast(TreeNode root) {
		 //这个是从下到上
		 if(root == null) {
			 return null;
		 }
		 TreeNode nLeft = invertTree_fast(root.left);
		 TreeNode nRight = invertTree_fast(root.right);
		 root.left = nRight;
		 root.right=nLeft;
		 
		 return root;
	 }
}

