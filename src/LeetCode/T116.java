/*
 * 116. Populating Next Right Pointers in Each Node
Medium
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000
 */
package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class T116 {
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
    public Node connect(Node root) {
        //recursive
    	if(root==null) {
    		return null;
    	}
    	if(root.left!=null) {
    		root.left.next = root.right;
    	}
    	if(root.right!=null) {
    		root.right.next = (root.next ==null)?null:(root.next.left);
    	}
    	connect(root.left);
    	connect(root.right);
    	return root;
    }
    public Node connect_iter(Node root) {
    	//iterate
    	if(root==null) {
    		return null;
    	}
    	Queue<Node> qu = new LinkedList<>();
    	qu.add(root);
    	qu.add(null);
    	while(!qu.isEmpty()) {
    		int size = qu.size();
    		for(int i=0;i<size-1;i++) {
    			//the size-1 is null
        		Node cur = qu.poll();
        		cur.next=qu.peek();
        		if(cur.left!=null) {
        			qu.add(cur.left);
        		}
        		if(cur.right!=null) {
        			//其实不用,因为是perfect binary tree
        			qu.add(cur.right);
        		}   		
    		}
    		qu.poll();//poll the null node
            if(qu.size()>0){
            	//in case the null is the only node
                qu.add(null);
            }   
    	}
    	return root;
    }
}


