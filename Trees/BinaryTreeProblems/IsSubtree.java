package BinaryTreeProblems;

public class IsSubtree {
	
	static boolean isIdentical(Node root, Node subTreeRoot) {
		if(root == null && subTreeRoot == null) {
			return true;
		}
		
		if(root == null || subTreeRoot == null) {
			return false;
		}
		
		if(root.data != subTreeRoot.data) {
			return false;
		}
		
		return isIdentical(root.left, subTreeRoot.left) && isIdentical(root.right, subTreeRoot.right);
	}
	
	
	static boolean isSubtreeOfAnotheTree(Node root, Node subTreeRoot) {
		if(subTreeRoot == null) {
			return true;
		}
		
		if(root == null) {
			return false;
		}
		
		if(isIdentical(root, subTreeRoot)) {
			return true;
		}
		
		return isSubtreeOfAnotheTree(root.left, subTreeRoot) || isSubtreeOfAnotheTree(root.right, subTreeRoot);
		
	}
	
	
	public static void main(String[] args) {
		Node root1 = new Node(10);
		root1.left = new Node(20);
		root1.right = new Node(30);
		
		root1.left.left = new Node(40);
		root1.left.right = new Node(50);
		root1.right.left = new Node(60);
		root1.right.right = new Node(70);
		
		
		Node root2 = new Node(30);
		root2.left = new Node(60);
		root2.right = new Node(70);
		
		System.out.println(isSubtreeOfAnotheTree(root1,root2));
		
	}
	
}
