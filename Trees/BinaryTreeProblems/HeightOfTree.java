package BinaryTreeProblems;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		this.right = null;;
		this.left = null;
	}
}

public class HeightOfTree {
	
	// Same code is for Maximum Depth Of A Tree
	static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftSubTreeHeight = heightOfTree(root.left);
		int rightSubTreeHeight = heightOfTree(root.right);
		
		return 1+Math.max(leftSubTreeHeight, rightSubTreeHeight);
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		System.out.println("Height Of Tree: ");
		System.out.println(heightOfTree(root));
	}
}
