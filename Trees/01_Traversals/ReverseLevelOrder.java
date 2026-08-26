package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {

	
	/** Approach 1 : Reversing the levels using reverse() */
	static void reverseLevelOrder(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		ArrayList<ArrayList<Integer>>list = new ArrayList<>();
		while(!q.isEmpty()) {
			int len = q.size();
			ArrayList<Integer>level = new ArrayList<>();
			
			for(int i=0; i<len; i++) {
				Node frontNode = q.poll();
				level.add(frontNode.data);
				
				if(frontNode.left != null) {
					q.add(frontNode.left);
				}
				
				if(frontNode.right != null) {
					q.add(frontNode.right);
				}
			}
			list.add(level);
		}
		
		Collections.reverse(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	
	/** Approach 2 : Using Stack */
	static void reverseLevelOrder2(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node>q = new LinkedList<>();
		q.add(root);
		Stack<ArrayList>s = new Stack<>();
		
		while(!q.isEmpty()) {
			int len = q.size();
			ArrayList<Integer>level = new ArrayList<>();
			for(int i=0; i<len; i++) {
				Node frontNode = q.poll();
				level.add(frontNode.data);
				
				if(frontNode.left != null) {
					q.add(frontNode.left);
				}
				
				if(frontNode.right != null) {
					q.add(frontNode.right);
				}
			}
			s.add(level);
		}
		
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
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
		
		System.out.println("Using Reverse() method");
		reverseLevelOrder(root);
		
		
		System.out.println("Using Stack");
		reverseLevelOrder2(root);
	}
}
