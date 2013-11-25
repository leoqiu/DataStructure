package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/15/13
 *
 *
 *
 */




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



public class BinaryTreeInorderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> solution = new ArrayList<Integer>();

        if(root == null)
            return solution;
        else {

            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (true) {

                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                if(stack.isEmpty())
                      break;

                root = stack.pop();
                //process
                solution.add(root.val);
                root = root.right;
            }
        }

        return solution;
    }

}

























