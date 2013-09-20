package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 9/19/13
 *
 * http://oj.leetcode.com/submissions/detail/59027/
 */
public class SumRootToLeafNumbers {


    public int sumNumbers(TreeNode root) {

        ArrayList<Integer> count = new ArrayList<Integer>();
        count.add(0);
        sumOfPaths(root, new ArrayList<TreeNode>(), count);

        return count.get(0);
    }


    private void sumOfPaths (TreeNode root, ArrayList<TreeNode> list, ArrayList<Integer> count) {

        if (root == null)
            return;
        else {

            list.add(root);

            if (root.left == null && root.right == null) {

                int sum = getListSum(list);
                count.set(0, count.get(0) + sum);

            }

            sumOfPaths (root.left, list, count);
            sumOfPaths (root.right, list, count);

            list.remove(list.size() - 1);

        }

    }

    private int getListSum (ArrayList<TreeNode> list) {

        String str = "";

        for (int i = 0; i < list.size(); i++)
            str = str + list.get(i).val;

        return Integer.parseInt(str);
    }




}






class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
