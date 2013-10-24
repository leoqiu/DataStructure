package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/23/13
 *
 *
 *
 */


public class BinaryTreeZigzagLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {


        ArrayList<ArrayList<Integer>> listIntegers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> integers = new ArrayList<Integer>();

        if (root == null) {
            return listIntegers;
        } else {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            queue.offer(null);

            //level needs to be set as 1, otherwise queue will be empty
            int level = 1;

            while (!queue.isEmpty()) {

                root = queue.poll();

                if (root == null) {

                    if (level%2 == 1) {
                        listIntegers.add(new ArrayList<Integer>(integers));

                    } else {
                        ArrayList<Integer> tmpList = new ArrayList<Integer>();
                        for (int i = integers.size() - 1; i >= 0; i--) {
                            tmpList.add(integers.get(i));
                        }
                        listIntegers.add(tmpList);
                    }

                    integers.clear();

                    if(!queue.isEmpty()){

                        queue.offer(null);
                        level++;
                    }
                } else {

                    integers.add(root.val);

                    if(root.left != null)
                        queue.offer(root.left);

                    if(root.right != null)
                        queue.offer(root.right);

                }


            }

        }

        return listIntegers;
    }

    public static void main (String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
        s.zigzagLevelOrder(n1);


    }

}































