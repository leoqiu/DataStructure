package LeetCode.recaps;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/16/13
 *
 * http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 */


public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {

        return findMax(root, 0);
    }

    private int findMax (TreeNode root, int sum) {

        if(root == null)
            return Integer.MIN_VALUE;

        sum = sum + root.val;

        int leftSum = findMax(root.left, sum);
        int rightSum = findMax(root.right, sum);

        if(leftSum > 0)
            sum = sum + leftSum;

        if(rightSum > 0)
            sum = sum + leftSum;

        return Math.max(sum, Math.max(leftSum, rightSum));
    }


}
