package BinaryTreeProblems;

public class BalancedBinaryTree {
	
	static int height(Node root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	static boolean isBalanced(Node root) {
		if(root == null) {
			return true;
		}
		
		int left = height(root.left);
		int right = height(root.right);
		if(Math.abs(left - right) > 1) {
			return false;
		}
		
		return isBalanced(root.left) && isBalanced(root.right);
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		
		System.out.println(isBalanced(root));
	}
}
