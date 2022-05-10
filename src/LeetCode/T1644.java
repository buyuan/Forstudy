/*
 * 1644. Lowest Common Ancestor of a Binary Tree II
Medium

Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.

According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)". A descendant of a node x is a node y that is on the path from node x to some leaf node.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:



Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5. A node can be a descendant of itself according to the definition of LCA.
Example 3:



Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
Output: null
Explanation: Node 10 does not exist in the tree, so return null.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
 */
package LeetCode;

public class T1644 {
	private TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.helper(root,p,q);
        return result;
    }
	private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
		// TODO Auto-generated method stub
		if(node==null||result!=null) {
			return false;
		}
		int left  =  this.helper(node.left,p,q)?1:0;
		int right =  this.helper(node.right,p,q)?1:0;
		int mid   =  (node==q||node==p)?1:0;//这个地方就是能够造成有值的地方,找到以后,一路返回(往上),都能返回一,
		if(left+right+mid>=2) {
			this.result=node;
			return true;
		}
		if(left+right+mid==0) {
			//q,p至少有一个不在树上
			result = null;
			return false;
		}
		if(left+right+mid>0) {
			return true;
		}
		return false;
	}
}
