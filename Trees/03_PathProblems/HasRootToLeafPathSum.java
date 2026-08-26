package Path_Problems;

import java.util.ArrayList;

public class HasRootToLeafPathSum {
	
	/** In this problem, we are given a targetSum and we need to check that if any path from 
	 	root to leaf node sums up to that targetSum. */
	
	// So, the approach being followed here is:
	// We are starting from the root node, and check if it is a leaf node and if not, we go to its child.
	// While moving to the child, we remove the current node data from targetSum because after that we need that much sum only.
	// If satisfied, we found the path.
	
	public static boolean hasPathSum(Node root, int targetSum) {
		if(root == null) {
			return false;
		}
		
		if(root.left == null && root.right == null) {
			return root.data == targetSum;
		}
		
		return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		System.out.println(hasPathSum(root, 80));
	}
}
