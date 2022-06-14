/*
 * 285. Inorder Successor in BST
Medium
Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.

The successor of a node p is the node with the smallest key greater than p.val.

 

Example 1:


Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:


Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
All Nodes will have unique values.
 */
package LeetCode;

public class T285 {
	//1. 中序遍历BST,找到P, 那么下一次的节点就是结果
	boolean flag=false;
	TreeNode result=null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(root==null||p==null) {
        	return null;
        }
        inorderSuccessor(root.left,p);
        if(flag) {
        	result = root;
        	flag=false;
        }
        if(root.val==p.val) {
        	flag=true;
        }
        inorderSuccessor(root.right,p);
        return result;
    }
    
    //2 用BST的有序特性, 选择迭代的方向
    //相当于直接找到P,
    public TreeNode inorderSuccessor_2(TreeNode root, TreeNode p) {
    	return null;
    }


}
