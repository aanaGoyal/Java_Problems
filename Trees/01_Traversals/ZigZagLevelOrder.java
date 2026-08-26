package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
	
	
	static void zigZagTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		boolean PrevleftToRight = false;
		while(!q.isEmpty()) {
			int len = q.size();
			List<Integer>list = new ArrayList<>();
			for(int i=0; i<len; i++) {
				Node frontNode = q.poll();
				list.add(frontNode.data);
				if(frontNode.left != null) {
					q.add(frontNode.left);
				}
				
				if(frontNode.right != null) {
					q.add(frontNode.right);
				}
			}
			
			if(PrevleftToRight) {
				Collections.reverse(list);
				PrevleftToRight = false;
			}else {
				PrevleftToRight = true;
			}
			
			System.out.println(list);
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
		
		zigZagTraversal(root);
	}
}
