package Path_Problems;

import java.util.ArrayList;

public class RootToLeafPaths {
	
	// To keep Track of the path we are moving forward on, we are using ArrayList named "list".
	// Once we reach the leaf node, we print our whole list because it contains the path from root to that leaf.
	// After that we backtrack to our prev list, and then move forward on the next path.
	
	
	// Pattern : 
	// 1. Add the current node to the path.
	// 2. If current node = Leaf Node, then print the list.
	// 3. Recursively visit left and right childs.
	// 4. Remove the current node from path.
	
	static void rootToLeafPaths(Node root, ArrayList<Integer>list) {
		if(root == null) {
			return;
		}
		
		list.add(root.data);
		if(root.left == null && root.right == null) {
			System.out.println(list.toString());
		}
		
		
		rootToLeafPaths(root.left, list);
		rootToLeafPaths(root.right, list);
		list.remove(list.size() - 1);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		rootToLeafPaths(root, new ArrayList<>());
		
	}
}
