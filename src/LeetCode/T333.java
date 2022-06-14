/*
 * 333. Largest BST Subtree
Medium
Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.

A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:

The left subtree values are less than the value of their parent (root) node's value.
The right subtree values are greater than the value of their parent (root) node's value.
Note: A subtree must include all of its descendants.

 

Example 1:



Input: root = [10,5,15,1,8,null,7]
Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one. The return value is the subtree's size, which is 3.
Example 2:

Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-104 <= Node.val <= 104
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T333 {

	//1)把每一个节点都作为根节点,验证是不是BST,如果是,顺便数一下节点数,
	int result=0;
	public int largestBSTSubtree_3(TreeNode root) {
		dfs(root);
		return result;
	}
	
	private void dfs(TreeNode root) {
		if(root==null) {
			return ;
		}
		int d = count(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
		if(d!=-1) {
			result = Math.max(d, result);
		}
		dfs(root.left) ;
		dfs(root.right) ;
	}

	private int count(TreeNode node, int max, int min) {
		if(node==null) {
			return 0;
		}
		if(node.val>=max||node.val<=min) {
			return -1;
		}
		int left = count(node.left,node.val, min);
		if (left==-1) {
			return -1;
		}
		int right =count(node.right,max, node.val); 
		if (right==-1) {
			return -1;
		}
		return left+right+1;
	}

	//下面这个方法是先遍历,然后找最大连续递增数组,但是这个思路不对,
	//因为BST还需要叶子节点层级相同
	ArrayList<Integer> lst = new ArrayList<>();;
    public int largestBSTSubtree_2(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	DFS(root);
    	int size = lst.size();
    	int[] arr = new int[size];
    	for(int i=0;i<size;i++) {
    		arr[i]=lst.get(i);
    	}
    	return longest(arr);
    }
	private int longest(int[] arr) {
		int result=0;
		int left=0;int right=1;
		int bound = arr.length;
		while(right<bound) {
			if(arr[right]<arr[right-1]) {
				result = Math.max(right, right-left);
				left=right;
			}
			right++;
		}
		return result;
	}
	private void DFS(TreeNode root) {
		if(root==null) {
			return;
		}
		DFS(root.left);
		lst.add(root.val);
		DFS(root.right);
	}
}
