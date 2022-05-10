/*
 * 236. Lowest Common Ancestor of a Binary Tree
Medium
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
package LeetCode;

public class T236 {
	private TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //最低共同祖先,有两种可能,1.p,q在这个节点的左右两边 2. q是p的祖先或者p是q的祖先
    	this.helper(root,p,q);
    	return this.result;
    }
	private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
		if(node==null) {
			return false;
		}
		if(this.result!=null) {
			return false;
		}
		//下面用整数表示flag,因为会有三选二的情况,用boolean不方便
		int left = this.helper(node.left,p,q)?1:0;
		int right = this.helper(node.right,p,q)?1:0;

		int parent=0;
		if(node==q||node==p) {
			parent=1;
		}
		if(left+right+parent>1) {
			this.result=node;
			return true;
		}
		if(left+right+parent>0) {
			//说明这个节点至少能找到q或者p
			return true;
		}else {
			return false;
		}
	}
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

}

