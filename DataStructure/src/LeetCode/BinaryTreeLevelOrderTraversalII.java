package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/23/13
 *
 *
 */


public class BinaryTreeLevelOrderTraversalII {




    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<ArrayList<Integer>> listIntegers = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> stackIntegers = new Stack<ArrayList<Integer>>();
        ArrayList<Integer> integers = new ArrayList<Integer>();

        if (root == null)
            return listIntegers;
        else {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {

                root = queue.poll();

                if(root == null) {

                    if(!queue.isEmpty()) {
                        queue.offer(null);
                    }

                    stackIntegers.add(new ArrayList<Integer>(integers));
                    integers.clear();

                } else {

                    integers.add(root.val);

                    if(root.left != null)
                        queue.offer(root.left);

                    if(root.right != null)
                        queue.offer(root.right);

                }

            }

            while (!stackIntegers.isEmpty())
                listIntegers.add(stackIntegers.pop());
        }


        return listIntegers;
    }


}
