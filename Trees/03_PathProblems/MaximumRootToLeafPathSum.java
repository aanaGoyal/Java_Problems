package Path_Problems;

import java.util.ArrayList;

public class MaximumRootToLeafPathSum {
	
	// Problem : Find the maximum sum from root to leaf paths.
	
	
	// Pattern :
	// Used the Depth-First Search(dfs) approach. 
	// Here at each node we check if it is a leaf node or not. 
	// If not, then find the best way to get max sum from its left and right subtrees.
	static int maxPathSum(Node root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		if(root.left == null && root.right == null) {
			return root.data;
		}
		
		if(root.right == null) {
			return root.data + maxPathSum(root.left);
		}
		
		if(root.left == null) {
			return root.data + maxPathSum(root.right);
		}
		
		
		return root.data + Math.max(maxPathSum(root.left), maxPathSum(root.right));
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(40);
		root.right.right = new Node(70);
		
		System.out.println(maxPathSum(root));
	}
}
