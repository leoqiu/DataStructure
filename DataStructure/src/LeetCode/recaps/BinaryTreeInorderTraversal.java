package LeetCode.recaps;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/16/13
 *
 * http://oj.leetcode.com/problems/binary-tree-inorder-traversal/
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


        ArrayList<Integer> list = new ArrayList<Integer>();

        if(root == null)
            return list;
        else {

            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (true) {

                while (root != null) {
                    //process preoder
                    list.add(root.val);
                    stack.push(root);
                    root = root.left;
                }

                if (stack.isEmpty())
                    break;

                root = stack.pop();
                //process inoder
                //list.add(root.val);
                root = root.right;

            }

            return list;
        }

    }



}





























