package BinaryTreeProblems;

public class AreTreesIdentical {
	
	static boolean areIdenticalTrees(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		
		if(root1.data != root2.data) {
			return false;
		}
		
		return areIdenticalTrees(root1.left, root2.left) && areIdenticalTrees(root1.right, root2.right);
	}
	
	public static void main(String[] args) {
		Node root1 = new Node(10);
		root1.left = new Node(20);
		root1.right = new Node(30);
		
		root1.left.left = new Node(40);
		root1.left.right = new Node(50);
		root1.right.left = new Node(60);
		root1.right.right = new Node(70);
		
		
		Node root2 = new Node(10);
		root2.left = new Node(20);
		root2.right = new Node(30);
		
		root2.left.left = new Node(40);
		root2.left.right = new Node(80);
		root2.right.left = new Node(60);
		root2.right.right = new Node(70);
		
			
		System.out.println(areIdenticalTrees(root1, root2));
		
	}
}
