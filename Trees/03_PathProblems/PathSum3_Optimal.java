package Path_Problems;

import java.util.HashMap;

public class PathSum3_Optimal {
	
	/** Problem : We need to find the count of the paths that sum upto the targetSum. 
		1. The path doesn't have to start from root and end at leaf alwayss. It can start from any node and end also.
		2. It must alwayss move downwards.
	 */
	
	// Solution : 
	//	1. I use DFS approach along with a HashMap.
	//	2. While going down the tree, I keep running prefixSum and check if I have seen the requiredSum before. 
	//	   Because if I get it then the path between those two prefixSum will be my required Path.
	//  3. The HashMap stores how much time each prefixSum has occurred.
	//  4. After traversing the whole subtree, we backtrack towards other paths by removing the currentPrefixSum from
	//	   the map because that sum was of the another subTree. 
	
	
	public static int pathSum3(Node root, int targetSum) {
		HashMap<Long, Integer>map = new HashMap<>();
		map.put(0L, 1);
		return pathSumHelper(root, targetSum, 0, map);
	}
	
	
	public static int pathSumHelper(Node root, int targetSum, long currentPrefixSum, HashMap<Long, Integer>map) {
		if(root == null) {
			return 0;
		}
		
		currentPrefixSum += root.data;
		long requiredSum = currentPrefixSum - targetSum;
		int count = 0;
		if(map.containsKey(requiredSum)) {
			count += map.get(requiredSum);
		}
		
		
		map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0) +1);
		count += pathSumHelper(root.left, targetSum, currentPrefixSum, map);
		count += pathSumHelper(root.right, targetSum, currentPrefixSum, map);
		
		map.put(currentPrefixSum, map.get(currentPrefixSum) - 1);
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
		
		System.out.println(pathSum3(root, 7));
	}
}
