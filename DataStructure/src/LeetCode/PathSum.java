package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/25/13
 *
 *
 *   http://oj.leetcode.com/problems/path-sum/
 */




public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {

        ArrayList<Boolean> list = new ArrayList<Boolean>();
        list.add(false);
        traverseTree (root, sum, list);
        return list.get(0);

    }

    private void traverseTree (TreeNode root, int sum, ArrayList<Boolean> list) {


        if (root == null)
            return;
        else {

            int curVal = root.val;
            sum = sum - curVal;

            if(root.left == null && root.right == null)
                if(sum == 0) {
                     list.set(0, true);
                }

            traverseTree(root.left, sum, list);
            traverseTree(root.right, sum, list);


        }

    }



    public static void main (String[] args) {


        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);
//        TreeNode t9 = new TreeNode(9);
//
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t5.right = t8;
//        t3.left = t6;
//        t3.right = t7;
//        t7.right = t9;



        PathSum s = new PathSum();
        System.out.println(s.hasPathSum(t1, 1));



    }

}

























