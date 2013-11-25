package LeetCode.BinaryTree;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/22/13
 *
 * http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 */




public class SumRoottoLeafNumbers {



    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        ArrayList<Integer> path = new ArrayList<Integer>();
        allPaths(root, path, list);
        return list.get(0);
    }

    private void allPaths (TreeNode root, ArrayList<Integer> path, ArrayList<Integer> list) {

        if(root == null)
            return;
        else {

            path.add(root.val);

            if(root.left == null && root.right == null){
                list.set(0, list.get(0)+getVal(path));
            }

            allPaths(root.left, path, list);
            allPaths(root.right, path, list);

            path.remove(path.size()-1);

        }


    }

    private int getVal (ArrayList<Integer> path) {

        int n = path.size()-1;

        int val = 0;
        for (int i = 0; i < path.size(); i++) {
            int base = (int) Math.pow(10,(n-i));
            val = val + path.get(i)*base;
        }

        return val;
    }

    public static void main (String[] args) {

//        TreeNode n1 = new TreeNode(3);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(8);
//        TreeNode n4 = new TreeNode(5);
//        TreeNode n5 = new TreeNode(6);
//        TreeNode n6 = new TreeNode(4);
//        TreeNode n7 = new TreeNode(6);
//        TreeNode n8 = new TreeNode(7);
//        TreeNode n9 = new TreeNode(5);
//
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
//        n3.left = n6;
//        n3.right = n7;
//        n5.right = n8;
//        n7.left = n9;

        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);

        n1.left = n2;



        SumRoottoLeafNumbers s = new SumRoottoLeafNumbers();
        System.out.print(s.sumNumbers(n1));
    }


}

























