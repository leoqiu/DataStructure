package LeetCode;

import binarytree.elements.BinaryNode;
import binarytree.elements.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/22/13
 *
 * http://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 */


 class LTreeNode {
      int val;
    LTreeNode left;
    LTreeNode right;

      LTreeNode(int x) {
          val = x;
      }
  }



public class MinimumDepthBinaryTree {



    public int minDepth(BinaryNode root) {

        int min = Integer.MAX_VALUE;

        if (root == null)
            return 0;
        else {

            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            queue.offer(root);
            queue.offer(null);

            int height = 1;

            while (!queue.isEmpty()) {

                root = queue.poll();

                if(root == null) {

                    if(!queue.isEmpty()) {
                        height++;
                        queue.offer(null);
                    }

                } else {
                    if(root.getLeftNode() == null && root.getRightNode() == null)
                        return Math.min(min, height);

                    if(root.getLeftNode() != null)
                        queue.offer(root.getLeftNode());
                    if(root.getRightNode() != null)
                        queue.offer(root.getRightNode());
                }

            }
        }

        return min;
    }

    public static void main (String[] args) {

        BinaryNode root = BinaryTree.buildBinaryTree1();
        MinimumDepthBinaryTree s = new MinimumDepthBinaryTree();
        s.minDepth(root);

    }





}
