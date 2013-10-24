package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/23/13
 *
 * http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 */

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

    }


}
