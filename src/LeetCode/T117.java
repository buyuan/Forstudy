/*
 * 117. Populating Next Right Pointers in Each Node II
Medium

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 6000].
-100 <= Node.val <= 100
 */
package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

import LeetCode.T116.Node;

public class T117 {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	//和116的差别是,这个不是完美二叉树,注意初始化next是null,不用专门赋值null了
    public Node connect(Node root) {
        //用BFS类似的方法,一层一层搞
    	if(root==null) {
    		return null;
    	}
    	Queue<Node> qu = new LinkedList<>();
    	qu.add(root);
    	while(!qu.isEmpty()) {
    		int size = qu.size();
    		for(int i =0;i<size;i++) {
    			Node cur = qu.poll();
    			if(i<size-1) {
    				cur.next = qu.peek();
    			}
    			if(cur.left!=null) {
    				qu.add(cur.left);
    			}
    			if(cur.right!=null) {
    				qu.add(cur.right);
    			}   			
    		}
    	}
    	return root;
    }
    public Node connect_recur(Node root) {
    	//用递归,先找到父节点右边的节点
    	if(root==null) {
    		return null;
    	}
    	Node nxt = root.next;
    	while(nxt!=null) {
    		if(nxt.left!=null) {
    			nxt = nxt.left;
    			break;
    		}
    		if(nxt.right!=null) {
    			//说明左边是null
    			nxt=nxt.right;
    			break;
    		}
    		nxt = nxt.next;//如果没找到,继续往父节点的下一个找
    	}
    	if(root.right!=null) {
    		root.right.next=nxt;
    	}
    	if(root.left!=null) {
    		root.left.next = (root.right!=null)?root.right:nxt;
    	}
    	//要先右后左,
    	connect_recur(root.right);
    	connect_recur(root.left);
    	
    	return root;
    }
}
