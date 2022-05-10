/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
Medium
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */
package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class T105 {
	private int rootIndex=0;
	Map<Integer,Integer> iMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序,第一个是根,在中序中,根据根,就分出了左右
    	//关键点,preorder中的每一个点,都是一次创建中的root
    	iMap =new HashMap<>();
    	for(int i=0;i<inorder.length;i++) {
    		iMap.put(inorder[i],i);  		
    	}
    	return findRoot(preorder, 0, inorder.length-1);
    }
	private TreeNode findRoot(int[] preorder, int left, int right) {
		// TODO Auto-generated method stub
		//下面这个++最关键,因为每一次循环,从左到右,每个节点都会作为root被创建一次,注意,这个循环是从左边开始
		//左边创建完了之后,再去往右边\
		if(left<right) {
			return null;
		}
		int val = preorder[rootIndex];
		rootIndex++;
		
		TreeNode root =new TreeNode(val);		
		//一定要先从左边,因为前序就是中,左,右,所以,
		root.left = findRoot(preorder, 0, iMap.get(val)-1);
		root.right= findRoot(preorder, iMap.get(val)+1, right);
				
		
		return root;
	}
    
}
