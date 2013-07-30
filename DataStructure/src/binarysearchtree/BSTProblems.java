package binarysearchtree;

import binarytree.elements.BinaryNode;
import binarytree.elements.BinaryTree;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 7/29/13
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class BSTProblems {


    private static void printNode (BinaryNode node) {

        System.out.println("(" + node.getcData() + ":" + node.getiData() + ")");
    }



    /**
     * problem #59 - give a algorithm to find the kth smallest elements in a BST
     *
     * LDR traverse (will print BST in ascending order) the tree and keep update the kth smallest value
     */
      public BinaryNode findKthNodeInBST (BinaryNode root, int k) {

         if (root == null)
             return null;
          else {

             Stack<BinaryNode> stack = new Stack<BinaryNode>();
             int count = 0;
             while (true) {

                 while (root != null){

                     stack.push(root);
                     root = root.getLeftNode();
                 }

                 if (stack.isEmpty())
                     break;


                 root = stack.pop();
                 //process the node
                 count++;
                 if(count == k)
                     break;
                 root = root.getRightNode();

             }

             return root;
         }

      }

    /**
     * problem #64 #65 - print all elements in BST between range K1 and K2
     *
     * recursive way
     */
    public void printElementsInRage (BinaryNode root, int k1, int k2) {

        if(root == null)
            return;
        else {

           if (root.getiData() >= k1 && root.getiData() <= k2)
                printNode(root);
           if(root.getiData() >= k1)
                printElementsInRage (root.getLeftNode(), k1, k2);
           if (root.getiData() <= k2)
                printElementsInRage (root.getRightNode(), k1, k2);

        }
    }


    /**
     * Definition of AVL tree:
     *   1. It is a BST
     *   2. For any node X, the height of left subtree of X and height of right subtree of X differ by at most 1
     *
     */


    /**
     *
     * @param args
     */
    public static void main (String args[]) {

        BSTProblems bstProblems = new BSTProblems();
        BinaryNode root = BinaryTree.buildBinaryTree1();

        //problem #59
        //printNode(bstProblems.findKthNodeInBST(root, 10));

        //problem #64 #65
        bstProblems.printElementsInRage(root, 9, 19);
    }

}




































