package Path_Problems;

public class MaximumPathSum {
	/** Problem : We need to find the maximum sum of the paths. 
		The path doesn't have to start from root and end at leaf alwayss. It can start from any node and end also.
	 */
	
	// Solution : 
	// 1. I used DFS approach to find the best possible pathSum a child can give to its parent.
	// 2. At every node, I calculated the pathSum passing through that node with the contribution of left and right childs.
	// 3. And updated the global maximumSum with it.
	// 4. But to the parent of the node, we cant pass both are child paths. So sent the best path that node can give.
	
	
	// Entire Trick : 
//			NODE
//		   /    \
//		LEFT    RIGHT
//		
//		For ANSWER:
//		LEFT + NODE + RIGHT
//		
//		For PARENT:
//		NODE + max(LEFT, RIGHT)
	
	
	static int maximumSum = Integer.MIN_VALUE;
	static int maxPathSum(Node root) {
		if(root == null) {
			return 0;
		}
		
		return pathHelper(root);
	}
	
	
	static int pathHelper(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftChild = Math.max(0,pathHelper(root.left)); // Did this to avoid negative number contribution because that will reduce the sum. So we dont take any contribution of it.
		int rightChild = Math.max(0,pathHelper(root.right));
		int currentNodeSum = root.data + leftChild + rightChild;
		maximumSum = Math.max(maximumSum, currentNodeSum);
		return root.data + Math.max(leftChild, rightChild);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.print("Max Path Sum : ");
		System.out.println(maxPathSum(root));
	}
}
