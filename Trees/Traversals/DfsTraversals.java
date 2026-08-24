package Trees;


/** 
 						  10
 				20					30
 			40		50			60		70
 */
public class DfsTraversals {
	
	// Real word Use case InOrder: Getting sorted elements from BST, converting BST to sorted array.
	static void inorder(Node root) { // Ans : 40 20 50 10 60 30 70
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	
	// Real word Use case PreOrder: Copying the tree or hierarchy
	static void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	
	// Real word Use case PostOrder: Seeing the children before Deleting a folder 
	static void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		System.out.println("Inorder Traversal: ");
		inorder(root);
		System.out.println("-------");
		
		System.out.println("PreOrder Traversal: ");
		preOrder(root);
		System.out.println("-------");
		
		
		System.out.println("PostOrder Traversal: ");
		postOrder(root);
		System.out.println("-------");
	}
}
