package careercup;

import java.util.Stack;

public class StackAndQueue {
	
	/* Question 68.
	 * Describe how you could use a single array to implement three stacks
	 * TOO LONG, NO ANSWER!
	 */
	
	//end
	
	/* Question 69.
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
	
	/* Question 70.
	 * Stack of plates
	 * TOO LONG, NO ANSWER!
	 */
	
	//end
	
	/* Question 71.
	 * Implement a MyQueue class which implements a queue using two stacks.
	 * TOO LONG, NO ANSWER!
	 */
	
	//end
	
	/* Question 72.
	 * Sort a stack such that smallest items are on top.
	 * 
	 */
	
	public static Stack <Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp){
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		
		return r;
	}
	
	//end
	
	/* Question 73.
	 * Animal shelter
	 * TOO LONG, NO ANSWER!
	 * 
	 */
	
	//end

}
