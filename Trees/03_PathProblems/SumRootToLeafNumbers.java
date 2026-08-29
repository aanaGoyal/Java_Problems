package Path_Problems;

public class SumRootToLeafNumbers {
	
/** 		    1
		2				3
	4		5		6		7
*/
	
	
	/** At every root to leaf path, a number is being formed by combining the digits 
	 	at nodes. We need to return the sum of all those numbers. 
	 	For eg: In above tree, path numbers will be 124, 125, 136, 137. So we need to give these numbers sum.
	 	*/
	
	static int sumOfNumbers(Node root, int number) {
		if(root == null) {
			return 0;
		}
		
		number*=10;
		number += root.data;
		if(root.left == null && root.right == null) {
			return number;
		}
		
		
		return sumOfNumbers(root.left, number) + sumOfNumbers(root.right, number);
			
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println(sumOfNumbers(root, 0));
	}
}
