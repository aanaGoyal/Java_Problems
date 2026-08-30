package Path_Problems;

public class CountRountToLeafPaths {
	
	/** Problem : Count no. of root to leaf paths */
	// Pattern : 
	// Explore the left and right subtrees of a node and when a leaf node is reached means we 
	// traveled one path so we increment the count there.
	
	static int countLeafPaths(Node root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left== null && root.right==null) {
			return 1;
		}
		
		return countLeafPaths(root.left) + countLeafPaths(root.right);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println(countLeafPaths(root));
	}
}
