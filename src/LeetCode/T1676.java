/*
 * 676. Lowest Common Ancestor of a Binary Tree IV
Medium
Given the root of a binary tree and an array of TreeNode objects nodes, return the lowest common ancestor (LCA) of all the nodes in nodes. All the nodes will exist in the tree, and all values of the tree's nodes are unique.

Extending the definition of LCA on Wikipedia: "The lowest common ancestor of n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every pi as a descendant (where we allow a node to be a descendant of itself) for every valid i". A descendant of a node x is a node y that is on the path from node x to some leaf node.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
Output: 2
Explanation: The lowest common ancestor of nodes 4 and 7 is node 2.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1]
Output: 1
Explanation: The lowest common ancestor of a single node is the node itself.

Example 3:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
Output: 5
Explanation: The lowest common ancestor of the nodes 7, 6, 2, and 4 is node 5.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-109 <= Node.val <= 109
All Node.val are unique.
All nodes[i] will exist in the tree.
All nodes[i] are distinct.
 */
package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class T1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        //和左右节点左右找LCA是一样的，如果左右都有，那么就是中间，如果只有一边，那就是最早发现的那个
    	//因为是从上到下找，所以不用担心找到某个子树的某个节点是部分节点的ＬＣＡ
		Set<TreeNode> nSet = new HashSet<>();
		for(TreeNode tn : nodes) {
			nSet.add(tn);
		}
		
		return findLCA(root,nSet);
		
		
	}

	private TreeNode findLCA(TreeNode node, Set<TreeNode> nSet) {
		if(node==null) {
			return null;
		}
		if(nSet.contains(node)) {
			//因为是从上到下找,找到找一个以后,就无法再往下了
			return node;
		}
		
		TreeNode left = findLCA(node.left,nSet);
		TreeNode right= findLCA(node.right,nSet);
		if(left!=null&&right!=null) {
			//左右都有,那么这个就是了
			return node;
		}
		//如果只有一边有,(至少有一边有, 因为是从上到下找的
		if(left==null) {
			return right;
		}else {
			return left;
		}
	}
}
