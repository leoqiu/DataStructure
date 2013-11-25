package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/19/13
 *
 * http://oj.leetcode.com/problems/recover-binary-search-tree/
 *
 */


public class RecoverBinarySearchTreeOne {


    /**
     * O(N) space, inorder traverse 重构tree
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        ArrayList<Integer> integers = new ArrayList<Integer>();

        inorder(root, nodes, integers);
        Collections.sort(integers);

        for (int i = 0; i < nodes.size(); i++)
           nodes.get(i).val = integers.get(i);

    }

    public void inorder(TreeNode root, ArrayList<TreeNode> nodes, ArrayList<Integer> integers) {

        if(root == null)
            return;
        else {

            inorder(root.left, nodes, integers);
            nodes.add(root);
            integers.add(root.val);
            inorder(root.right, nodes, integers);
        }
    }

    public static void main (String[] args) {

        RecoverBinarySearchTreeOne s = new RecoverBinarySearchTreeOne();

        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(1);

        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n3.right = n5;
        n4.right = n6;

        s.recoverTree(n1);
    }




}


























