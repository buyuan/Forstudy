/*
 * 101. Symmetric Tree
Easy
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 
 */
package LeetCode;

public class T101 {
    public boolean isSymmetric(TreeNode root) {
        //判断镜像, n1.left==n2.right, n1.right=n2.left
    	if(root==null) {
    		return true;
    	}
    	return isMirror(root.left,root.right);
    }

	private boolean isMirror(TreeNode n1, TreeNode n2) {
		// TODO Auto-generated method stub
		if(n1==null&n2==null) {
			return true;
		}
		if(n1==null||n2==null||n1.val!=n2.val) {
			return false;
		}
		return isMirror(n1.left,n2.right)&&isMirror(n1.right,n2.left);
	}
}
