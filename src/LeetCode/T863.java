/*
 * 863. All Nodes Distance K in Binary Tree
Medium

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
 */
package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    	//build a map, child,parent
    	HashMap<TreeNode ,TreeNode> parent = new HashMap<>();
    	dfs(parent,root,null);

    	List<Integer> res = new LinkedList<>();
    	Queue<TreeNode> qu = new LinkedList<>();
    	//1. find res from the three target as root
    	findRes(res,target,k);
    	//2.run k times 向上
    	TreeNode child = target;
    	TreeNode par=null;
    	for(int i=1;i<=k;i++) {
    		par = parent.get(child);
            if(par==null){
                break;
            }
    		int step = k-i-1;
    		if(step>=0) {
    			//此时是从当前节点的父节点的另一个子节点去找
        		if(par.left==child&&par.right!=null) {
        			findRes(res,par.right,step);
        		}else if(par.right==child&&par.left!=null) {
        			findRes(res,par.left,step);
        		}
    		}else {
    			//此时是步长已经不够到节点父节点的另一个子节点了,就是直接父节点了.
    	        if(parent.get(child)!=null){
    	            res.add(parent.get(child).val);
    	        }
    		}
    		child = par;
    	}
    	
    	return res;
    }



	private void dfs(HashMap<TreeNode, TreeNode> parent, TreeNode child, TreeNode papa) {
		// TODO Auto-generated method stub
		//建立节点和父节点关系
		if(child==null) {
			return ;
		}
		parent.put(child, papa);
		if(child.left!=null) {
			dfs(parent,child.left, child);
		}
		if(child.right!=null) {
			dfs(parent,child.right, child);
		}
	}



	private void findRes(List<Integer> res, TreeNode target, int k) {
		// TODO Auto-generated method stub
		//这个是一圈一圈扩散找节点的方法
		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(target);
		int count =0;
		while(!qu.isEmpty()) {
			int size = qu.size();
			for(int i=0;i<size;i++) {
				TreeNode cur = qu.poll();
				if(count==k) {
					res.add(cur.val);
				}else {
					if(cur.left!=null) {
						qu.add(cur.left);
					}
					if(cur.right!=null) {
						qu.add(cur.right);
					}
				}

			}
			count++;
		}
		
	}
}
