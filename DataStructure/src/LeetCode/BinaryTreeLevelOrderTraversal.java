package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/22/13
 *
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 *
 */



public class BinaryTreeLevelOrderTraversal{

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> listOfIntegers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> integers = new ArrayList<Integer>();

        if (root == null)
            return listOfIntegers;
        else {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            queue.offer(null);

            while (!queue.isEmpty()) {

                root = queue.poll();

                if(root == null) {

                    if(!queue.isEmpty())
                        queue.offer(null);

                    listOfIntegers.add(new ArrayList<Integer>(integers));
                    integers.clear();

                } else {

                    integers.add(root.val);

                    if(root.left != null)
                        queue.add(root.left);

                    if(root.right != null)
                        queue.add(root.right);

                }

            }
        }

        return listOfIntegers;
    }

}
