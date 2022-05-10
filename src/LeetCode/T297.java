/*
 * 297. Serialize and Deserialize Binary Tree
Hard
Serialization is the process of converting a data structure or object into a 
sequence of bits so that it can be stored in a file or memory buffer, or transmitted 
across a network connection link to be reconstructed later in the same or another computer
 environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on
 how your serialization/deserialization algorithm should work. You just need to ensure that 
 a binary tree can be serialized to a string and this string can be deserialized to the original
  tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different
 approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
Accepted
574,141
Submissions
1,078,070
 */

package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode.T297.Codec.TreeNode;

public class T297 {

/*
	public class Codec {
		public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
		}
	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	return helpSeri(root,"");
	    	
	    }
	    	

	    // Decodes your encoded data to tree.
	    public String helpSeri(TreeNode nd, String str) {
	        //preorder
	    	
	    	if(nd==null) {
	    		str += "null/";
	    	}else {
	    		str+=nd.val+"/";
	    		str=helpSeri(nd.left,str);
	    		str=helpSeri(nd.right,str);
	    	}
	    	return str;
	    	
	    }
	    public TreeNode deserialize(String data) {
	        String[] arr = data.split("/");
	        List<String> data_list = new LinkedList<String>(Arrays.asList(arr));
	        return helpDeser(data_list);
	    }


		private TreeNode helpDeser(List<String> data_list) {
			// always get tht first
			if(data_list.get(0).equals("null")) {
				data_list.remove(0);
				return null;
			}
			TreeNode tn = new TreeNode(Integer.valueOf(data_list.get(0)));
			data_list.remove(0);
			tn.left = helpDeser(data_list);
			tn.right = helpDeser(data_list);
			return tn;
		}
	    
	}
	public static void main(String[] args) {
		
	}
*/
	
	public class Codec {
		public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
		}
		//用DFS, 
	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        //正常的DFS遍历,存入String
	    	//return helperS_DFS(root,"");
	    	//用BFS遍历,存为String,注意标记层
	    	return helperS_BFS(root);
	    }
		private String helperS_BFS(TreeNode nd) {
			String ser ="";
			Queue<TreeNode> qu = new LinkedList<>();
			qu.add(nd);
			int size =0;

			while(!qu.isEmpty()) {
				size = qu.size();
				for(int i=0;i<size;i++) {
					TreeNode cur = qu.poll();
					if(cur==null) {
						ser+="null/";
						continue;
					}else {
						ser+=cur.val+"/";
					}
					qu.add(cur.left);
					qu.add(cur.right);
				}
				ser+="#";//this level finished
				//需要增加一个判断,当qu的内容全是null时,就不用再跑了
				boolean flag = false;
				for(int l=0;l<qu.size();l++) {
					TreeNode tp = qu.poll();
					if(tp!=null) {
						flag=true;
					}
					qu.add(tp);
				}
				if(!flag) {
					break;
				}
			}
			return ser;
		}
		public String helperS_DFS(TreeNode nd, String str) {
			if(nd==null) {
				str+="null/";
			}else {
				str+=nd.val+"/";
				str=helperS_DFS(nd.left,str);
				str=helperS_DFS(nd.right,str);
			}
			return str;
		}
		
	    // Decodes your encoded data to tree.
	    public TreeNode deserialize_DFS(String data) {
	        String[] arr = data.split("/");
	        List<String> arr_lit = new LinkedList<>(Arrays.asList(arr));
	        return helperD_DFS(arr_lit);
	    }
	    //Decode  BFS
	    public TreeNode deserialize_BFS(String data) {
	    	String[] arr = data.split("#");
	    	List<String> arr_lit = new LinkedList<>(Arrays.asList(arr));
	        return helperD_BFS(arr_lit);
	    }
		private TreeNode helperD_BFS(List<String> arr_lit) {
			String temp = arr_lit.get(0);
			String tp = temp.substring(0, temp.length()-1);
			TreeNode root=new TreeNode(Integer.valueOf(tp));
            if(tp.equals("null")){
                return null;
            }
			arr_lit.remove(0);
			LinkedList<TreeNode> old =  new LinkedList<>();
			old.add(root);	
			for(int i=0;i<arr_lit.size();i++) {
				LinkedList<TreeNode> cur =  new LinkedList<>();
				String[] arr = arr_lit.get(i).split("/");
				//this is the node of each level
				List<String> a_lit = new LinkedList<>(Arrays.asList(arr));
				for(int j=0;j<a_lit.size();j++) {
					if(a_lit.get(j).equals("null")) {
						cur.add(null);
					}else {
						cur.add(new TreeNode(Integer.valueOf(a_lit.get(j))));
					}
				}
				int index=0;
				for(int k=0;k<old.size();k++) {
                    TreeNode t = old.get(k);
                    if(t==null){
                        continue;
                    }
					t.left=cur.get(index++);
					t.right=cur.get(index++);
				}
				old = cur;
			}
			return root;
		}
		private TreeNode helperD_DFS(List<String> arr_lit) {
			// TODO Auto-generated method stub
			String cur = arr_lit.get(0);
			arr_lit.remove(0);
			if(cur.equals("null") ) {
				return null;
			}			
			TreeNode tn = new TreeNode(Integer.valueOf(cur));
			tn.left = helperD_DFS(arr_lit);
			tn.right = helperD_DFS(arr_lit);
			return tn;
		}
	}


}


//Your Codec object will be instantiated and called as such:
//Codec ser = new Codec();
//Codec deser = new Codec();
//TreeNode ans = deser.deserialize(ser.serialize(root));