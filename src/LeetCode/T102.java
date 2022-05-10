

/*
 * 102. Binary Tree Level Order Traversal
Medium
Given the root of a binary tree, return the
 level order traversal of its nodes' values.
  (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
Accepted
1,151,446
Submissions
1,906,764package LeetCode;
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {
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
	static List<List<Integer>> result = new ArrayList<List<Integer>>();//全局
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if(root==null) {
    		return null;
    	}
    	helper(root,0);
    	return result;
    }
    public static void helper(TreeNode node, int level) {
    	//preorder root,left,right
        //层和List 的size的关系,如果是0层,当size=0的时候,需要一个存0层数据,当1层,size=1的时候,说明需要一个新的存1层,因为0层用来存0层的
    	//所以,当size和level相等的时候,则说明需要新增数组了, (如果是从1曾开始,则是超过的时候需要新增)
    	if(result.size()==level) {
    		result.add(new ArrayList<Integer>());
    	}
    	result.get(level).add(node.val);
    	if(node.left!=null) {
    		helper(node.left,level+1);
    	}
    	if(node.right!=null) {
    		helper(node.right,level+1);
    	}
    	
    }
    
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
    	//就是想办法把每一层的内容分开来
    	//因为队列中,每次都是把节点的左右子节点入队,那么如果直到当前节点的size,那么我做几次这个动作
    	//就是把这几个节点的左右子节点入队,即,下一层入队
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root==null) {return res;}
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
		int level=0;
    	while(!queue.isEmpty()) {
    		res.add(new ArrayList<Integer>());
    		int size =queue.size();//这个必须先存,因为for里面size会变
    		for(int i=0;i<size;i++) {
    			//把这一层的节点全出队,然后同时把他们的子节点全入队
    			TreeNode tn = queue.poll();
    			res.get(level).add(tn.val);
    			if(tn.left!=null) {
    				queue.add(tn.left);
    			}
    			if(tn.right!=null) {
    				queue.add(tn.right);
    			}
    		}
    		level++;
    	}
    	return res;
    	
    }
    public static void main(String[] args) {
    	

    }
}
