package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		boolean value = true;
		while(value){
			System.out.println("Type keyword (all): ");
			Scanner scr = new Scanner(System.in);
			String scr_str = scr.nextLine();
			String [] arr_str = scr_str.split(",");
				
			try(BufferedReader br = new BufferedReader(new FileReader("allQuestions.txt"))) {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();
			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			        if(line != null){
			        	int count = 0;
			        	for(int i = 0; i < arr_str.length; i++){
			        		arr_str[i] = arr_str[i].toLowerCase().trim();
			        		if(arr_str[i].length() > 0 && line.toLowerCase().contains(arr_str[i])){
			        			System.out.println(line);			        	
			        		}		
			        	}
				    }
			    }
			    String everything = sb.toString();
			    if(scr_str.equals("all")) System.out.println(everything);
			    
			    System.out.println("Select question number: ");
				Scanner sc = new Scanner(System.in);
			
				if(sc.hasNextInt()){
					int num = sc.nextInt();
					//main.printFunction(num);
					
					switch(num){
					case 1 : 
						int [] numbers = {1,2, 4, 6,3, 2};
						int target = 4;
						int [] result = leetcode.LeetCode.twoSum(numbers, target);
						printFunction(num);
						System.out.print("Answers: ");
						for(int i = 0 ; i < result.length; i++){
							System.out.print(result[i] + " ");
						}
						System.out.println();

						break;
					case 2 :
						int [] numbers2 = {1,2, 4, 6,3, 2};
						int target2 = 4;
						int [] result2 = leetcode.LeetCode.twoSumSorted(numbers2, target2);
						printFunction(num);
						System.out.print("Answers: ");
						for(int i = 0 ; i < result2.length; i++){
							System.out.print(result2[i] + " ");
						}
						System.out.println();
						
						break;
					case 3 :
						System.out.println("Design questions");
						break;
					case 4 : 
						printFunction(num);
						System.out.println("Answers: " + leetcode.LeetCode.isPalindrome("asgggsd"));					
						break;
					case 5 : 
						String s = "substring";
						String subs = "str";					
						printFunction(num);
						System.out.println("Answers: " + leetcode.LeetCode.strstr(s, subs));					
						break;
					case 6 : 
						printFunction(num);
						System.out.println("Answers: " + leetcode.LeetCode.reverseWords("This is youtube!"));		
						break;	
					case 7 : 
						char [] arr = "This is fun!".toCharArray();
						printFunction(num);
						System.out.println(leetcode.LeetCode.reverseWords(arr));
						break;	
					case 8 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.atoi("33213232142"));
						break;	
					case 9 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.isNumber("329431232992.2"));
						break;	
					case 10 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.lengthOfLongestSubstring("askfdsasosf"));
						break;	
					case 11 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.lengthOfLongestSubstringTwoDistinct("faasdsa"));
						break;				
					case 12 : 
						printFunction(num);
						int[] vals = {0, 4, 6,7, 8, 29};
						System.out.println(leetcode.LeetCode.findMissingRanges(vals,0,31));								
						break;
					case 13 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.longestPalindrome("asdfghjea"));
						break;
					case 14 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.isOneEditDistance("hello", "helllS"));
						break;
					case 15 : 
						System.out.println("Skip!");
						break;
					case 16 : 
						System.out.println("Skip!");
						break;
					case 17 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.reverse(100000003));
						break;
					case 18 : 
						List<Integer> digits = new ArrayList<Integer>();
						digits.add(1);
						digits.add(3);
						digits.add(9);
						printFunction(num);
						System.out.println(leetcode.LeetCode.plusOne(digits));
						break;
					case 19 : 
						printFunction(num);
						System.out.println(leetcode.LeetCode.isPalindrome(1221221));
						break;
					case 20 : 
						printFunction(num);
						System.out.println("No demonstration for linked list!");
						break;
					case 21 : 
						printFunction(num);
						System.out.println("No demonstration for linked list!");
						break;
					case 22 : 
						printFunction(num);
						System.out.println("No demonstration for linked list!");
						break;
					case 23 : 
						printFunction(num);
						System.out.println("No demonstration for linked list!");
						break;
					case 24 : 
						printFunction(num);
						System.out.println("No demonstration for linked list!");
						break;
					case 25 : 
						printFunction(num);
						System.out.println("");
						break;
					case 26 : 
						printFunction(num);
						System.out.println("");
						break;
					case 27 : 
						printFunction(num);
						System.out.println("");
						break;
					case 28 : 
						printFunction(num);
						System.out.println("");
						break;
					case 29 : 
						printFunction(num);
						System.out.println("");
						break;	
					case 30 : 
						printFunction(num);
						System.out.println("");
						break;
					case 31 : 
						printFunction(num);
						System.out.println("");
						break;
					case 32 : 
						printFunction(num);
						System.out.println("");
						break;
					case 33 : 
						printFunction(num);
						System.out.println("");
						break;
					case 34 : 
						printFunction(num);
						System.out.println("");
						break;
					case 35 : 
						printFunction(num);
						System.out.println("");
						break;
					case 36 : 
						printFunction(num);
						System.out.println("");
						break;
					case 37 : 
						printFunction(num);
						System.out.println("");
						break;
					case 38 : 
						printFunction(num);
						System.out.println("Skip!");
						break;
					case 39 : 
						printFunction(num);
						System.out.println("");
						break;
					case 40 : 
						printFunction(num);
						System.out.println("");
						break;
					case 41 : 
						printFunction(num);
						System.out.println("");
						break;
					case 42 : 
						printFunction(num);
						System.out.println("");
						break;
					case 43 : 
						printFunction(num);
						System.out.println("");
						break;
					case 44 : 
						printFunction(num);
						System.out.println("");
						break;
					case 45 : 
						printFunction(num);
						System.out.println("");
						break;
					case 46 : 
						printFunction(num);
						System.out.println("");
						break;
					case 47 : 
						printFunction(num);
						System.out.println("");
						break;
					case 48 : 
						printFunction(num);
						System.out.println("");
						break;
					case 49 : 
						printFunction(num);
						System.out.println("");
						break;
					case 50 : 
						printFunction(num);
						System.out.println("");
						break;
					case 51 : 
						printFunction(num);
						System.out.println("");
						break;
					case 52 : 
						printFunction(num);
						System.out.println("");
						break;
					case 53 : 
						printFunction(num);
						System.out.println("");
						break;
					case 54 : 
						printFunction(num);
						System.out.println("");
						break;
					case 55 : 
						printFunction(num);
						System.out.println("");
						break;
					case 56 : 
						printFunction(num);
						System.out.println("");
						break;
					case 57 : 
						printFunction(num);
						System.out.println("");
						break;
					case 58 : 
						printFunction(num);
						System.out.println("");
						break;
					case 59 : 
						printFunction(num);
						System.out.println("");
						break;
					case 60 : 
						printFunction(num);
						System.out.println("");
						break;
					case 61 : 
						printFunction(num);
						System.out.println("");
						break;
					case 62 : 
						printFunction(num);
						System.out.println("");
						break;
					case 63 : 
						printFunction(num);
						System.out.println("");
						break;
					case 64 : 
						printFunction(num);
						System.out.println("");
						break;
					case 65 : 
						printFunction(num);
						System.out.println("");
						break;
					case 66 : 
						printFunction(num);
						System.out.println("");
						break;
					case 67 : 
						printFunction(num);
						System.out.println("");
						break;
					case 68 : 
						printFunction(num);
						System.out.println("");
						break;
					case 69 : 
						printFunction(num);
						System.out.println("");
						break;
					case 70 : 
						printFunction(num);
						System.out.println("");
						break;
					case 71 : 
						printFunction(num);
						System.out.println("");
						break;
					case 72 : 
						printFunction(num);
						System.out.println("");
						break;
					case 73 : 
						printFunction(num);
						System.out.println("");
						break;
					case 74 : 
						printFunction(num);
						System.out.println("");
						break;
					case 75 : 
						printFunction(num);
						System.out.println("");
						break;
					case 76 : 
						printFunction(num);
						System.out.println("");
						break;
					case 77 : 
						printFunction(num);
						System.out.println("");
						break;
					case 78 : 
						printFunction(num);
						System.out.println("");
						break;
					case 79 : 
						printFunction(num);
						System.out.println("");
						break;
					case 80 : 
						printFunction(num);
						System.out.println("");
						break;
					case 81 : 
						printFunction(num);
						System.out.println("");
						break;
					case 82 : 
						printFunction(num);
						System.out.println("");
						break;
					case 83 : 
						printFunction(num);
						System.out.println("");
						break;
					case 84 : 
						printFunction(num);
						System.out.println("");
						break;
					case 85 : 
						printFunction(num);
						System.out.println("");
						break;
					case 86 : 
						printFunction(num);
						System.out.println("");
						break;
					case 87 : 
						printFunction(num);
						System.out.println("");
						break;
					case 88 : 
						printFunction(num);
						System.out.println("");
						break;
					case 89 : 
						printFunction(num);
						System.out.println("");
						break;
					case 90 : 
						printFunction(num);
						System.out.println("");
						break;
					case 91 : 
						printFunction(num);
						System.out.println("");
						break;
					case 92 : 
						printFunction(num);
						System.out.println("");
						break;
					case 93 : 
						printFunction(num);
						System.out.println("");
						break;
					case 94 : 
						printFunction(num);
						System.out.println("");
						break;
					case 95 : 
						printFunction(num);
						System.out.println("");
						break;
					case 96 : 
						printFunction(num);
						System.out.println("");
						break;
					case 97 : 
						printFunction(num);
						System.out.println("");
						break;
					case 98 : 
						printFunction(num);
						System.out.println("");
						break;
					case 99 : 
						printFunction(num);
						System.out.println("");
						break;
					case 100 : 
						printFunction(num);
						System.out.println("");
						break;
					case 101 : 
						printFunction(num);
						System.out.println("");
						break;
					case 102 : 
						printFunction(num);
						System.out.println("");
						break;
					case 103 : 
						printFunction(num);
						System.out.println("");
						break;
					case 104 : 
						printFunction(num);
						System.out.println("");
						break;
					case 105 : 
						printFunction(num);
						System.out.println("");
						break;
					case 106 : 
						printFunction(num);
						System.out.println("");
						break;
					case 107 : 
						printFunction(num);
						System.out.println("");
						break;
					case 108 : 
						printFunction(num);
						System.out.println("");
						break;
					case 109 : 
						printFunction(num);
						System.out.println("");
						break;
					case 110 : 
						printFunction(num);
						System.out.println("");
						break;
					case 111 : 
						printFunction(num);
						System.out.println("");
						break;
					case 112 : 
						printFunction(num);
						System.out.println("");
						break;
					case 113 : 
						printFunction(num);
						System.out.println("");
						break;
					case 114 : 
						printFunction(num);
						System.out.println("");
						break;
					case 115 : 
						printFunction(num);
						System.out.println("");
						break;
					case 116 : 
						printFunction(num);
						System.out.println("");
						break;
					case 117 : 
						printFunction(num);
						System.out.println("");
						break;
					case 118 : 
						printFunction(num);
						System.out.println("");
						break;
					case 119 : 
						printFunction(num);
						System.out.println("");
						break;
					case 120 : 
						printFunction(num);
						System.out.println("");
						break;
					case 121 : 
						printFunction(num);
						System.out.println("");
						break;
					case 122 : 
						printFunction(num);
						System.out.println("");
						break;
					case 123 : 
						printFunction(num);
						System.out.println("");
						break;
					case 124 : 
						printFunction(num);
						System.out.println("");
						break;
					case 125 : 
						printFunction(num);
						System.out.println("");
						break;
					case 126 : 
						printFunction(num);
						System.out.println("");
						break;
					case 127 : 
						printFunction(num);
						System.out.println("");
						break;
					case 128 : 
						printFunction(num);
						System.out.println("");
						break;
					case 129 : 
						printFunction(num);
						System.out.println("");
						break;
					case 130 : 
						printFunction(num);
						System.out.println("");
						break;
					case 131 : 
						printFunction(num);
						System.out.println("");
						break;
					case 132 : 
						printFunction(num);
						System.out.println("");
						break;
					case 133 : 
						printFunction(num);
						System.out.println("");
						break;
					case 134 : 
						printFunction(num);
						System.out.println("");
						break;
					case 135 : 
						printFunction(num);
						System.out.println("");
						break;
					case 136 : 
						printFunction(num);
						System.out.println("");
						break;
					case 137 : 
						printFunction(num);
						System.out.println("");
						break;
					case 138 : 
						printFunction(num);
						System.out.println("");
						break;
					case 139 : 
						printFunction(num);
						System.out.println("");
						break;
					case 140 : 
						printFunction(num);
						System.out.println("");
						break;
					case 141 : 
						printFunction(num);
						System.out.println("");
						break;
					case 142 : 
						printFunction(num);
						System.out.println("");
						break;
					case 143 : 
						printFunction(num);
						System.out.println("");
						break;
					case 144 : 
						printFunction(num);
						System.out.println("");
						break;
					case 145 : 
						printFunction(num);
						System.out.println("");
						break;
					case 146 : 
						printFunction(num);
						System.out.println("");
						break;
					case 147 : 
						printFunction(num);
						System.out.println("");
						break;
					case 148 : 
						printFunction(num);
						System.out.println("");
						break;
					case 149 : 
						printFunction(num);
						System.out.println("");
						break;
					case 150 : 
						printFunction(num);
						System.out.println("");
						break;
						
					default:					
						System.out.println("Invalid number!"); 
						break; 
			
					}
				} 			
				else{
					System.out.println("Invalid number!");
				}
  
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		
	}
	
	public static void printFunction(int num){
		String path = "";
		if(num < 50 && num > 0) path = "src/leetcode/LeetCode.java";
		else if(num < 60 && num > 50) path = "src/careercup/ArrayAndString.java";
		else if(num > 59 && num < 68) path = "src/careercup/LinkedList.java";
		else if(num > 67 && num < 74) path = "src/careercup/StackAndQueue.java";
		else if(num > 73 && num < 86) path = "src/careercup/TreeAndGraph.java";
		else if(num > 85 && num < 95) path = "src/careercup/BitManipulation.java";
		else if(num > 94 && num < 105) return;
		else if(num > 104 && num < 117) return;
		else if(num > 116 && num < 131) path = "src/careercup/RecursionAndDynamicProgramming.java";
		else if(num > 130 && num < 139) return;
		else if(num > 138 && num < 150) path = "src/careercup/SortingAndSearching.java";
		else if(num > 149) path = "src/other/Other.java";
		
		try{
			BufferedReader br2 = new BufferedReader(new FileReader(path));
		    String line2 = br2.readLine();

		    boolean found = false;
		    while (line2 != null ) {
		    	
		        line2 = br2.readLine();
		        if(line2 != null){
		        	if(line2.contains("Question " + num + ".")){
			        	found = true;
			        	break;
			        }	        	
		        }        
		    }
		    if(found){
		    	while(line2!= null){
		    		if(!line2.contains("//end")){
		    			if(line2.trim().length() > 0){
		    				System.out.println(line2.replaceAll("\t","   "));	
		    			}				    			
		    		} else{
		    			break;
		    		}
		    		line2 = br2.readLine();
		    	}
		    }	
			
		} catch(Exception e){
			e.printStackTrace();
		}	
	}

}
