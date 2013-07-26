package binarytree;

import java.util.LinkedList;
import java.util.Queue;
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
	 * @param
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
	 * @param
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
	 * 
	 * impelment by one stack
	 */
	public void LRDTraversalOneStack (BinaryNode root) {
		
		if (root == null)
			return;

		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		stack.push(root);
		BinaryNode prev = null;
		
		while (!stack.isEmpty()) {
			
			BinaryNode current = stack.peek();
			if(prev == null || prev.getLeftNode().equals(current) || prev.getRightNode().equals(current)){
				
				if(current.getLeftNode() != null)
					stack.push(current.getLeftNode());
				else if(current.getRightNode() != null)
					stack.push(current.getRightNode());
				else {
					this.printNode(current);
					stack.pop();
					//current = stack.peek();
				}
			}
			 // we are traversing up the tree from the left
			if (current.getLeftNode().equals(prev)) {
				if (current.getRightNode() != null)
					stack.push(current.getRightNode());
				else {
					this.printNode(current);
					stack.pop();
					//current = stack.peek();
				}
			}
			
			  // we are traversing up the tree from the right
			if (current.getRightNode().equals(prev)) {
				this.printNode(current);
				stack.pop();
				//current = stack.peek();
			}
			
			prev = current;
		}

	}
	
	/**
	 * 
	 *An alternative solution is to use two stacks. Try to work it out on a piece of paper. 
	 *I think it is quite magical and beautiful. You will think that it works magically, 
	 *but in fact it is doing a reversed pre-order traversal. That is, the order of traversal is a node, 
	 *then its right child followed by its left child. This yields post-order traversal in reversed order.
	 *Using a second stack, we could reverse it back to the correct order. 
	 * 
	 * LRD's reversed version -> DRL
	 * 
	 * @param root
	 */
	public void DRLTraversal (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			stack.push(root);
			
			while (!stack.isEmpty()) {
				
				while (root != null) {
					this.printNode(root);
					stack.push(root);
					root = root.getRightNode();
				}
				
				root = stack.pop();
				root = root.getLeftNode();
				
			}
			
		}
		
	}
 	
	/**
	 * PostOrder traversal implemented by 2 stacks
	 * 
	 * @param root
	 */
	public void LRDTraversalTwoStack (BinaryNode root) {
		
		if (root == null)
			return;
		else {
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			Stack<BinaryNode> stackR = new Stack<BinaryNode>();
			
			while (true) {
				
				while (root != null) {
					//this.printNode(root);
					stackR.push(root);
					stack.push(root);
					root = root.getRightNode();
				}
				
				if (stack.isEmpty())
					break;
				
				root = stack.pop();
				root = root.getLeftNode();
				
			}
			
			while (!stackR.isEmpty()) {
				this.printNode(stackR.pop());
			}
			
		}
	}


    /**
     *  Level order traverse a binary tree
     *
     * @param root
     */
    public void levelOrderTraversal (BinaryNode root) {

        if (root == null)
            return;
        else {

            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            BinaryNode current;
            queue.offer(root);

            while (!queue.isEmpty()) {

                current = queue.poll();
                this.printNode(current);

                if(current.getLeftNode() != null)
                    queue.offer(current.getLeftNode());
                if(current.getRightNode() != null)
                    queue.offer(current.getRightNode());


            }


        }

    }

	public static void main (String[] args) {
		
		BinaryNode root = BinaryTree.buildBinaryTree1();
		BasicOperations bo = new BasicOperations();
		//#1. DLRTraversal recursive
		//bo.DLRTraveralR(root);
		//bo.DLRTraversalHanlu(root);
		//#2. DLRTraversal NON-recursive
		//bo.DLRTraversal(root);
		//#3. LDRTraversalR
		//bo.LDRTraversalR(root);
		//#4. LDRTraversal recursive
		bo.LDRTraversal(root);
		//#5. LRDTraversal recursive
	    //bo.LRDTraversalR(root);
		//bo.LRDTraversalOneStack(root);
	
		//bo.DRLTraversal(root);
		//bo.LRDTraversalTwoStack(root);

        //level order traverse a binary tree
        //bo.levelOrderTraversal(root);

        //mac 1st
	}
}





































