package LeetCode.BinaryTree;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/19/13
 *
 *
 *
 */


public class FlattenBinaryTreeToLinkedList {




    public void flatten(TreeNode root) {

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        preorder(root, list);

        if(list.size() == 0)
            return;

        TreeNode head = new TreeNode(0);
        TreeNode pre = list.get(0);
        pre.left = null;
        head.right = pre;


        for (int i = 1; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            cur.left = null;
            pre.right = cur;
            pre = cur;
        }

        root = head.right;

        System.out.print("");
    }

    private void preorder (TreeNode root, ArrayList<TreeNode> list) {

        if(root == null)
            return;
        else {

            //
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);

        }
    }



    public static void main (String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.right = n9;
        n6.left = n10;


        FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        s.flatten(n1);

    }

}
