package BinaryTreeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
	
	static void mirrorTree(Node root) {
		if(root == null) {
			return;
		}
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorTree(root.left);
		mirrorTree(root.right);
	}
	
	static void levelOrder(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i=0; i<len; i++) {
				Node frontNode = q.poll();
				System.out.print(frontNode.data + " ");
				if(frontNode.left != null) {
					q.add(frontNode.left);
				}
				if(frontNode.right != null) {
					q.add(frontNode.right);
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		mirrorTree(root);
		levelOrder(root);
	}
}
