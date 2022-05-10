/*
 * 112. Path Sum
Easy
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
package LeetCode;

public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
    	//注意判断,是该节点是叶子才行
    	if(root==null) {
    		return false;
    	}
        int cursor=root.val;
        if( dfs(root.left,cursor,targetSum)) {
        	return true;
        }
       	if(dfs(root.right,cursor,targetSum)) {
       	 	return true;
       	}
       //in case only one node
       return cursor==targetSum;
       
    }

	private boolean dfs(TreeNode node, int cursor, int targetSum) {
        if(node==null){
            return false;
        }
		int cur = cursor+node.val;
        if( dfs(node.left,cur,targetSum)) {
        	return true;
        }
       	if(dfs(node.right,cur,targetSum)) {
       	 	return true;
       	}		
       	if(node.left==null&&node.right==null) {
       		return cur==targetSum;
       	}
       	return false;
		
	}
    
}
