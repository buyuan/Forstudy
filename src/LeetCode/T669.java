/*
 * 669. Trim a Binary Search Tree
Medium
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

 

Example 1:


Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
Example 2:


Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 104
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 104
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class T669 {
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root==null) {
			return root;
		}
		if(root.val>high) {
			//说明右侧树枝全大于high,不能用
			return trimBST(root.left,low,high);
		}
		if(root.val<low) {
			//说明左侧树枝全小于low,不能用
			return trimBST(root.right,low,high);
		}
		root.left=trimBST(root.left,low,high);
		root.right=trimBST(root.right,low,high);
		return root;
	}
	//用数组重建的思路,题目验证不了,还是得尽可能保证原来树得结构
	ArrayList<Integer> lst = new ArrayList<>();
    public TreeNode trimBST_2(TreeNode root, int low, int high) {
        DFS(root,low,high);
        int size = lst.size();
		int[] arr = new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=lst.get(i);
		}
        TreeNode result = buildBST(arr,0,size-1);
        return result;
    }



	private TreeNode buildBST(int[] arr,int left, int right) {
		if(left>right) {
			return null;
		}
		int mid = left+(right-left)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildBST(arr, left,mid-1);
		root.right =  buildBST(arr, mid+1,right);
		
		return root;
	}



	private void DFS(TreeNode node, int low, int high) {
		if( node==null){
			return ;
		}
		DFS( node.left,  low,  high);
		if(node.val<=high&&node.val>=low) {
			lst.add(node.val);
		}
		DFS( node.right,  low,  high);
	}
	
	
}
