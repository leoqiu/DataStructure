package binarytree.problems;

import binarytree.elements.BinaryNode;
import binarytree.elements.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 7/23/13
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeProblems {

    private void printNode (BinaryNode node) {

        System.out.println("(" + node.getcData() + ":" + node.getiData() + ")");
    }

    /**
     * Problem - 1
     *
     * #1 find the maximum node in a binary tree
     *
     * #2 recursive
     *
     */
    public void getMaxElementInBinaryTree (BinaryNode root) {

        if(root == null)
            return;
        else {
            Stack<BinaryNode> stack = new Stack<BinaryNode>();
            BinaryNode temp = null;

            while(true) {

                while (root != null) {
                    //process node
                    if (temp == null)
                        temp = root;
                    else {
                        if (root.getiData() > temp.getiData())
                            temp = root;
                    }

                    stack.push(root);
                    root = root.getLeftNode();
                }

                if(stack.isEmpty())
                    break;

                root = stack.pop();
                root = root.getRightNode();

            }

            this.printNode(temp);

        }
    }

    /**
     * Problem #5 insert a node into a binary tree
     *
     * @param root
     */
    public void insertANodeIntoBinaryTree(BinaryNode root) {

        BinaryNode node = new BinaryNode(66, 'X');
        node.setLeftNode(null);
        node.setRightNode(null);

        if(root == null)
            return;
        else {

            //print tree before insertion
            BinaryTree.levelOrderPrintBinaryTree (root);
            System.out.println("----------");

            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            //save root for print
            BinaryNode current = root;
            queue.offer(current);

            while(!queue.isEmpty()){

                current = queue.poll();
                //process root

                if(current.getLeftNode() != null)
                    queue.offer(current.getLeftNode());
                else {
                    current.setLeftNode(node);
                    System.out.println("---- " + current.getcData());
                    break;
                }


                if(current.getRightNode() != null)
                    queue.offer(current.getRightNode());
                else {
                    current.setRightNode(node);
                    System.out.println("---- " + current.getcData());
                    break;
                }

            }

            //print tree after insertion
            BinaryTree.levelOrderPrintBinaryTree (root);

        }

    }


    /**
     * problem #8 print binary tree in reversed level order traverse
     *
     * @param root
     */
    public void printLevelTraverseInReversedOrder (BinaryNode root) {

        if(root == null)
            return;
        else {
            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            Stack<BinaryNode> stack = new Stack<BinaryNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                root = queue.poll();
                //processing node
                stack.push(root);

                if(root.getLeftNode() != null)
                    queue.offer(root.getLeftNode());
                if(root.getRightNode() != null)
                    queue.offer(root.getRightNode());

            }

            while (!stack.isEmpty())
                this.printNode(stack.pop());

        }

    }

    /**
     * problem #9 delete a binary tree
     *
     * recycle node in a postorder reversed manner or a level order reversed manner
     *
     * 1. post order: RLD
     * 2. RLD is reversed of DLR
     *
     *
     * @param root
     */
    public void deleteABinaryTree(BinaryNode root) {

        if(root == null)
            return;
        else {
            Stack<BinaryNode> stack = new Stack<BinaryNode>();
            Stack<BinaryNode> stackR = new Stack<BinaryNode>();

            while (true) {

                while(root != null){
                    //processing the node
                    stackR.push(root);

                    stack.push(root);
                    root = root.getLeftNode();
                }

                if(stack.isEmpty())
                    break;

                root = stack.pop();
                root = root.getRightNode();

            }

            //recycle nodes in a reversed post order
            while (!stackR.isEmpty()) {
                BinaryNode node = stackR.pop();
                node = null;
            }

        }

    }

    public static void main(String[] args) {

        BinaryTreeProblems bp = new BinaryTreeProblems();
        BinaryNode root = BinaryTree.buildBinaryTree1();

        //problem #1
        //bp.getMaxElementInBinaryTree(root);

        //problem #5
        //bp.insertANodeIntoBinaryTree(root);

        //problem #8
        bp.printLevelTraverseInReversedOrder(root);

    }

}
