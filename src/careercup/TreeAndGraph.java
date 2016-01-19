package careercup;

import java.util.HashMap;

import leetcode.LeetCode.TreeNode;

public class TreeAndGraph {

	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	/* Question 74.
	 * Given a directed graph, design an algorithm to find out whether there is 
	 * a route between two nodes.
	 * TOO LONG, NO ANSWER!
	 */
	
	
	
	//end
	
	/* Question 75.
	 * Given a sorted array with unique integer elements, write an algorithm to create
	 * a binary search tree with minimal height.
	 * 
	 */
	
	public static TreeNode createMinimalBST(int array[]){
		return createMinimalBST(array, 0, array.length -1);
	}
	
	private static TreeNode createMinimalBST(int arr[], int start, int end){
		if(end < start) return null;
		int mid = (start+end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createMinimalBST(arr,start, mid-1);
		n.right = createMinimalBST(arr, mid+1, end);
		return n;
	}

	
	//end
	
	/* Question 76.
	 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
	 * at each depth (if you have tree with depth D, you will have D linked list).
	 * TOO LONG, NO ANSWER!
	 */
	
	
	
	//end
	
	/* Question 77.
	 * Given a binary tree, determine if it is height-balanced.  
	 */
	
	//topdown approach (runtime O(n^2), space O(n))
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return Math.abs(maxDepth2(root.left) - maxDepth2(root.right)) <= 1
				&& isBalanced(root.left)
				&& isBalanced(root.right);
	}
	
	public static int maxDepth2(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
	}
	
	
	//bottomup approach (runtime O(n), space O(n)
	
	public static boolean isBalanced3(TreeNode root) {
		return maxDepth3(root) != -1;
	}
	
	private static int maxDepth3(TreeNode root) {
		if (root == null) return 0;
		int L = maxDepth3(root.left);
		if (L == -1) return -1;
		int R = maxDepth3(root.right);
		if (R == -1) return -1;
		return (Math.abs(L - R) <= 1) ? (Math.max(L, R) + 1) : -1;
	}	

	//end
	
	/* Question 78.
	 * Given a binary tree, determine if it is valid BST.
	 *  runtime O(n), space O(n)
	 */
	
	public static boolean isValidBST(TreeNode root) {
		return valid(root, null, null);
	}
	
	private static boolean valid(TreeNode p, Integer low, Integer high) {
		if (p == null) return true;
		return (low == null || p.val > low) && (high == null || p.val < high)
				&& valid(p.left, low, p.val)
				&& valid(p.right, p.val, high);
	}
	
	//end
	
	/* Question 79.
	 * Successor
	 * NO ANSWER!
	 * 
	 */
	
	//end
	
	/* Question 80.
	 * Build Order
	 * NO ANSWER!
	 * 
	 */
	
	//end
	
	/* Question 81.
	 * First common ancestor
	 * NO ANSWER!
	 * 
	 */
	
	//end
	
	/* Question 82.
	 * BST sequence
	 * NO ANSWER!
	 * 
	 */
	
	//end
	
	/* Question 83.
	 * Check subtree
	 * NO ANSWER!
	 * 
	 */
	
	//end
	
	/* Question 84.
	 * Random Node
	 * NO ANSWER!
	 * 
	 */
	
	//end
	
	/* Question 85.
	 * Given a binary tree, design an algorithm to count the number of path that sum to
	 * a given value.
	 * Hint: Must go downwards from parent nodes to child nodes, not necessarily from nodes.
	 * runtime O(n), space O(n) hashtable
	 */
	
	public static int countPathWithSum(TreeNode root, int targetSum){
		
		if(root == null) return 0;
		HashMap<Integer,Integer> pathCount = new HashMap<Integer,Integer>();
		incrementHashTable(pathCount, 0, 1);
		return countPathWithSum(root, targetSum ,0,pathCount);

	}
	
	private static int countPathWithSum(TreeNode node, int targetSum,int runningSum,
			HashMap<Integer,Integer> pathCount){
		if(node == null) return 0;
		
		runningSum += node.val;
		incrementHashTable(pathCount, runningSum, 1); // add running sum
		
		//count path with sum ending at the current node
		int sum = runningSum - targetSum;
		int totalPath = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;
		
		//count path with sum on the left and right
		totalPath += countPathWithSum(node.left,targetSum,runningSum,pathCount);
		totalPath += countPathWithSum(node.right, targetSum, runningSum, pathCount);
		incrementHashTable(pathCount, runningSum, -1);

		return totalPath;
	}
	
	private static void incrementHashTable(HashMap<Integer,Integer> hashTable, int key, int delta){
		if(!hashTable.containsKey(key)){
			hashTable.put(key, 0);
		}
		hashTable.put(key, hashTable.get(key) + delta);
	}
	
	//end
}
