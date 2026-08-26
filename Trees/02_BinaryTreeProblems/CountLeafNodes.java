package BinaryTreeProblems;

public class CountLeafNodes {
	
	static int countLeafNodes(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		int leftSubTree = countLeafNodes(root.left);
		int rightSubTree = countLeafNodes(root.right);
		return leftSubTree + rightSubTree;
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		
		System.out.println("Leaf Nodes Count: ");
		System.out.println(countLeafNodes(root));
	}
}
