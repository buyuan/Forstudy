/*
 * 1110. Delete Nodes And Return Forest
Medium

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

 

Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.
 */
package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class T1110 {
	List<TreeNode> res ;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	res = new LinkedList<>();
    	if(root==null) {
    		return res;
    	}  	
        HashSet<Integer> arr = new HashSet<>();
        for(Integer x:to_delete) {
        	arr.add(x);
        }
        if(!arr.contains(root.val)) {
        	// 因为root没有上一级非空,所以单独处理,如果root需要删掉,这个在helper中已经能处理
        	res.add(root);
        }
        //用后序遍历,左,右,中,因为这样,左右处理完之后,再考虑如何保留或者删除根,不需要考虑多级节点
        root=def_helper(root,  arr);
        //如果root变成null,说明root删掉了
        if(root!=null) {
        	res.add(root);
        }
        return res;
    }
	private TreeNode def_helper(TreeNode node, HashSet<Integer> arr) {
		// TODO Auto-generated method stub
		if(node==null) {
			return node;
		}
		node.left=def_helper(node.left,  arr);
		node.right=def_helper(node.right, arr);
		if(arr.contains(node.val)) {
			if(node.left!=null) {
				res.add(node.left);
			}
			if(node.right!=null) {
				res.add(node.right);
			}
			return null;
		}else {
			return node;
		}
		
	}






}
