package careercup;
import java.util.*;

import leetcode.LeetCode.Node;


public class LinkedList {
	
	public static class Node{
		
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	/* Question 60.
	 * Remove duplicates from an unsorted linked list.
	 * O(n) time , O(n) space
	 * Follow-up : if don't use temp buffer?
	 */
	
	public static void deleteDups(Node n){
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while(n != null){
			if(set.contains(n.data)){
				previous.next = n.next;
			} else{
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	//without extra space
	//O(n^2) time, O(1) space
	
	public static void deleteDups2(Node head){
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				} else{
					runner = runner.next;
				}				
			}
			current = current.next;
		}
	}

	//end
	
	/* Question 61.
	 * Find the Kth to last element of linked list.
	 * 
	 */
	
	//recursive way
	public static int printKthToLast(Node head, int k){
		if(head == null) return 0;		
		int index = printKthToLast(head.next,k) + 1;
		if(index == k) System.out.println(k + "th to last node is " + head.data);
		return index;
	}
	
	//iterative way
	public static Node nthToLast(Node head, int k){
		Node p1 = head;
		Node p2 = head;
		
		//move p2 k nodes into the list
		for(int i = 0; i < k ; i++){
			if(p1 == null ) return null; // out of bounds
			p1 = p1.next;
		}
		
		//move them at the same pace. when p1 hits the end, p2 will be 
		//at right element
		while(p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}		
		return p2;
	}
	
	//end
	
	/* Question 62.
	 * Delete a node at the middle of a singly linked list, given only access to that node.
	 * 
	 */
	
	public static boolean deleteNode(Node n){
		if(n == null || n.next == null){
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
	
	//end
	
	
	
	/* Question 63.
	 * Write code to partition a linked list around a value x such that all nodes less 
	 * than x come before all nodes greater than or equal to x.
	 * 
	 */
	
	public static Node partition(Node node, int x){
		Node head = node;
		Node tail = node;
		while(node != null){
			Node next = node.next;
			if(node.data < x){
				node.next =head;
				head = node;
			} else{
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
	//end
	
	/* Question 64.
	 * Add two linked list number and store in reverse order, which each node contains a single digit.
	 * (2->4->3) + (5->6->4) = (7->0->8)
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
			carry = digit / 10;
			curr.next = new Node(digit % 10);
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
	
	/* Question 65.
	 * Check if a linked list is palindrome. (similar to string palindrome)
	 * Hint : use stack 
	 * Hint : use slow/fast runner to get the midpoint, when fast runner hits the end,
	 * slow runner will reach the middle of list
	 * Hint : so by the end of iteration, the stack will have elements from the front list
	 * in reverse order.
	 * 
	 */
	public static boolean isPalindrome(Node head){
		Node fast = head;
		Node slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null){ // odd number of elements
			slow = slow.next;
		}
		
		while(slow != null){
			int top = stack.pop();
			if(top != slow.data){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	
	//end
	
	/* Question 66.
	 * Given two singly linked list, determine if two lists intersect. Return intersecting node.
	 * 
	 * 
	 */
	
	public static Node getIntersectionNode(Node headA, Node headB) {
        int len1 = 0;
        int len2 = 0;
        Node p1=headA, p2=headB;
        if (p1 == null || p2 == null)
            return null;
 
        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while(p2 !=null){
            len2++;
            p2 = p2.next;
        }
 
        int diff = 0;
        p1=headA;
        p2=headB;
 
        if(len1 > len2){
            diff = len1-len2;
            int i=0;
            while(i<diff){
                p1 = p1.next;
                i++;
            }
        }else{
            diff = len2-len1;
            int i=0;
            while(i<diff){
                p2 = p2.next;
                i++;
            }
        }
 
        while(p1 != null && p2 != null){
            if(p1.data == p2.data){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
 
        return null;
    }
	
	
	//end
	
	/* Question 67.
	 * Given a circular linked list, implement an algorithm that returns the node at the beginning
	 * of the loop.
	 */
	
	public static Node findDeginning(Node head){
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){ //collision
				break;
			}
		}
		if(fast == null || fast.next == null){
			return null;
		}
		
		slow = head; // move slow to head , keep fast at meeting point
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;	
		}
		
		return fast;
	}

	//end
	

}
