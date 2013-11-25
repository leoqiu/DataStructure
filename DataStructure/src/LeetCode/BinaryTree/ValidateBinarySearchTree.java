package LeetCode.BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/17/13
 *
 * http://oj.leetcode.com/problems/validate-binary-search-tree/
 *
 */


public class ValidateBinarySearchTree {


    public boolean isValidBST1(TreeNode root) {

        if(root == null)
            return true;

        if(root.left != null && root.left.val < root.val && root.right == null)
            if(isValidBST1(root.left))
                return true;

        if(root.right != null && root.right.val > root.val && root.left == null)
            if (isValidBST1(root.right))
                return true;

        if(root.left != null && root.left.val < root.val && root.right != null && root.right.val > root.val)
            if(isValidBST1(root.left) && isValidBST1(root.right))
                return true;

        return false;
    }

    public boolean isValidBST2(TreeNode root) {

        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left != null && root.left.val < root.val && root.right != null && root.right.val > root.val)
            return isValidBST2(root.left) && isValidBST2(root.right);

        if(root.left != null && root.left.val < root.val && root.right == null)
            return isValidBST2(root.left);

        if(root.right != null && root.right.val > root.val && root.left == null)
            return isValidBST2(root.right);

        return false;
    }

    public boolean isValidBST(TreeNode root) {

        if(root == null)
            return true;

        return isValidBSTR(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTR(TreeNode root, int min, int max) {

        if(root == null)
            return true;

        if (root.val > min && root.val < max && isValidBSTR(root.left, min, root.val) && isValidBSTR(root.right, root.val, max))
            return true;
        else
            return false;
    }

    public static void main (String[] args) {

        ValidateBinarySearchTree s = new ValidateBinarySearchTree();

        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        System.out.print(s.isValidBST(n1));

    }

}






























