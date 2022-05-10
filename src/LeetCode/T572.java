/*
 * 572. Subtree of Another Tree
Easy

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
 */
package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class T572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //用BFS, 找到和subR相同的值的时候,开始对比.
    	if(root==null||subRoot==null) {
    		return false;
    	}
    	Queue<TreeNode> qu = new LinkedList<>();
    	qu.add(root);
    	int tar = subRoot.val;
    	while(!qu.isEmpty()) {
    		TreeNode cur = qu.poll();
    		if(cur.val==tar) {
    			//因为有重复值的节点,所以如果这个不是,就找下一个
    			if( compare_DFS(cur,subRoot)) {
    				return true;
    			}
    		}
    		if(cur.left!=null) {
    			qu.add(cur.left);
    		}
    		if(cur.right!=null) {
    			qu.add(cur.right);
    		}
    	}
    	
    	return false;
    }

	private boolean compare_BFS(TreeNode node, TreeNode subRoot) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.add(node);
		q2.add(subRoot);
		while(!q1.isEmpty()) {
			TreeNode curN = q1.poll();
			TreeNode curS = q2.poll();
            if(curN==null||curS==null){
                return false;
            }
			if(curN.val!=curS.val) {
				return false;
			}
    		if(curN.left!=null&&curS.left!=null) {
    			q1.add(curN.left);
    			q2.add(curS.left);
    		}else if(curN.left==null&&curS.left==null){
              
            }else{
                  return false;
            }
    		if(curN.right!=null&&curS.right!=null) {
    			q1.add(curN.right);
    			q2.add(curS.right);
    		}else if(curN.right==null&&curS.right==null){
              
            }else{
                  return false;
            }
		}
		if(!q2.isEmpty()) {
			return false;
		}
		return true;
	}
	private boolean compare_DFS(TreeNode node, TreeNode subRoot) {
		if(node==null&&subRoot==null) {
			return true;
		}
		if(node==null||subRoot==null) {
			return false;
		}
		if(node.val!=subRoot.val) {
			return false;
		}
		return compare_DFS(node.left, subRoot.left)&&compare_DFS(node.right, subRoot.right);
	}
}
