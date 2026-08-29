package Path_Problems;

public class MinimumRootToLeafPathSum {
	// Problem : Find the minimum sum from root to leaf paths.
	
	
	// Pattern :
	// Used the Depth-First Search(dfs) approach. 
	// Here at each node we check if it is a leaf node or not. 
	// If not, then find the best way to get min sum from its left and right subtrees.
	
	static int minPathSum(Node root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		if(root.left == null && root.right == null) {
			return root.data;
		}
		
		if(root.left == null) {
			return root.data + minPathSum(root.right);
		}
		
		if(root.right == null) {
			return root.data + minPathSum(root.left);
		}
		
		return root.data + Math.min(minPathSum(root.left), minPathSum(root.right));
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(40);
		root.right.right = new Node(70);
		
		System.out.println(minPathSum(root));
	}
}
