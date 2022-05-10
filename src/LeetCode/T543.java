/*
 * 543. Diameter of Binary Tree
Easy

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

 */
package LeetCode;

public class T543 {
	private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
    	//叶子之间的距离才有可能是最远距离,所以,要找到叶子之间的最大距离
    	//方法是,找每个root的左叶子到右叶子的距离,如果更大,则保留这个值
    	//返回的是root的左右半支距离中更大的那个值,用于这个节点上一层节点计算使用
    	len(root);
    	return diameter;
    	
    }
	private int len(TreeNode root) {
		// root左右支的长度和如果大于diameter, 那么diameter更新,
		//本身返回左右支的较大着,作为上一级node的计算依据
		if(root==null) {
			return 0;
		}
		int leftLen = len(root.left);
		int rightLen = len(root.right);
		diameter=Math.max(diameter,leftLen+rightLen);
		return Math.max(leftLen,rightLen)+1;		
	}


    
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
