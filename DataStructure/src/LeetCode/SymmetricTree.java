package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/22/13
 *
 * http://oj.leetcode.com/problems/symmetric-tree/
 *
 */

public class SymmetricTree {


    public boolean isSymmetric2(TreeNode root) {


        if (root == null)
            return true;
        else {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            queue.offer(null);

            int height = 1;

            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            while (!queue.isEmpty()) {

                root = queue.poll();

                if (root == null) {

                    if (!isListPalindromic(list, height))
                        return false;

                    list.clear();

                    if(!queue.isEmpty()){

                        queue.offer(null);

                        height++;
                    }


                }  else {

                    list.add(root);

                    if (root.left != null)
                        queue.offer(root.left);
                    else
                        queue.offer(new TreeNode(-100));

                    if (root.right != null)
                        queue.offer(root.right);
                    else
                        queue.offer(new TreeNode(-100));



                }


            }



        }

        return true;

    }

    private boolean isListPalindromic(ArrayList<TreeNode> list, int height){

        if (list.size() % 2 != 0 && height > 1)
            return false;

        int low = 0;
        int high = list.size() - 1;

        while (low < high) {

            if(list.get(low).val == list.get(high).val) {

                low++;
                high--;

            } else
                return false;

        }

        return true;

    }


    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;
        else {

            TreeNode left = root.left;
            TreeNode right = root.right;

            return isTwoTreeSymmetric (left, right);



        }
    }

    private boolean isTwoTreeSymmetric (TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        else {

            if (left.val != right.val)
                return false;

            return isTwoTreeSymmetric(left.left, right.right) && isTwoTreeSymmetric(left.right, right.left);

        }

    }

    public static void main (String[] args) {

        SymmetricTree s = new SymmetricTree();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;

       System.out.print(s.isSymmetric2(n1));

    }



}
