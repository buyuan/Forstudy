/*
 * 235. Lowest Common Ancestor of a Binary Search Tree
Easy
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
 */
package LeetCode;

public class T235 {
	private TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //二叉搜索树,binary search tree, 左<中<右
    	int vP = p.val;
    	int vQ = q.val;
    	if(vP<vQ) {
    		this.helper(root,p,q);
    	}else {
    		this.helper(root,q,p);
    	} 	
    	return result;
    }
	private void helper(TreeNode node, TreeNode p, TreeNode q) {
		// TODO Auto-generated method stub
		if(node==null) {
			return;
		}
		if(node.val>p.val&&node.val<q.val) {
			result = node;
			return;
		}
		if(node.val==q.val||node.val==p.val) {
			result = node;
			return;
		}
		if(node.val<p.val) {
			this.helper(node.right,p,q);
		}
		if(node.val>q.val) {
			this.helper(node.left,p,q);
		}
	}
    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        //非递归方法
    	
    	int max ,min;
    	if(q.val>p.val) {
    		max=q.val;
    		min=p.val;
    	}else {
    		max=p.val;
    		min=q.val;   		
    	}
    	while(true) {
    		if(root.val<max&&root.val>min) {
    			return root;
    		}
    		if(root.val==max||root.val==min) {
    			return root;
    		}
    		if(root.val>max) {
    			root = root.left;
    		}
    		if(root.val<min) {
    			root = root.right;
    		}
    	}
    }
}
