package BinaryTreeProblems;

public class SearchNode {
	
	
	static boolean searchNode(Node root, int value) {
		if(root == null) {
			return false;
		}
		
		if(root.data == value) {
			return true;
		}
		
		return searchNode(root.left, value) || searchNode(root.right, value);
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		
		System.out.println("Search Node 30: ");
		System.out.println(searchNode(root, 30));
		
		System.out.println("Search Node 90: ");
		System.out.println(searchNode(root, 90));
	}
}
