/*
 * practice 1, different way to traverse binary tree
 */
package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P1 {
	/*
	 * Iteratively
	 */
	//preorder
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<>();
        //根,左,右,的顺序,所以入栈右比左先,保证左比右先出
    	if(root==null) {
    		return result;
    	}
    	Stack<TreeNode> trav = new Stack<>();
    	trav.add(root);
    	while(!trav.isEmpty()) {
    		TreeNode cur = trav.pop();
    		result.add(cur.val);
    		if(cur.right!=null) {
    			trav.add(cur.left);
    		}
    		if(cur.left!=null) {
    			trav.add(cur.right);    			
    		}		
    	}
    	return result;
    }
    
    //Inorder
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new LinkedList<>();
        //左,根,右,的顺序,相当于左边永远找到最后一个左节点,然后往回,有右节点,开始
    	//用相同的方法,找右节点下面的最左边
    	if(root==null) {
    		return result;
    	}        
    	Stack<TreeNode> trav = new Stack<>();
    	TreeNode cur = root;
    	while(cur!=null||!trav.isEmpty()) {
    		while(cur!=null) {
    			//找最左最底下节点
    			trav.add(cur);
    			cur = cur.left;
    		}
    		cur = trav.pop();
    		result.add(cur.val);
    		cur=cur.right;		
    	}
    	return result;
    }
    //postorder
    public List<Integer> postorderTraversal(TreeNode root) {
        //后序, 左,右,根, 前序,根,左右, 所以,可以先用前序,做成根,右,左,然后反转
    	List<Integer> result = new LinkedList<>();
    	List<Integer> temp = new LinkedList<>();
        //左,根,右,的顺序,相当于左边永远找到最后一个左节点,然后往回,有右节点,开始
    	//用相同的方法,找右节点下面的最左边
    	if(root==null) {
    		return result;
    	}        
    	Stack<TreeNode> trav = new Stack<>();
    	trav.add(root);
    	while(!trav.isEmpty()) {
    		TreeNode cur = trav.pop();
    		temp.add(cur.val);
    		if(cur.left!=null) {
    			trav.add(cur.left);
    		}
    		if(cur.right!=null) {
    			trav.add(cur.right);
    		}  		
    	}
    	for(int i=temp.size()-1;i>=0;i--) {
    		result.add(temp.get(i));
    	}
    	return result;
    }
	/*
	 * BFS, level
	 */
    //这个是一层一层输出
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<>();
    	if(root==null) {
    		return result;
    	}
    	Queue<TreeNode> qu = new LinkedList<>();
    	qu.add(root);
    	
    	while(!qu.isEmpty()) {
    		int size = qu.size();
    		List<Integer> temp = new LinkedList<>();
    		for(int i=0;i<size;i++) {
        		TreeNode cur = qu.poll();
        		temp.add(cur.val);
        		if(cur.left!=null) {
            		qu.add(cur.left);
        		}
        		if(cur.right!=null) {
            		qu.add(cur.right);
        		}  
    		}	
    		result.add(temp);
    	}
    	
    	return result;
    }
    
    /*tipical problem
     * 
     */
    //Symetric Tree
    /*
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).		
		Example 1:
		
		
		Input: root = [1,2,2,3,4,4,3]
		Output: true
		Example 2:
		
		
		Input: root = [1,2,2,null,3,null,3]
		Output: false
		 
		
		Constraints:
		
		The number of nodes in the tree is in the range [1, 1000].
		-100 <= Node.val <= 100
     */
    public boolean isSymmetric(TreeNode root) {
    	return isMirror(root,root);
        
    }

	private boolean isMirror(TreeNode node1, TreeNode node2) {
		// TODO Auto-generated method stub
		if(node1==null&&node2==null) {
			return true;
		}
		if(node1==null||node2==null) {
			return false;
		}
		
		return (node1.val==node2.val)
				&&isMirror(node1.left,node2.right)
				&&isMirror(node1.right,node2.left);
	}
}



/*
 * 
 * public class TreeNode {
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
 */
