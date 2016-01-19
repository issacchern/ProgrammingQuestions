package leetcode;

import java.io.*;
import java.util.*;

public class LeetCode {
	
	public static class Node{
		
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static class RandomListNode{
		RandomListNode next;
		int label;
		RandomListNode random;
		
		public RandomListNode(int label){
			this.label = label;
		}	
	}
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	
	
	/*	Question 1.
	 * 	Given an array of integers, find two numbers such that they add up to
	 * 	a specific number, return arrays of those indices 
	 * 	O(n) runtime, O(n) space
	 */
	
	public static int[] twoSum(int [] numbers, int target){
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < numbers.length; i++){
			int x = numbers[i];
			if(map.containsKey(target - x)){
				// just like new int[]{3,4,5,6}
				int [] match = new int[]{map.get(target - x) + 1, i+1};
				return match;
			}
			map.put(x,i);
		}
		throw new IllegalArgumentException("No two sum solutions");
	} 
	
	//end
	
	/*	Question 2.
	 * 	Given a sorted array of integers, find two numbers such that they add up to
	 * 	a specific number, return arrays of those indices 
	 *  O(nlogn) runtime, O(1) space
	 */
	
	public static int[] twoSumSorted(int [] numbers, int target){
		
		for(int i = 0 ; i < numbers.length; i++){
			int j = bsearch(numbers, target - numbers[i], i );
			if( j != -1){
				int[] result = new int[]{i+1,j+1};
				return result;
			}
			
		}
		throw new IllegalArgumentException("No two sum solutions");
	} 
	
	public static int bsearch(int[] A, int key, int start){
		int L = start; 
		int R = A.length - 1;
		while(L < R){
			int M = (L+R)/2;
			if(A[M] < key) L = M + 1;
			else R = M;
		}
		if(L == R && A[L] == key) return L;
		else return -1;
	}
	
	/*	Question 2. (Pointers)
	 *  O(n) runtime, O(1) space
	 */
	
	public static int[] twoSumSortedII(int [] numbers, int target){
		int i = 0; 
		int j = numbers.length - 1;
		while(i < j){
			int sum = numbers[i] + numbers[j];
			if(sum < target){
				i++;
			} else if(sum > target){
				j--;
			} else{
				return new int[]{i + 1, j+1};
			}
		}
		throw new IllegalArgumentException("No two sum solution!");
	}
	
	//end
	
	/*	Question 4.
	 * 	Given a string, determine if it is a palindrome (only alphanumeric characters)
	 *  Hint: use two pointers
	 *  O(n) runtime, O(1) space
	 */
	
	public static boolean isPalindrome(String s){
		int i = 0;
		int j = s.length() - 1;
		while(i < j){
			while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j++;
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
			i++; j--;	
		}
		
		return true;
	}
	
	//end
	
	/*	Question 5.
	 * 	Implement strstr(), return index of first occurence of substring, or -1 if it isn't found.
	 *  Hint: string function
	 *  O(nm) runtime, O(1) space
	 */
	
	public static int strstr(String s, String subs){
		//return s.indexOf(subs);
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == subs.length()) return i;
				if (i + j == s.length()) return -1;
				if (subs.charAt(j) != s.charAt(i + j)) break;
			}
		}
	}
	
	//end
	
	/*	Question 6.
	 * 	Given a string, reverse the string by words.
	 *  O(n) runtime, O(n) space
	 */
	public static String reverseWords(String s){
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == ' '){
				j = i;
			} else if(i == 0 || s.charAt(i-1) == ' '){
				if(reversed.length() != 0){
					reversed.append(' ');
				}
				reversed.append(s.substring(i,j));
			}
		}
		return reversed.toString();
		
	}
	
	//end
	
	/*	Question 7.
	 * 	Given a string without leading or trailing spaces, reverse the string by words.
	 *  O(n) runtime, O(1) space
	 */
	
	public static char[] reverseWords(char[] s){
		reverse(s,0,s.length);
		int i = 0;
		for(int j = 0; j <=s.length; j++){
			if(j == s.length || s[j] == ' '){
				reverse(s,i,j);
				i = j+1;
			}
		}
		
		return s;
		
		
	}
	
	private static void reverse(char[] s, int begin, int end){
		for(int i = 0; i < (end-begin)/2; i++){
			char temp = s[begin+i];
			s[begin+i] = s[end-i-1];
			s[end-i-1] = temp;
		}
		
	}
	//end
	
	/*	Question 8.
	 * 	String to Integer (atoi) - discard leading whitespaces until first character appears.
	 *  Discard every character after the space.
	 */
	
	public static int atoi(String str){
		int i = 0, n = str.length();
		while(i < n && Character.isWhitespace(str.charAt(i))) i++;
		int sign = 1;
		if(i < n && str.charAt(i) == '+') i++;
		else if (i < n && str.charAt(i) == '-'){
			sign = -1;
			i++;
		}
		int num = 0;
		while(i < n && Character.isDigit(str.charAt(i))){
			int digit = Character.getNumericValue(str.charAt(i));
			if(num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE  /10 && digit >=8){
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	
	}
	
	//end
	
	/*	Question 9.
	 * 	Validate if a given string is numeric.
	 */
	
	public static boolean isNumber(String s){
		
		int i = 0, n = s.length();
		while(i < n && Character.isWhitespace(s.charAt(i))) i++;
		if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		boolean isNumeric = false;
		while(i < n && Character.isDigit(s.charAt(i))){
			i++;
			isNumeric = true;
		}
		if(i < n && s.charAt(i) == '.'){
			i++;
			while(i < n && Character.isDigit(s.charAt(i))){
				i++;
				isNumeric = true;
			}
		}
		while(i < n && Character.isWhitespace(s.charAt(i))) i++;
		return isNumeric && (i == n);
		
	}
	
	//end
	
	
	/*	Question 10.
	 * 	Given a string, find the length of longest substring without repeating characters.
	 *  abcabcbb -> abc (3), bbbb -> b (1)
	 *  O(n) runtime, O(1) space
	 */
	
	public static int lengthOfLongestSubstring(String s){
		boolean [] exist = new boolean[256];
		int i = 0, maxLength = 0;
		for(int j = 0; j < s.length(); j++){
			while(exist[s.charAt(j)]){
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLength = Math.max(j-i+1, maxLength); // good one!
		}
		
		return maxLength;
	}
	
	//end
	
	/*	Question 11.
	 * 	Given a string, find the length of longest substring that contains at most two distinct characters.
	 *  eceba -> ece
	 *  O(n) runtime, O(1) space
	 */
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int i = 0, j = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1)) continue;
			if (j >= 0 && s.charAt(j) != s.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
			}
			j = k - 1;
		}
		return Math.max(s.length() - i, maxLen);
	}
	
	//end
	
	/*	Question 12.
	 * 	Given a sorted integer array where the range of elements are [0,99] inclusive, return its
	 *  missing range. 
	 */
	
	public static List<String> findMissingRanges(int [] vals, int start, int end){
		List<String> ranges = new ArrayList<>();
		int prev = start - 1;
		for(int i = 0; i <= vals.length; i++){
			int curr = (i == vals.length) ? end + 1 : vals[i];
			if(curr - prev >= 2){
				ranges.add(getRange(prev+1,curr-1));
			}
			prev = curr;			
		}
		return ranges;
	}
	
	private static String getRange(int from, int to){
		return (from == to) ? String.valueOf(from) : from + "->" + to;
	}
	
	//end
	
	/*	Question 13.
	 * 	Find the longest palindrome substring in S and there is only one unique longest palindromic
	 *  substring.
	 *  O(n^2) runtime, O(1) space
	 */
	
	public static String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	
	//end
	
	/*	Question 14.
	 * 	Given two strings S and T , determine if they are both one edit distance apart.
	 *  O(n) runtime, O(1) space
	 */
	
	public static boolean isOneEditDistance(String s , String t){
		
		int m = s.length(), n = t.length();
		if(m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		if( n - m > 1) return false;
		int i = 0, shift = n-m;
		while(i < m && s.charAt(i) == t.charAt(i)) i++;
		if(i == m) return shift > 0;
		if(shift == 0) i++;
		while(i < m && s.charAt(i) == t.charAt(i + shift)) i++;	
		return i == m;
	}
	
	//end
	
	/*	Question 15.
	 * 	Read N characters by calling read4 function
	 */	
	
	//end
	
	/*	Question 16.
	 * 	Read N characters by calling read4 function multiple times 
	 */	
	
	//end
	
	/*	Question 17.
	 * 	Reverse digits of an integer.
	 *  123 -> 321
	 */	
	
	public static int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			// handle overflow/underflow
			if (Math.abs(ret) > 214748364) {
				return 0;
			}
			ret = ret * 10 + x % 10;
			x /= 10;
		}
		return ret;
	}
	//end
	
	/*	Question 18.
	 * 	Given a number represented as an array of digits, plus one to that number.
	 */	
	
	public static List plusOne(List<Integer> digits) {
		for (int i = digits.size() - 1; i >= 0; i--) {
			int digit = digits.get(i);
			if (digit < 9) {
				digits.set(i, digit + 1);
				return digits;
			} else {
				digits.set(i, 0);
			}
		}
		digits.add(0);
		digits.set(0, 1);
		
		return digits;
	}
	
	//end
	
	/*	Question 19.
	 * 	Determine if an integer is palindrome without allocating extra space.
	 */		
	
	public static boolean isPalindrome(int x){
		if(x < 0) return false;
		int div = 1;
		while(x / div >= 10){
			div *=10;
		}
		while(x != 0){
			int l = x /div;
			int r = x % 10;
			if(l != r) return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
	
	//end
	
	/*	Question 20.
	 * 	Merge two sorted linked list and retrn it as a new list.
	 */	
	
	public static Node mergeTwoLists(Node l1, Node l2){
		
		Node head = new Node(0);
		Node p = head;
		while(l1 != null && l2 != null){
			if(l1.data < l2.data){
				p.next = l1;
				l1 = l1.next;
			} else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if(l1 != null) p.next = l1;
		if(l2 != null) p.next = l2;
		
		return head.next;
	}
	
	//end
	
	/*	Question 21.
	 * 	Add two linked list number and store in reverse order, which each node contains a single digit.
	 *  (2->4->3) + (5->6->4) = (7->0->8)
	 */		
	
	public static Node addTwoNumbers(Node l1, Node l2){
		
		Node head = new Node(0);
		Node p = l1;
		Node q = l2;
		Node curr = head;
		int carry = 0;
		while(p != null || q != null){
			int x = (p != null) ? p.data : 0;
			int y = (q != null) ? q.data : 0;
			int digit = carry + x + y;
			carry = digit / 10; //carry number
			curr.next = new Node(digit % 10); //remaining number
			curr = curr.next;
			if(p != null) p = p.next;
			if(q != null) q = q.next;	
		}
		if(carry > 0){
			curr.next = new Node(carry);
		}
		
		return head.next;
	}
	
	//end
	
	/*	Question 22.
	 * 	Given a linked list, swap two adjacent nodes and return its head.
	 *  1->2->3->4 => 2->1->4->3
	 */	
	
	public static Node swapPairs(Node head) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node p = head;
		Node prev = dummy;
		while (p != null && p.next != null) {
			Node q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
	
	//end
	
	/*	Question 23.
	 * 	Merge k sorted list and return as one sorted list.
	 *  runtime O(nklogk), space O(1)
	 */	
	
	public static Node mergeKLists(List<Node> lists) {
		if (lists.isEmpty()) return null;
		int end = lists.size() - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists.set(begin, merge2Lists(lists.get(begin),
						lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}
	
	private static Node merge2Lists(Node l1, Node l2) {
		Node dummyHead = new Node(0);
		Node p = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) p.next = l1;
		if (l2 != null) p.next = l2;
		return dummyHead.next;
	}	
	
	//end
	
	/*	Question 24.
	 * 	A linked list is given such that each node contains an additional random pointer that 
	 *  could point to any node in the list or null.
	 *  Return a deep copy of the list.
	 *  runtime O(n), space O(n)
	 */	
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode p = head;
		while (p != null) {
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next = copy;
			copy.next = next;
			p = next;
		}
		p = head;
		while (p != null) {
			p.next.random = (p.random != null) ? p.random.next : null;
			p = p.next.next;
		}
		p = head;
		RandomListNode headCopy = (p != null) ? p.next : null;
		while (p != null) {
			RandomListNode copy = p.next;
			p.next = copy.next;
			p = p.next;
			copy.next = (p != null) ? p.next : null;
		}
		return headCopy;
	}
	
	//end
	
	/*	Question 25.
	 * 	Given a binary tree, determine if it is valid BST.
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
	
	/*	Question 26.
	 * 	Given a binary tree, find its maximum path
	 *  runtime O(n), space O(logn)
	 */
	
	public static int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	//end
	
	/*	Question 27.
	 * 	Given a binary tree, find its minimum path
	 *  runtime O(n), space O(logn)
	 */

	public static int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null) return minDepth(root.right) + 1;
		if (root.right == null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
	
	//end
	
	/*	Question 28.
	 * 	Given a binary tree, determine if it is height-balanced.  
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
	
	/*	Question 29.
	 * 	Convert sorted array to balanced BST
	 *  O(n) runtime, O(logn)
	 */
	
	public static TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length-1);
	}
	
	private static  TreeNode sortedArrayToBST(int[] arr, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = sortedArrayToBST(arr, start, mid-1);
		node.right = sortedArrayToBST(arr, mid+1, end);
		return node;
	}
	
	//end
	
	/*	Question 30.
	 * 	Convert sorted list to balanced BST
	 *  O(n) runtime, O(logn) - bottom up recursion
	 */	
	
	private static Node list;
	private static TreeNode sortedListToBST(int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode leftChild = sortedListToBST(start, mid-1);
		TreeNode parent = new TreeNode(list.data);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(mid+1, end);
		return parent;
	}
	
	public static TreeNode sortedListToBST(Node head) {
		int n = 0;
		Node p = head;
		while (p != null) {
			p = p.next;
			n++;
		}
		list = head;
		return sortedListToBST(0, n - 1);
	}
	
	//end
	
	/*	Question 31.
	 * 	Given a binary tree, find the maximum path sum.
	 */	
	
	private static int maxSum;
	public static int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		findMax(root);
		return maxSum;
	}
	
	private static int findMax(TreeNode p) {
		if (p == null) return 0;
		int left = findMax(p.left);
		int right = findMax(p.right);
		maxSum = Math.max(p.val + left + right, maxSum);
		int ret = p.val + Math.max(left, right);
		return ret > 0 ? ret : 0;
	}
	
	//end
	
	/*	Question 32.
	 * 	Given a binary tree where all right nodes are either leaft nodes with a left node,
	 *  flip it upside down and turn it into a tree where the original right nodes turned 
	 *  into left leaf nodes. Return new root.
	 *  Hint: at each node, assign:
	 *  	p.left = parent.right;
	 *  	p.right = parent;
	 */	
	
	//topdown approach
	
	public static TreeNode UpsideDownBinaryTree(TreeNode root) {
		TreeNode p = root, parent = null, parentRight = null;
		while (p != null) {
			TreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}
	
	//bottomup approach
	
	public static TreeNode UpsideDownBinaryTree2(TreeNode root) {
		return dfsBottomUp(root, null);
		}
	
	private static TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
		if (p == null) return parent;
		TreeNode root = dfsBottomUp(p.left, p);
		p.left = (parent == null) ? parent : parent.right;
		p.right = parent;
		return root;
	}
	
	//end
	
	/* Question 33.
	 * Given an array of integers, every element appears twice except one. Find that single one.
	 * 
	 */
	
	//hashmap approach O(n) time, O(n) space
	public static int singleNumber(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int x : A) {
			int count = map.containsKey(x) ? map.get(x) : 0;
			map.put(x, count + 1);
		}
		for (int x : A) {
			if (map.get(x) == 1) {
				return x;
			}
		}
		throw new IllegalArgumentException("No single element");
	}
	
	// or set approach O(n) time, O(n) space
	public static int singleNumber2(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int x : A) {
			if (set.contains(x)) {
				set.remove(x);
			} else {
				set.add(x);
			}
		}
		return set.iterator().next();
	}
	
	// or XOR approach
	public static int singleNumber3(int[] A) {
		int num = 0;
		for (int x : A) {
			num ^= x;
		}
		return num;
	}
	
	//end
	
	/* Question 34.
	 * Given an array of integers, every element appears three times except one. Find that single one.
	 * 
	 */
	public static int singleNumber(int A[], int n) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < n; i++) {
			twos |= ones & A[i];
			ones ^= A[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}
	
	//end
	
	/* Question 35.
	 * Given a matrix of m*n (m rows, n columns), return all elements in spiral order
	 * Hint: 
	 * [1,2,3],
	 * [4,5,6],
	 * [7,8,9] returns
	 * [1,2,3,4,5,6,7,8,9]
	 */
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> elements = new ArrayList<>();
		if (matrix.length == 0) return elements;
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = -1;
		while (true) {
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][++col]);
			}
			if (--m == 0) break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[++row][col]);
			}
			if (--n == 0) break;
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][--col]);
			}
			if (--m == 0) break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[--row][col]);
			}
			if (--n == 0) break;
		}
		return elements;
	}
	
	//end
	
	/* Question 36.
	 * Given an integer, convert it to roman numeral.
	 */
	
	private static final int[] values = {
		1000, 900, 500, 400,
		100, 90, 50, 40,
		10, 9, 5, 4,
		1
	};
	
	private static final String[] symbols = {
		"M", "CM", "D", "CD",
		"C", "XC", "L", "XL",
		"X", "IX", "V", "IV",
		"I"
	};
	
	public static String intToRoman(int num) {
		StringBuilder roman = new StringBuilder();
		int i = 0;
		while (num > 0) {
			int k = num / values[i];
			for (int j = 0; j < k; j++) {
				roman.append(symbols[i]);
				num -= values[i];
			}
			i++;
		}
		return roman.toString();
	}
	
	/* Question 37.
	 * Given a roman numeral, convert it to an integer.
	 * 
	 */
	
	private static Map<Character, Integer> map =
			new HashMap<Character, Integer>() {{
				put('I', 1); put('V', 5); put('X', 10);
				put('L', 50); put('C', 100); put('D', 500);
				put('M', 1000);
			}};
			
	public static int romanToInt(String s) {
		int prev = 0, total = 0;
		for (char c : s.toCharArray()) {
			int curr = map.get(c);
			total += (curr > prev) ? (curr - 2 * prev) : curr;
			prev = curr;
		}
		return total;	
	}
	
	//end
	
	/* Question 39.
	 * Design a stack that supports push, pop, top, and retrieving minimu element in constant time
	 * - push(x)
	 * - pop()
	 * - top()
	 * - getMin()
	 * O(n) runtime, O(n) space 
	 */
	
	public static class MinStack {
		private static Stack<Integer> stack = new Stack<>();
		private static Stack<Integer> minStack = new Stack<>();
		public static void push(int x) {
			stack.push(x);
			if (minStack.isEmpty() || x <= minStack.peek()) {
				minStack.push(x);
			}
		}
		
		public static void pop() {
			if (stack.pop().equals(minStack.peek())) minStack.pop();
		}
		
		public static int top() {
			return stack.peek();
		}
		
		public static int getMin() {
			return minStack.peek();
		}
	}
	
	//end
	
	/* Question 40.
	 * Evaluate the value of an arithmetic expression in postfix notation.
	 * 
	 */
	
	private static final Set<String> OPERATORS =
			new HashSet<>(Arrays.asList("+", "-", "*", "/"));

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(eval(x, y, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
	
	private static int eval(int x, int y, String operator) {
		switch (operator) {
			case "+": return x + y;
			case "-": return x - y;
			case "*": return x * y;
			default: return x / y;
		}
	}
	
	//end
	
	/* Question 41.
	 * Given a string containing just the characters of parentheses, determine if the string
	 * is valid. 
	 * 
	 */
	private static final Map<Character, Character> map2 =
			new HashMap<Character, Character>() {{
				put('(', ')');
				put('{', '}');
				put('[', ']');
			}};
			
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map2.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map2.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	//end
	
	/* Question 42.
	 * You are climbing staircase, it takes n steps to reach top.  Each time you can climb 1 or 2 steps,
	 * how many distinct way can you climb to the top?
	 * O(n) runtime, O(1) space
	 */
	
	public static int climbStairs(int n) {
		int p = 1, q = 1;
		for (int i = 2; i <= n; i++) {
			int temp = q;
			q += p;
			p = temp;
		}
		return q;
	}
	
	//end
	
	/* Question 43.
	 * Unique path without obstacles
	 * O(mn) runtime, O(mn) space 
	 */
	
	public static int uniquePaths(int m, int n) {
		int[][] mat = new int[m + 1][n + 1];
		mat[m - 1][n] = 1;
		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				mat[r][c] = mat[r + 1][c] + mat[r][c + 1];
			}
		}
		return mat[0][0];
	}
	
	/* Question 44.
	 * Unique path with obstacles. (Dynamic Programming)
	 * O(mn) runtime, O(mn) space 
	 */
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0) return 0;
		int n = obstacleGrid[0].length;
		int[][] mat = new int[m + 1][n + 1];
		mat[m - 1][n] = 1;
		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				mat[r][c] = (obstacleGrid[r][c] == 1) ? 0 : mat[r][c+1] + mat[r+1][c];
			}
		}
		return mat[0][0];
	}
	
	//end
	
	/* Question 45.
	 * Find the contiguous subarray with an array that has largest sum
	 * 
	 * O(nlogn) runtime, O(logn) space 
	 */
	
	public static int maxSubArray(int[] A) {
		return maxSubArrayHelper(A, 0, A.length - 1);
	}
	
	private static int maxSubArrayHelper(int[] A, int L, int R) {
		if (L > R) return Integer.MIN_VALUE;
		int M = (L + R) / 2;
		int leftAns = maxSubArrayHelper(A, L, M - 1);
		int rightAns = maxSubArrayHelper(A, M + 1, R);
		int lMaxSum = 0;
		int sum = 0;
		for (int i = M - 1; i >= L; i--) {
			sum += A[i];
			lMaxSum = Math.max(sum, lMaxSum);
		}
		int rMaxSum = 0;
		sum = 0;
		for (int i = M + 1; i <= R; i++) {
			sum += A[i];
			rMaxSum = Math.max(sum, rMaxSum);
		}
		return Math.max(lMaxSum + A[M] + rMaxSum, Math.max(leftAns, rightAns));
	}
	
	//end
	
	/*  Question 46.
	 *  Find the contiguous subarray with an array that has largest product
	 * 
	 */
	
	public static int maxProduct(int[] A) {
		assert A.length > 0;
		int max = A[0], min = A[0], maxAns = A[0];
		for (int i = 1; i < A.length; i++) {
			int mx = max, mn = min;
			max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
			min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
			maxAns = Math.max(max, maxAns);
		}
		return maxAns;
	}
	//end
	
	
	/* Question 48.
	 * Given a sorted array and a target value, return the index if the target is found. If not,
	 * return the index where it would be if it were inserted in order.
	 * [1,3,5,6],5 -> 2
	 * [1,3,5,6],2 -> 1
	 * [1,3,5,6],7 -> 4
	 * [1,3,5,6],0 -> 0
	 * 
	 */

	public static int searchInsert(int[] A, int target) {
		int L = 0, R = A.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (A[M] < target) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (A[L] < target) ? L + 1 : L;
	}
	
	//end
	
	
	/* Question 49.
	 * Find the minimum element in a sorted rotated array.
	 * O(logn) runtime
	 */
	
	public static int findMin(int[] A) {
		int L = 0, R = A.length - 1;
		while (L < R && A[L] >= A[R]) {
			int M = (L + R) / 2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return A[L];
	}
	
	//end
	
	/* Question 50.
	 * Find the minimum element in a sorted rotated array that contains duplicates.
	 * runtime O(n)
	 */
	
	public static int findMin2(int[] A) {
		int L = 0, R = A.length - 1;
		while (L < R && A[L] >= A[R]) {
			int M = (L + R) / 2;
			if (A[M] > A[R]) {
				L = M + 1;
			} else if (A[M] < A[L]) {
				R = M;
			} else { // A[L] == A[M] == A[R]
				L = L + 1;
			}
		}
		return A[L];
	}
	
	//end

}
