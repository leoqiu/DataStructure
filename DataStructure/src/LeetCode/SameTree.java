package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/22/13
 *
 *
 * http://oj.leetcode.com/problems/same-tree/
 *
 */


public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else {

            return ( (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right) );

        }

    }

}
