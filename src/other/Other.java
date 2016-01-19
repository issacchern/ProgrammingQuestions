package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import leetcode.LeetCode.TreeNode;

public class Other {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	/* Question 150.
	 * Given a binary tree, flatten it to a linked list.
	 * 
	 */
	
	 public void flatten(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode p = root;
	 
	        while(p != null || !stack.empty()){
	 
	            if(p.right != null){
	                stack.push(p.right);
	            }
	 
	            if(p.left != null){
	                p.right = p.left;
	                p.left = null;
	            }else if(!stack.empty()){
	                TreeNode temp = stack.pop();
	                p.right=temp;
	            }
	 
	            p = p.right;
	        }
	    }
	 //end
	 
	 /* Question 151.
	  * Given an array of strings, return all groups of strings that are anagrams.
	  * 
	  */
	 public List<String> anagrams(String[] strs) {
		    ArrayList<String> result = new ArrayList<String>();
		    if(strs == null || strs.length == 0)
		        return result;
		 
		    HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		    for(int i=0; i<strs.length; i++){
		        char[] arr = strs[i].toCharArray();
		        Arrays.sort(arr);
		        String t = String.valueOf(arr);
		        if(map.get(t) == null){
		            ArrayList<Integer> l = new ArrayList<Integer>();
		            l.add(i);
		            map.put(t, l);
		        }else{
		            map.get(t).add(i);
		        }
		    }
		 
		    for(ArrayList<Integer> l: map.values()){
		        if(l.size() > 1){
		            for(Integer i: l){
		                result.add(strs[i]);
		            }
		        }
		    }
		 
		    return result;
		}
	 //end
	 
	 
	 
	 
	 
}
