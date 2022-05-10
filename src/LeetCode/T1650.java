/*
 * 1650. Lowest Common Ancestor of a Binary Tree III
Medium
Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q exist in the tree.
 */
package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class T1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        //先确定p往下是否能找到q,如果找不到,则说明LCA在上面
    	Queue<Node> qu = new LinkedList<>();
    	qu.add(p);
    	while(!qu.isEmpty()) {
    		Node cur = qu.poll();
    		if(cur==null) {
    			break;
    		}
    		if(cur==q) {
    			return p;  			
    		}
    		if(cur.left!=null) {
    			qu.add(cur.left);
    		}
    		if(cur.right!=null) {
    			qu.add(cur.right);
    		}  		
    	}
    	
    	//能到这,说明q不在p下面,找p的parent,然后找这个parent的另一支,有没有对方,没有就再往上
    	Node cursor=p.parent ;
    	while(cursor.parent!=null) {
    		if(cursor==q) {
    			return cursor;
    		}
    		if(cursor.left==p) {
    			//说明q不在左枝
    			if(this.helper(cursor.right,q)) {
    				return cursor;
    			}
    		}
    		if(cursor.right==p) {
    			//说明q不在右枝
    			if(this.helper(cursor.left,q)) {
    				return cursor;
    			}
    		}
    		p=p.parent;
    		cursor = cursor.parent;

    	}
    	
    	return cursor;
    }
    //另一个思路,p,q往上一直找到root, 然后相当于求两条链表或者两个数组的相同点
    //或者找到root之后,从root往下找

	private boolean helper(Node nd, Node q) {
		// TODO Auto-generated method stub
    	Queue<Node> qu = new LinkedList<>();
    	qu.add(nd);
    	while(!qu.isEmpty()) {
    		Node cur = qu.poll();
    		if(cur==null) {
    			break;
    		}
    		if(cur==q) {
    			return true;  			
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
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
