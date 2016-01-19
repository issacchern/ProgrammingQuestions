package careercup;

import java.util.*;

public class ArrayAndString {
	
	/* Question 51.
	 * Determine if a string has all unique characters
	 */
	
	public static boolean isUniqueChars(String str){
		
		if(str.length() > 128) return false;
		boolean [] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]) return false; //appear twice
			char_set[val] = true;
		}
		return true;
	}
	//end
	
	/* Question 52. 
	 * Given two strings, determine if one is a permutation of the other.
	 * Hint: sort the two strings and compare.
	 */
	
	public static boolean permutation(String s, String t){
		if(s.length() != t.length()) return false;
		return char_sort(s).equals(char_sort(t));
	}
	
	private static String char_sort(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	//end
	
	/* Question 53.
	 * Write a method to replace all spaces in a string with %20
	 * 
	 */
	
	public static String replaceSpaces(char[] str, int length){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length ; i++){
			if(str[i] != ' '){
				sb.append(str[i]);
			} else{
				if(str[i-1] != ' ') sb.append("%20"); 
			}
		}
		return sb.toString();
		
//		int spaceCount = 0;
//		for(int i = 0; i< length; i++){
//			if(str[i] == ' '){
//				spaceCount++;
//			}
//		}
//		int newLength = length + spaceCount * 2;
//		str[newLength] = '\0';
//		for(int i = length - 1; i >= 0; i--){
//			if(str[i] == ' '){
//				str[newLength - 1] = '0';
//				str[newLength - 2] = '2';
//				str[newLength - 3] = '%';
//				newLength -=3;
//			} else{
//				str[newLength - 1] = str[i];
//				newLength -=1;
//			}
//		}
//		
//		return str;	
	}
	//end
	
	/* Question 54.
	 * Given a string, write a function to check if it is a permutation of palindrome. 
	 * 
	 */
	
	private static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z){
			return val - a;
		} else if(A <= val && val <= Z){
			return val - A;
		}
		return -1;
	}
	
	public static boolean isPermutationPalindrome(String phrase){
		int countOdd = 0;
		int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
		for( char c : phrase.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
				if(table[x] % 2 == 1) countOdd++;
				else countOdd--;
			}
		}
		return countOdd <= 1;
	}
	
	//end
	
	/* Question 55. 
	 * Given two strings S and T , determine if they are both one edit distance apart.
	 *  O(n) runtime, O(1) space
	 * 
	 */
	
	public static boolean isOneEditDistance(String s , String t){	
		int m = s.length(), n = t.length();
		if(m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		if( n - m > 1) return false; // more than two differences
		int i = 0;
		int shift = n-m; //could be 1, or 0
		while(i < m && s.charAt(i) == t.charAt(i)) i++;
		if(i == m) return shift > 0;
		if(shift == 0) i++; // same length
		while(i < m && s.charAt(i) == t.charAt(i + shift)) i++;	
		return i == m;
	}
	
	
	//end 
	
	/* Question 56.
	 * Given a string with repeated characters, compress the string so that it becomes shorter
	 */
	
	public static String compress(String str){
		StringBuilder compressed = new StringBuilder();
		
		int countConsecutive = 0;
		for(int i = 0; i < str.length(); i++){
			countConsecutive++;
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	//end
	
	/* Question 57.
	 * Write a method to rotate matrix by 90 degree.
	 * for i = 0  to n
	 * 		temp = top[i]
	 * 		top[i] = left[i]
	 * 		left[i] = bottom[i]
	 * 		bottom[i] = right[i]
	 * 		right[i] = temp
	 */
	
	public static void rotate(int [][] matrix, int n){
		for(int layer = 0; layer < n/2; ++layer){
			int first =layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i){
				int offset = i -first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first]; //left->top
				matrix[last-offset][first] = matrix[last][last-offset]; //bottom->left
				matrix[last][last-offset] = matrix[i][last]; //right->bottom
				matrix[i][last] = top; //top->right;			
			}
		}
	}
	//end
	
	/* Question 58.
	 * Write an algorithm such that if an element is an M*N matrix is 0, its entire row and column is 0.
	 * 
	 */
	
	public static void setZeros(int[][] matrix){
		
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[i] = true;
				}
			}
		}
		for(int i = 0; i < row.length; i++){
			if(row[i]) nullifyRow(matrix, i);	
		}
		for(int i = 0; i < column.length; i++){
			if(column[i]) nullifyColumn(matrix, i);
		}
	}
	
	private static void nullifyRow(int [][] matrix, int row){
		for(int j = 0; j < matrix[0].length; j++) matrix[row][j] = 0;
	}
	
	private static void nullifyColumn(int [][] matrix, int row){
		for(int j = 0; j < matrix.length; j++) matrix[row][j] = 0;
	}
	
	//end
	
	/* Question 59. 
	 * Given two strings s1 and s2, write code to check if s2 is a rotation of s1.
	 * 
	 */
	
	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(len == s2.length() && len > 0){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1,s2);
		}
		return false;
	}
	
	private static boolean isSubstring(String s1, String s2){
		
		return s1.contains(s2);
	}
	
	//end

}
