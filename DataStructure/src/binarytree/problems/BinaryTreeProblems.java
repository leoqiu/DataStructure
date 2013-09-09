package binarytree.problems;

import binarytree.elements.BinaryNode;
import binarytree.elements.BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
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


    /**
     * #problem-11 find the height of binary tree without recursion
     *
     * add null as level separator
     *
     * @param root
     */
    public void findHeightOfBinaryTree (BinaryNode root) {

        if (root == null)
            return;
        else {
            int sum = 0;
            int level = 1;
            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            queue.offer(root);
            //use null as level seperator
            queue.offer(null);
            System.out.println("level #" + level + " summation is " + root.getiData());

            while(!queue.isEmpty()) {
                //dequeue and processing node
                root = queue.poll();

                //meet level separator
                if(root == null) {
                    if(!queue.isEmpty()){
                        queue.offer(null);
                        level++;
                        System.out.println("level #" + level + " summation is " + sum);
                        sum = 0;
                    }
                } else {
                    if(root.getLeftNode() != null) {
                        queue.offer(root.getLeftNode());
                        sum =+ root.getLeftNode().getiData();
                    }

                    if(root.getRightNode() != null){
                        queue.offer(root.getRightNode());
                        sum =+ root.getRightNode().getiData();
                    }

                }

            }

            System.out.println("tree height is : " + level);
        }

    }

    /**
     * Check if two binary tree are structure identical
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean isTwoBinaryTreeIdentical (BinaryNode root1, BinaryNode root2) {

        if(root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return (root1.getcData() == root2.getcData() && isTwoBinaryTreeIdentical(root1.getLeftNode(), root2.getLeftNode()) && isTwoBinaryTreeIdentical(root1.getRightNode(), root2.getRightNode()));


    }

    /**
     * problem #18 calculate the diameter of a binary tree
     *
     * http://stackoverflow.com/questions/11897088/diameter-of-binary-tree-better-design
     *
     * @param
     */
    //this is wrong
//     public int getDiameterOfTree (BinaryNode root) {
//
//         //use a ArrayList's first item to record diameter's update
//         ArrayList<Integer> diameter = new ArrayList<Integer>();
//         diameter.add(0, Integer.MIN_VALUE);
//         subDiameterOfTree(root, diameter);
//         return diameter.get(0);
//     }
//
//
//     public int subDiameterOfTree (BinaryNode root, ArrayList<Integer> diameter) {
//
//         int leftSubDiameter, rightSubDiameter;
//
//         if(root == null)
//             return 0;
//         else {
//             leftSubDiameter = subDiameterOfTree(root.getLeftNode(), diameter);
//             rightSubDiameter = subDiameterOfTree(root.getRightNode(), diameter);
//
//             diameter.set(0, Math.max((leftSubDiameter + rightSubDiameter + 1), diameter.get(0)));
//
//             return Math.max(leftSubDiameter, rightSubDiameter) + 1;
//
//         }
//
//     }


    /**
     * get tree height recursive
     *
     * @param root
     * @return
     */
    public int getTreeHeight (BinaryNode root) {

        if (root == null)
            return 0;
        else {
            return Math.max(getTreeHeight(root.getLeftNode()), getTreeHeight(root.getRightNode())) + 1;
        }
    }

    public int getTreeDiameter2 (BinaryNode root) {

        if (root == null)
            return 0;
        else {

            int rootDia = getTreeHeight(root.getLeftNode()) + getTreeHeight(root.getRightNode()) + 1;
            int leftTreeDia = getTreeDiameter2(root.getLeftNode());
            int rightTreeDia = getTreeDiameter2(root.getRightNode());

            return Math.max(rootDia, Math.max(leftTreeDia, rightTreeDia));

        }

    }



    /**
     *
     * reference - http://n00tc0d3r.blogspot.com/2013/01/tree-path-sum.html
     *
     * Find binary tree path sum problem
     *
     * #1. Given a binary tree and a sum, determine if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals the given sum
     *
     * @return
     */
    public boolean hasPathSum (BinaryNode root, int sum) {

        if(root == null)
            return false;

        //if node is a leaf
        if(root.getLeftNode() == null && root.getRightNode() == null)
            return (sum == root.getiData());
        else
            return (hasPathSum(root.getLeftNode(), (sum - root.getiData())) || hasPathSum(root.getRightNode(), (sum - root.getiData())));

    }


    /**
     * #2 Find All Path Sum
     *
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's
     * sum equals the given sum
     *
     *
     * @param
     */
    public ArrayList<ArrayList<Integer>> allPathSum (BinaryNode root, int sum) {
        ArrayList<ArrayList<Integer>> resultSet = new ArrayList<ArrayList<Integer>>();
        findPathSum(root, sum, new ArrayList<Integer>(), resultSet);
        return resultSet;
    }

    private void findPathSum (BinaryNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> resultSet) {

        if(root == null)
            return;
        else {

            path.add(root.getiData());
            //hit leaf node
            if(root.getLeftNode() == null && root.getRightNode() == null) {
                if(root.getiData() == sum) {
                    ArrayList<Integer> currentPath = new ArrayList<Integer>(path);
                    resultSet.add(currentPath);

                }
            }

            findPathSum(root.getLeftNode(), sum - root.getiData(), path, resultSet);
            findPathSum(root.getRightNode(), sum - root.getiData(), path, resultSet);

            path.remove(path.size() - 1);
        }

    }

    /**
     * #3 Given a binary tree, find the maximum sum of a path, the path will contain the root
     *
     *
     *
     */
    public void findMaxPathOfSumContainsRoot (BinaryNode root) {


    }

    /**
     * #4 Given a binary tree, find the maximum sum of a path, the path may start and
     * end at any node
     *
     *
     *
     */
    public int findMaxPathOfSumStartsFromAnyNode (BinaryNode root) {

        ArrayList<Integer> curMax = new ArrayList<Integer>();
        curMax.add(Integer.MIN_VALUE);
        maxSubPath(root, curMax);
        return curMax.get(0);

    }

    private int maxSubPath(BinaryNode root, ArrayList<Integer> curMax) {
        if (root == null)
            return 0;
        else {
            //find the max left path sum
            int leftMax = Math.max(0, maxSubPath(root.getLeftNode(), curMax));
            int rightMax = Math.max(0, maxSubPath(root.getRightNode(), curMax));
            curMax.set(0, Math.max(curMax.get(0), (root.getiData() + leftMax + rightMax )));
            return Math.max(root.getiData() + leftMax, root.getiData() + rightMax);

        }
    }

    /**
     * problem #20
     *
     * print out all root-to-leaf paths of a binary tree
     *
     * #1. a ArrayList<Integer> to store a single root-to-leaf path
     * #2. a ArrayList<ArrayList<Integer>> to store all root-to-leaf paths
     *
     * @param
     */
    public ArrayList<ArrayList<Integer>> getRootToLeafPathList(BinaryNode root) {

        ArrayList<ArrayList<Integer>> pathsList = new ArrayList<ArrayList<Integer>>();
        collectRootToLeafPathList(root, new ArrayList<Integer>(), pathsList);
        return pathsList;
    }


    private void collectRootToLeafPathList(BinaryNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> pathList) {

        if(root == null)
            return;
        else {

            path.add(root.getiData());
            //meet the leaf
            if(root.getLeftNode() == null && root.getRightNode() == null) {
                ArrayList<Integer> currentPath = new ArrayList<Integer>(path);
                pathList.add(currentPath);
            }

            collectRootToLeafPathList(root.getLeftNode(), path, pathList);
            collectRootToLeafPathList(root.getRightNode(), path, pathList);

            path.remove(path.size() - 1);
        }

    }

    /**
     * problem #24 Convert a tree to its mirror
     *
     * @param root
     */
    public void getMirrorOfBinaryTree (BinaryNode root) {

        if (root == null)
            return;
        else {

            getMirrorOfBinaryTree(root.getLeftNode());
            getMirrorOfBinaryTree(root.getRightNode());

            BinaryNode temp = root.getLeftNode();
            root.setLeftNode(root.getRightNode());
            root.setRightNode(temp);

        }
    }

    /**
     * problem #28 printing all ancestors of a node in a binary tree
     *
     * @param
     */
    public boolean printAllAncestorsOfANode (BinaryNode root, BinaryNode node) {

        if (root == null)
            return false;

        if (root.equals(node))
            return true;

        if(printAllAncestorsOfANode(root.getLeftNode(), node) || printAllAncestorsOfANode(root.getRightNode(), node)) {

            printNode(root);
            return true;
        }

        return false;

    }

    /**
     * problem #30 zigzag traverse a binary tree
     *
     * queue1 - level order traverse the tree
     * queue2 - print odd level nodes
     * stack - print even level nodes
     *
     * @param
     */
    public void zigzagTraversal (BinaryNode root) {

        if (root == null)
            return;
        else {
            int level = 0;

            Queue<BinaryNode> queue1 = new LinkedList<BinaryNode>();
            Queue<BinaryNode> queue2 = new LinkedList<BinaryNode>();
            Stack<BinaryNode> stack = new Stack<BinaryNode>();

            queue1.offer(root);
            queue2.offer(root);
            queue1.offer(null);


            while (!queue1.isEmpty()) {

                root = queue1.poll();
                //meet line separator
                if (root == null) {
                   if(!queue1.isEmpty())
                       queue1.offer(null);
                    level ++;
                    //zigzag print nodes
                    if (level %2 == 0){
                        //print stack
                        while(!stack.isEmpty())
                            printNode(stack.pop());
                        System.out.println("------level------- " + level);
                    } else {
                        //print queue2
                        while (!queue2.isEmpty())
                            printNode(queue2.poll());
                        System.out.println("------level------- " + level);

                    }
                } else {

                    if(root.getLeftNode() != null){
                        queue1.offer(root.getLeftNode());
                        if (level %2 == 0)
                            stack.push(root.getLeftNode());
                        else
                            queue2.offer(root.getLeftNode());
                    }

                    if(root.getRightNode() != null){
                        queue1.offer(root.getRightNode());
                        if (level %2 == 0)
                            stack.push(root.getRightNode());
                        else
                            queue2.offer(root.getRightNode());
                    }


                }

            }
        }
    }

    /**
     * problem #34 & 35 Given a binary tree with three pointers (left, right, nextSibling), algorithm to
     * fill the nextSibling
     *
     * #1. queue1 : level order traversal
     * #2. queue2 : traverse each level from head to tail and set nextSibling pointer for each node
     *
     * @param root
     */
    public void setNextSiblingPointers (BinaryNode root) {

        if (root == null)
            return;
        else {

            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            queue.offer(root);
            queue.offer(null);

            while(!queue.isEmpty()) {

                BinaryNode node = queue.poll();
                //meet level separator
                if(node == null){

                    if(!queue.isEmpty())
                        queue.offer(node);
                } else {
                   //set nextSibling
                    //node.setNextSibling(queue.getFront);
                    if(node.getLeftNode() != null)
                        queue.offer(node.getLeftNode());
                    if(node.getRightNode() != null)
                        queue.offer(node.getRightNode());

                }

            }

        }

    }


    /**
     * Lowest Common Ancestor of a Binary Tree
     *
     * http://stackoverflow.com/questions/1484473/how-to-find-the-lowest-common-ancestor-of-two-nodes-in-any-binary-tree
     *
     *
     * @param
     */
    public BinaryNode lCA (BinaryNode root, BinaryNode p, BinaryNode q) {

        BinaryNode left = null;
        BinaryNode right = null;

        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        left = lCA(root.getLeftNode(), p, q);
        right = lCA(root.getRightNode(), p, q);

        if(left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }



    public static void main(String[] args) {

        BinaryTreeProblems bp = new BinaryTreeProblems();
        BinaryNode root = BinaryTree.buildBinaryTree1();

        //problem #1
       //bp.getMaxElementInBinaryTree(root);

        //problem #5
        //bp.insertANodeIntoBinaryTree(root);

        //problem #8
        //bp.printLevelTraverseInReversedOrder(root);

        //problem #11
        //bp.findHeightOfBinaryTree(root);

        //problem #18
       // System.out.print(bp.getDiameterOfTree(root));

        //tree path problem #1
        //System.out.print(bp.hasPathSum(root, 66));

        //tree path problem #2
        //System.out.print(bp.allPathSum(root, 66));

        //tree path problem #4
        //System.out.print(bp.findMaxPathOfSumStartsFromAnyNode(root));

        //problem #20
        //System.out.print(bp.getRootToLeafPathList(root));

        //problem #24
        //bp.getMirrorOfBinaryTree(root);
        //BinaryTree.levelOrderPrintBinaryTree(root);

        //problem #28
        //BinaryNode node = new BinaryNode(26, 'T');
        //bp.printAllAncestorsOfANode(root, node);

        //problem #30
       // bp.zigzagTraversal(root);

        System.out.print(bp.getTreeDiameter2(root));
    }

}
