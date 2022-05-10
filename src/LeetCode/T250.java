/*
 * 250. Count Univalue Subtrees
Medium
Given the root of a binary tree, return the number of uni-value subtrees.

A uni-value subtree means all nodes of the subtree have the same value.

 

Example 1:


Input: root = [5,1,5,5,5,null,5]
Output: 4
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [5,5,5,5,5,null,5]
Output: 6
 

Constraints:

The number of the node in the tree will be in the range [0, 1000].
-1000 <= Node.val <= 1000
 */
package LeetCode;

public class T250 {
	private int count;
    public int countUnivalSubtrees(TreeNode root) {
    	if(root==null) {
    		return count;
    	}
    	helper(root);
    	return count;
	}
	private boolean helper(TreeNode node) {
		//check till the leaf,the leaf itself is univalue subtress
		if(node.left==null&&node.right==null) {
			count++;
			return true;
		}
		boolean checker=true;
		//below is the node that is not leaf
		if(node.left!=null) {
			checker= helper(node.left)&checker&(node.left.val==node.val);
		}
		if(node.right!=null) {
			checker= helper(node.right)&checker&(node.right.val==node.val);
		}		
		
		if(!checker) {
			//说明node这个节点往下不是univalue subtree
			return false;
		}
		count++;
		return true;
	}
    
}
