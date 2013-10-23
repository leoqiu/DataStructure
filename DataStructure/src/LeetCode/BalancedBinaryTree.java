package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/22/13
 *
 * http://oj.leetcode.com/problems/balanced-binary-tree/
 *
 */


public class BalancedBinaryTree {



    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;
        else {

            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);

            return (Math.abs(leftHeight-rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right));

        }

    }

    private int treeHeight (TreeNode root) {

        if (root == null)
            return 0;
        else
            return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));

    }



}
