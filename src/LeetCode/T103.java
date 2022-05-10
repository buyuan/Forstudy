/*
 * 103. Binary Tree Zigzag Level Order Traversal
Medium

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
Accepted
667,708
Submissions
1,256,619
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode.T102.TreeNode;

public class T103 {
	public class TreeNode {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //思路就是正常BFS加入节点, 但是读数据的时候,翻转, 一次从头加,第二次从尾部加
    	//用null 节点来左翻转的标志
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root==null) {
    		return result;
    	}
    	LinkedList<Integer> cur = new LinkedList<>();//Use this type for add from tail
    	LinkedList<TreeNode> qu = new LinkedList<>();//for it support add from tail
    	qu.add(root);
    	qu.add(null);
    	boolean leftToRight=false;//the second level from right to left
    	while(!qu.isEmpty()) {
    		TreeNode tn= qu.poll();
    		if(tn!=null) {
    			//traverse
    			if(leftToRight) {
    				cur.addFirst(tn.val);
    			}else {
    				cur.addLast(tn.val);
    			}
    			//add child nodes
    			if(tn.left!=null) {
    				qu.add(tn.left);
    			}
    			if(tn.right!=null) {
    				qu.add(tn.right);
    			}
    		}else {
    			//flip to prepare next traverse
    			result.add(cur);
    			cur = new LinkedList<>();
    			leftToRight=!leftToRight;//flip
    			if(!qu.isEmpty()) {
    				qu.addLast(null);
    			}
    		}
    		
    	}  	
    	return result;
    }
}
