package Path_Problems;

import java.util.ArrayList;

public class PathSum2 {
	
	/** In this problem, we are given a targetSum and we need to give all the paths from root 
	  	to leaf whose sum of nodes equals to targetSum. */
	
	// So, the approach being followed here is:
	// We are maintaining 2 lists: One containing the currentPath, and second containing all the valid Paths whose sum equals to targetSum.
	// We are traversing every path from root to leaf and after reaching leaf node checking if its data equals to the targetSum.
	// If so, then that is a validPath and is added to our list: validPaths.
	// After exploring one path, we backtrack towards other paths by removing the current Node from currentPath list.
	
	
	static void pathSum2(Node root, int targetSum, ArrayList<ArrayList<Integer>>validPaths, ArrayList<Integer>currentPath) {
		if(root == null) {
			return;
		}
		
		currentPath.add(root.data);
		if(root.left == null && root.right == null && root.data == targetSum) {
			validPaths.add(new ArrayList<>(currentPath));
		}
		
		pathSum2(root.left, targetSum - root.data, validPaths, currentPath);
		pathSum2(root.right, targetSum - root.data, validPaths, currentPath);
		currentPath.remove(currentPath.size() - 1);
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(40);
		root.right.right = new Node(70);
		
		ArrayList<ArrayList<Integer>> validPaths = new ArrayList<>();
		pathSum2(root, 80, validPaths, new ArrayList<>());
		System.out.println(validPaths.toString());
	}
}
