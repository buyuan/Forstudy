/*
 * 314. Binary Tree Vertical Order Traversal
Medium

Given the root of a binary tree, return the
 vertical order traversal of its nodes' 
 values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, 
the order should be from left to right.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Example 2:


Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
Example 3:


Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
Accepted
245,523
Submissions
483,996
 */
package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class T314 {
	public class TreeNode {
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
	
	public class Pair{
		TreeNode tn;
		Integer index;
		Pair(TreeNode node, Integer k){
			this.tn =node;
			this.index=k;
		}
	}
	
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //增加一个坐标属性,第一层那个是0,以后往左-1,往右+1
    	List<List<Integer>> result = new ArrayList<>();
    	if(root==null) {
    		return result;
    	}
    	
    	 HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
    	//Queue<Pair<TreeNode,Integer>> qu = new ArrayQueue();
    	Queue<Pair> qu = new ArrayDeque();
    	qu.add(new Pair(root,0));
    	while(!qu.isEmpty()){
    		Pair tp = qu.poll();
    		int index = tp.index;
    		ArrayList<Integer> arry = mp.getOrDefault(index, new ArrayList<Integer>());
    		arry.add(tp.tn.val);
    		mp.put(index,arry);
    		if(tp.tn.left!=null) {
    			qu.add(new Pair(tp.tn.left,tp.index-1));
    		}
    		if(tp.tn.right!=null) {
    			qu.add(new Pair(tp.tn.right,tp.index+1));
    		}
    	}
    	
    	Set keySet = mp.keySet();
    	Object[] keyArr = keySet.toArray();
    	Arrays.sort(keyArr);
    	for(Object key : keyArr) {
    		result.add(mp.get(key));
    	}
    	return result;
    }
    
    public List<List<Integer>> verticalOrder_2(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<>();
    	if(root==null) {
    		return res;
    	}
    	//for input the node in the same index
    	Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
    	//for track the boundary
    	int lowIndex=0;
    	int highIndex=0;
    	
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root,0));
        while(!qu.isEmpty()) {
        	Pair cur = qu.poll();
        	int idx = cur.index;       	
        	if(!mp.containsKey(idx)) {
        		mp.put(idx, new ArrayList<Integer>());
        	}
        	mp.get(idx).add(cur.tn.val);
        	lowIndex =Math.min(lowIndex, idx);
        	highIndex=Math.max(highIndex, idx);
        	if(cur.tn.left!=null) {
        		qu.add(new Pair(cur.tn.left,idx-1));
        	}
        	if(cur.tn.right!=null) {
        		qu.add(new Pair(cur.tn.right,idx+1));
        	}
        }
        for(int j=lowIndex;j<=highIndex;j++) {
        	res.add(mp.get(j));
        }
        return res;
    }
}
