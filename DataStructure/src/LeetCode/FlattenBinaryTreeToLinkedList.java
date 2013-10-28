package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/25/13
 *
 *
 * http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 */


public class FlattenBinaryTreeToLinkedList {





    public void flatten(TreeNode root) {

        TreeNode tmp = null;
        buildTree(root, tmp);

    }


    private void buildTree (TreeNode root, TreeNode tmp) {

        if(root == null)
            return;
        else {

            buildTree(root.right, tmp);
            buildTree(root.left, tmp);

            root.right = tmp;
            tmp = root;
            root.left = null;
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
