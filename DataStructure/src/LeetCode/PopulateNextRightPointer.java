package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/27/13
 *
 *
 */


public class PopulateNextRightPointer {


    public void connect(TreeLinkNode root) {

        if (root != null)
            return;
        else {

            Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
            queue.offer(root);
            queue.offer(null);;

            LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();

            while (queue != null) {

                root = queue.poll();
                list.add(root);

                if (root == null) {

                    if(!queue.isEmpty())
                        queue.add(null);

                    int n = list.size();
                    for (int i = 0; i < n - 1; i++) {

                        TreeLinkNode temp = list.get(i);
                        temp.next = list.get(i+1);

                    }

                    list.get(n - 1).next = null;
                    list.clear();

                } else {

                    if(root.left != null)
                        queue.offer(root.left);

                    if(root.right != null)
                        queue.offer(root.right);

                }
            }
        }


    }

}



class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;

         TreeLinkNode(int x) {
             val = x;
         }
}