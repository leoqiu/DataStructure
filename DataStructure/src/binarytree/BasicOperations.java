package binarytree;

import java.util.Stack;

import binarytree.elements.BinaryNode;
import binarytree.elements.BinaryTree;

public class BasicOperations {
	
	private void printNode (BinaryNode node) {
		
		System.out.println("(" + node.getcData() + ":" + node.getiData() + ")");
	}
	
	/**
	 * preorder traversal recursive
	 * 
	 * D : current node
	 * L : left node
	 * R : right node
	 * 
	 * @param root
	 */
	public void DLRTraveralR (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			//process the node at the beginning
			printNode(root);
			DLRTraveralR(root.getLeftNode());
			DLRTraveralR(root.getRightNode());
		} 
		
	}
	
	/**
	 * preorder traversal NON-recursive
	 * 
	 */
	public void DLRTraversal (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			//stack remembering current node
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			
			while(true){
				//use all the left nodes of current node
				while(root != null){
					printNode(root);
					stack.push(root);
					root = root.getLeftNode();
				}
				
				//stack is empty means - till the last current's right child is null
				if(stack.isEmpty())
					break;
				
				//pop right child
				root = stack.pop();
				root = root.getRightNode();
			}
		}
	}
	
	
	/**
	 * DLRTraversalHanlu
	 * 
	 */
	public void DLRTraversalHanlu (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			//stack remembering current node
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			
			while (root != null) {
				
				this.printNode(root);
				if(root.getRightNode() != null)
					stack.push(root.getRightNode());
				if(root.getLeftNode() != null)
					stack.push(root.getLeftNode());
				
				if (stack.isEmpty())
					break;
				
				root = stack.pop();
			}
			
			
		}
		
	}
	
	
	/**
	 * inorder LDRTraversal - recursive
	 * 
	 * @param args
	 */
	public void LDRTraversalR (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			LDRTraversalR(root.getLeftNode());
			//process the node in the middle
			this.printNode(root);
			LDRTraversalR(root.getRightNode());
		}
		
	}
	
	/**
	 * inorder LDRTraversal - NON-recursive
	 * 
	 * Non-recursive version of inorder traversal is very much similar to preorder.
	 * the only change is, instead of processing the node before going to left subtree
	 * , process it after popping (which indicates after completion of left subtree processing)
	 *
	 * D is alway the current node
	 * @param args
	 */
	public void LDRTraversal (BinaryNode root) {
		
		if(root == null)
			return; 
		else {
			//stack for remembering current node
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			
			while (true) {
				
				while (root != null){
					stack.push(root);
					root = root.getLeftNode();
				}
				
				if (stack.isEmpty())
					break;
				
				root = stack.pop();
				//processing the node after popping
				this.printNode(root);
				root = root.getRightNode();
				
			}
		}
		
	}
	
	/**
	 * postorder LRDTraversal - recursive
	 * 
	 */
	public void LRDTraversalR (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			LRDTraversalR(root.getLeftNode());
			LRDTraversalR(root.getRightNode());
			//process the node at last
			this.printNode(root);
		}
		
	}
	
	/**
	 * postorder LRDTraversal - Non-recursive
	 * 
	 * for preorder and inorder traversal we only visit the node once BUT for postorder
	 * we will visit the node twice and only process the node during the 2nd visit
	 * 
	 * how to differentiate the two visits?
	 */
	public void LRDTraversal (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			
			while (true) {
				
				while (root != null){
					stack.push(root);
					root = root.getLeftNode();
				}
				
				if (stack.isEmpty())
					break;
				
				root = stack.pop();
				this.printNode(root);
				
			}
			
			
		}
	}
	
	
	public static void main (String[] args) {
		
		BinaryNode root = BinaryTree.buildBinaryTree1();
		BasicOperations bo = new BasicOperations();
		//#1. DLRTraversal recursive
		bo.DLRTraveralR(root);
		//#2. DLRTraversal NON-recursive
		//bo.DLRTraversal(root);
		//#3. LDRTraversalR
		//bo.LDRTraversalR(root);
		//#4. LDRTraversal recursive
		//bo.LDRTraversal(root);
		//#5. LRDTraversal recursive
		//bo.LRDTraversalR(root);
	
	
		bo.DLRTraversalHanlu(root);
	}
}





































