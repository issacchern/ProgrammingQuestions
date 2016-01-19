package careercup;

public class SortingAndSearching {
	
	/* Question 139.
	 * Given two sorted arrays A and B where A is large enough to hold B.
	 * Write a method to merge B into A in sorted order.
	 * 
	 */
	
	public static void merge(int [] a, int [] b, int lastA, int lastB){
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerged = lastB + lastA - 1; //end of merged array
		
		//merge a and b, starting from last element in each
		while(indexB >= 0){
			if(indexA >= 0 && a[indexA] > b[indexB]){
				a[indexMerged] = a[indexA]; //copy element
				indexA--;
			} else{
				a[indexMerged] = b[indexB]; //copy element
				indexB--;
			}
			indexMerged--; //move indexes 
			
			
		}
		
		
	}
	
	//end
	
	/* Question 140.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 141.
	 * 
	 * 
	 * 
	 */
	
	//end
	/* Question 142.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 143.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 144.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 145.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 146.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 147.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 148.
	 * 
	 * 
	 * 
	 */
	
	//end
	
	/* Question 149.
	 * 
	 * 
	 * 
	 */
	
	//end

}
