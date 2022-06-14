/*
 * 700. Search in a Binary Search Tree
Easy
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

 

Example 1:


Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
Example 2:


Input: root = [4,2,7,1,3], val = 5
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
 */
package LeetCode;

public class T700 {
    public TreeNode searchBST(TreeNode root, int val) {
    	//利用一下BST的特性,可以剪枝
        return  DFS(root,val);
         
    }

	private TreeNode DFS(TreeNode node, int val) {
		if(node==null||node.val==val) {
			return node;
		}
		if(node.val>val) {
			return DFS(node.left,val);
		}else {
			return DFS(node.right,val);
		}
	}
}
