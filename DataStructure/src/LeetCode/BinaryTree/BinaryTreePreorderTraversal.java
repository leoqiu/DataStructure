package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/25/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreePreorderTraversal {


    public ArrayList<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> solution = new ArrayList<Integer>();

        if (root == null)
            return solution;
        else {

            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (true) {

                while(root != null) {
                    stack.push(root);
                    solution.add(root.val);
                    root = root.left;
                }

                if(stack.isEmpty())
                    break;

                root = stack.pop();
                root = root.right;

            }
        }

        return solution;
    }


}
