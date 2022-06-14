/*
 * 987. Vertical Order Traversal of a Binary Tree
Hard
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:


Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
 */
package LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class T987 {
	/*
	 * 1. 创建一个数据结构,放节点的行,列坐标,以及值
	 * 2. 遍历数,将每个节点坐标,值存入一个列表
	 * 3. 排序
	 * 4. 输出排序后的结果
	 */
	List<infoBlock> nodeList= new LinkedList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        //2.
        DFS(root,0,0);
        //3.
        Collections.sort(nodeList,new Comparator<infoBlock>(){
        	@Override
        	public int compare(infoBlock c1, infoBlock c2) {
        		if(c1.col==c2.col) {
        			//列相同
        			if(c1.row==c2.row) {
        				//行相同
        				return c1.val-c2.val;
        			}else {
        				return c1.row-c2.row;
        			}
        		}else {
        			return c1.col-c2.col;
        		}
        	}     	
        });
        //4
        List<Integer> columnList = new LinkedList<>();
        Integer colIndex = nodeList.get(0).col;
        List<List<Integer>> result = new LinkedList<>();
        
        for(infoBlock iB :nodeList ) {
        	Integer curCol = iB.col; 
        	Integer curVal = iB.val;
        	if(curCol==colIndex) {
        		columnList.add(curVal);
        	}else {
        		colIndex = curCol;
        		result.add(columnList);
        		columnList = new LinkedList<>();
        		columnList.add(curVal);
        	}
        }
        //last group
        result.add(columnList);
        return result;
    }
	private void DFS(TreeNode node, int col, int row) {
		if(node==null) {
			return;
		}
		nodeList.add(new infoBlock(col,row, node.val));
		DFS(node.left,col-1,row+1);
		DFS(node.right,col+1,row+1);
	}
    
}
//1
class infoBlock{
	public Integer col;
	public Integer row;
	public Integer val;
	public infoBlock(Integer c,Integer r ,Integer v) {
		this.col=c;
		this.row=r;
		this.val=v;	
	}
}