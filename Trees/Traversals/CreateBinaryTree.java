package Trees;

/** BINARY TREES : Tree with at most 2 children of a parent */

 // 1. Full Binary Tree : Tree with each node having 0 or 2 children.
// 2. Complete Binary Tree : Tree with all the levels filled except the last one filled from left to right.
// 3. Perfect Binary Tree : All the internal nodes have 2 children and leaf nodes are at the same level.

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

public class CreateBinaryTree {
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
	}
}
