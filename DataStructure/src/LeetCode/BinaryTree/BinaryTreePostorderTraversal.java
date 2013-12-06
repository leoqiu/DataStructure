package LeetCode.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/25/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */


public class BinaryTreePostorderTraversal {


    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> solution = new ArrayList<Integer>();

        if(root == null)
            return solution;
        else {

            Stack<TreeNode> stack = new Stack<TreeNode>();
            Stack<TreeNode> stackR = new Stack<TreeNode>();

            while (true) {
                while (root != null) {
                    stackR.push(root);
                    stack.push(root);
                    root = root.right;
                }

                if (stack.isEmpty())
                    break;

                root = stack.pop();
                root = root.left;
            }

            while (!stackR.isEmpty())
                solution.add(stackR.pop().val);

        }

        return solution;
    }


    public static void main(String[] args) {

        BinaryTreePostorderTraversal s = new BinaryTreePostorderTraversal();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;

        s.postorderTraversal(n1);


    }


}



























