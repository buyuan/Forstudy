/*
 * 230. Kth Smallest Element in a BST
Medium
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 */
package LeetCode;

import java.util.Stack;

public class T230 {
	public int count;
    public int kthSmallest(TreeNode root, int k) {
    	count=k;
        return dfs(root);
    }

	private int dfs(TreeNode node) {
        if(node==null){
            return -1;
        }
		int lft = -1;
		if(node.left!=null) {
			lft=dfs(node.left);
		}

		if(count==0) {
			return lft;
		}
		count--;
		if(count==0) {
			return node.val;
		}
		return dfs(node.right);
	}
    public int kthSmallest_stack(TreeNode root, int k) {
    	Stack<TreeNode> stk=new Stack<>();
    	TreeNode p = root;
    	while(p!=null||!stk.isEmpty()) {
    		//一路走到左叶子
    		while(p!=null) {
    			stk.push(p);
    			p=p.left;
    		}
    		p=stk.pop();
    		k--;
    		if(k==0) {
    			return p.val;
    		}
    		p=p.right;
    	}
    	return -1;
    }	
}
