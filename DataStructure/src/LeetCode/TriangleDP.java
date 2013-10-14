package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 9/27/13
 * Time: 6:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TriangleDP {



    public static void main (String[] args) {

        TriangleDP triangleDP = new TriangleDP();

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        int n = triangle.size();
        TTNode root = new TTNode();
        int level = 0;
        root.sum = triangle.get(level).get(0);
        root.index = 0;

        triangleDP.buildTTree(root, triangle, level, n);
        System.out.print(minPathSum);
        //triangleDP.levelTraversalTree(root);
        //System.out.print(triangleDP.getMinPathSum(root));

    }

    private void levelTraversalTree (TTNode root) {

        if (root == null) {
            return;

        } else {

            Queue<TTNode> queue = new LinkedList<TTNode>();
            queue.offer(root);
            queue.offer(null);

            while (!queue.isEmpty()) {

                root = queue.poll();
                //do something
                if(root != null)
                    System.out.print(root.sum + " ");

                if(root == null) {
                    if (!queue.isEmpty())
                        queue.offer(null);
                    System.out.println();

                } else {
                    if (root.left != null)
                        queue.offer(root.left);

                    if (root.right != null)
                        queue.offer(root.right);
                }

            }

        }

    }

    private int getMinPathSum (TTNode root) {

        int minSum = Integer.MAX_VALUE;

        if (root == null)
            return 0;
        else {

            Queue<TTNode> queue = new LinkedList<TTNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                root = queue.poll();

                if (root.left == null && root.right == null)
                    minSum = Math.min(root.sum, minSum);

                if(root.left != null)
                    queue.offer(root.left);

                if(root.right != null)
                    queue.offer(root.right);

            }


        }


        return minSum;
    }



    static int minPathSum = Integer.MAX_VALUE;
    public void buildTTree (TTNode root, ArrayList<ArrayList<Integer>> triangle, int level, int n) {

        if(root == null || level == n-1) {
            minPathSum = Math.min(root.sum, minPathSum);
            //System.out.print(root.sum + " ");
            return;
        }
        else {

            level++;
            TTNode left = new TTNode();
            left.sum = root.sum + triangle.get(level).get(root.index);
            left.index = root.index;


            TTNode right = new TTNode();
            right.sum = root.sum + triangle.get(level).get(root.index + 1);
            right.index = root.index + 1;

            root.left = left;
            root.right = right;

            buildTTree(left, triangle, level, n);
            buildTTree(right, triangle, level, n);

        }
    }

}


class TTNode {

    int sum;
    int index;
    TTNode left;
    TTNode right;

}









