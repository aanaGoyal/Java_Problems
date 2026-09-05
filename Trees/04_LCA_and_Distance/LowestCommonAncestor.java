package LCA_and_Distance;

public class LowestCommonAncestor {
	// Ancestor means the nodes that come before the another node while traversing from root to that node.
	
	// Problem : We need to find the lowest common ancestor of 2 nodes i.e. p and q. Here lowest means closest to 
	// both the nodes not lowest by value.
	
//		    3						For eg: In this tree, let p = 6 and q = 4.
//		   / \								Common ancestors for 6 and 4 are 3, 5.
//		  5   1								5 is much closer to both the nodes.
//		 / \ / \							So, ans = 5.
//		6  2 0  8
//		  / \
//		 7   4
	
	
	
	// Pattern :
	// 1. I start from the root and recursively search both the nodes in the left and right subtrees.
	// 2. If a node is null, i.e. it contributes nothing so return null.
	// 3. If a node is either p or q, I return it because it tells that I found a node.
	// 4. Ask both the left and right subtrees if they found a node.
	// 5. If both left and right child are not null that means one node is found in one side and another in another, 
	//    so it will be its common ancestor so returning current node.
	// 6. If only one side returns a non-null value, then I return that side because required node was found somewhere 
	// 	  in its subtrees.
	
	static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if(root == null) {
			return null;
		}
		
		if(root == p || root == q) {
			return root;
		}
		
		Node leftChild = lowestCommonAncestor(root.left, p, q);
		Node rightChild = lowestCommonAncestor(root.right, p, q);
		if(leftChild != null && rightChild != null) {
			return root;
		}
		
		return leftChild != null ? leftChild : rightChild;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(1);
		
		root.left.left = new Node(6);
		root.left.right = new Node(2);
		root.right.left = new Node(0);
		root.right.right = new Node(8);
		
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		
		System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right.right).data);
	}
}
