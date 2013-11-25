package LeetCode.BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/22/13
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeDiameter {


    private int dia (TreeNode root, int curLen) {

        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(1+left+right, Math.max(left, right));
    }

    private int height (TreeNode root) {

        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));

    }

    public static void main (String[] args) {

        TreeNode n1 = new TreeNode(-3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(-5);
        TreeNode n5 = new TreeNode(-6);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(6);
        TreeNode n8 = new TreeNode(-7);
        TreeNode n9 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.right = n8;
        n7.left = n9;



        BinaryTreeDiameter s = new BinaryTreeDiameter();
        System.out.print(s.dia(n1, 0));
    }




}
