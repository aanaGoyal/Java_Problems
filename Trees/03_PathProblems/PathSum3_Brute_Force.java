package Path_Problems;

public class PathSum3_Brute_Force {
	
	/** Problem : We need to count all those paths whose sum equals target and the path need not to be from root to leaf only.
	 */
	
	// Pattern :
	// Here we are assuming every node as a root node.
	// For every node we check all its paths if they have the sum equal to target or not.
	// If sum equals target, we increment the count.
	// And we add all the paths counts in pathSum function.
	
	static int pathSum(Node root, int targetSum) {
		if(root == null) {
			return 0;
		}
		
		return countPaths(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
	}
	
	
	static int countPaths(Node root, int target) {
		if(root == null) {
			return 0;
		}
		
		int count = 0;
		target -= root.data;
		if(target == 0) {
			count ++;
		}
		
		count += countPaths(root.left, target);
		count += countPaths(root.right, target);
		return count;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println(pathSum(root,7));
	}
}
