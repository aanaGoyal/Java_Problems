package BinaryTreeProblems;

public class DiameterOfTree { 
	// Longest distance between 2 nodess
	
	
//		    1
//		    /
//		   2
//		  / \
//		 4   5
//		/     \
//		6       7
//		/         \
//		8           9
	
	
	static int maxDiameter = 0;
	static int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int currentDiameter = 1 + leftHeight + rightHeight;
		
		maxDiameter = Math.max(currentDiameter, maxDiameter);
		
		return 1+Math.max(leftHeight, rightHeight);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(6);
		root.left.right.right = new Node(7);
		
		root.left.left.left.left = new Node(8);
		root.left.right.right.right = new Node(9);
		
		height(root);
		System.out.println(maxDiameter);
		
	}
}
