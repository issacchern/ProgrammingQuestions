package leetcode;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args){
		Main main = new Main();
		boolean value = true;
		while(value){
			System.out.println("Type keyword (all): ");
			Scanner scr = new Scanner(System.in);
			String scr_str = scr.nextLine();
			String [] arr_str = scr_str.split(" ");
				
			try(BufferedReader br = new BufferedReader(new FileReader("leetcodeQuestions.txt"))) {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();
			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			        if(line != null){
			        	int count = 0;
			        	for(int i = 0; i < arr_str.length; i++){
			        		arr_str[i] = arr_str[i].toLowerCase();
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
						int [] result = main.twoSum(numbers, target);
						System.out.print("Answers: ");
						for(int i = 0 ; i < result.length; i++){
							System.out.print(result[i] + " ");
						}
						System.out.println();

						break;
					case 2 :
						System.out.println("22222");;
						break;
					case 3 :
						System.out.println("333333333");;
						break;
					case 4 : 
						
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
	
	public void printFunction(int num){
		
		try{
			BufferedReader br2 = new BufferedReader(new FileReader("src/leetcode/Main.java"));
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
	
	
	/*	Question 1.
	 * 	Given an array of integers, find two numbers such that they add up to
	 * 	a specific number. 
	 * 	Return arrays of those indices 
	 * 
	 */
	
	public int[] twoSum(int [] numbers, int target){
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
	 * 	Given an array of integers, find two numbers such that they add up to
	 * 	a specific number. 
	 * 	Return arrays of those indices 
	 * 
	 */
	
	
	

	
	//end
}
