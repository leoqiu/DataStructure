package LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/21/13
 *
 * http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 */


class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) {
         val = x;
     }
 }



public class PopulateNextRightPointersEachNode {


    public void connect(TreeLinkNode root) {

        if (root == null)
            return;
        else {

            Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
            LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
            queue.add(root);
            queue.add(null);


            while (!queue.isEmpty()) {

                root = queue.poll();
                if(root != null)
                    list.add(root);

                if(root == null) {
                    //populate
                    for (int i = 0; i < list.size()-1; i++)
                        list.get(i).next = list.get(i+1);
                    list.get(list.size()-1).next = null;
                    list.clear();

                    if(!queue.isEmpty())
                        queue.add(null);
                } else {

                    if(root.left != null)
                        queue.add(root.left);

                    if(root.right != null)
                        queue.add(root.right);
                }
            }
        }
    }

    public static void main (String[] args) {

        TreeLinkNode n1 = new TreeLinkNode(0);

        PopulateNextRightPointersEachNode s = new PopulateNextRightPointersEachNode();
        s.connect(n1);

    }


}































