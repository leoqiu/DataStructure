package LeetCode.BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/22/13
 *
 * http://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 */




public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {

        return findMax(root, 0);
    }

    //static int max = Integer.MIN_VALUE;
    private int findMax (TreeNode root, int curSum) {

        if(root == null)
            return Integer.MIN_VALUE;

        curSum += root.val;
        int left =  findMax(root.left, 0);
        int right = findMax(root.right, 0);

        if(left > 0)
            curSum += left;

        if(right > 0)
            curSum += right;

        return Math.max(curSum, Math.max(left, right));
    }

//    public int maxPathSum2(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int[] res = maxPathSums(root);
//        return res[1];
//    }
//
//    public int[] maxPathSums(TreeNode root){
//        int[] res = new int[2];
//        if(root==null){
//            res[0]=Integer.MIN_VALUE;
//            res[1]=Integer.MIN_VALUE;
//            return res;
//        }
//        int[] fromLeft = maxPathSums(root.left),
//                fromRight = maxPathSums(root.right);
//
//        int temp1 = fromLeft[0]>0?(fromLeft[0]+root.val):root.val;
//        int temp2 = fromRight[0]>0?(fromRight[0]+root.val):root.val;
//
//        res[0]=Math.max(temp1,temp2);
//        res[1]=Math.max(fromLeft[1],Math.max(fromRight[1], Math.max(temp1+temp2-root.val,res[0])));
//
//        return res;
//    }


    public static void main (String[] args) {

//        TreeNode n1 = new TreeNode(-3);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(8);
//        TreeNode n4 = new TreeNode(-5);
//        TreeNode n5 = new TreeNode(-6);
//        TreeNode n6 = new TreeNode(4);
//        TreeNode n7 = new TreeNode(6);
//        TreeNode n8 = new TreeNode(-7);
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

//        TreeNode n1 = new TreeNode(-3);

        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(-2);
        TreeNode n7 = new TreeNode(-1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n4.left = n7;

        BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();
        System.out.print(s.maxPathSum(n1));
    }

}




























