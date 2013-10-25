package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/22/13
 *
 *
 *  http://oj.leetcode.com/problems/recover-binary-search-tree/
 *
 */

public class RecoverBinarySearchTree{

    public void recoverTree2(TreeNode root) {

        if(root == null)
            return;
        else {

            TreeNode left = root.left;
            TreeNode right = root.right;

            if (left == null && right == null)
                return;
            else if (left == null || right == null) {

                if(left == null) {
                    if(right.val < root.val) {
                        int tmp = right.val;
                        right.val = root.val;
                        root.val = tmp;
                    }

                    recoverTree(right);
                }

                if(right == null) {
                    if(left.val > root.val) {
                        int tmp = left.val;
                        left.val = root.val;
                        root.val = tmp;
                    }

                    recoverTree(left);
                }

                return;
            } else {
                if(left.val > root.val && left.val < right.val) {
                    int tmp = left.val;
                    left.val = root.val;
                    root.val = tmp;
                }

                if(right.val < root.val && left.val < right.val) {
                    int tmp = right.val;
                    right.val = root.val;
                    root.val = tmp;
                }

                if(right.val < root.val && left.val < root.val) {
                    int tmp = right.val;
                    right.val = left.val;
                    left.val = tmp;
                }

                recoverTree(left);
                recoverTree(right);
            }

        }


    }

    public void recoverTree(TreeNode root) {

        if(root == null)
            return;
        else {

            TreeNode rootN = root;

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                root = queue.poll();


                recover(root);

                if(root.left != null)
                    queue.offer(root.left);

                if(root.right != null)
                    queue.offer(root.right);

            }

            System.out.print(2);

        }



    }

    private void recover (TreeNode root) {

        if ( (root.left != null && root.right == null) && root.val < root.left.val) {

            recover(root.left);
            int tmp = root.val;
            root.val = root.left.val;
            root.left.val = tmp;

        } else if ( (root.right != null && root.left == null) && root.val > root.right.val) {

            recover(root.right);
            int tmp = root.val;
            root.val = root.right.val;
            root.right.val = tmp;

        } else if (root.right != null && root.left != null) {

            int leftVal = Math.min(root.val, Math.min(root.left.val, root.right.val));
            int rightVal = Math.max(root.val, Math.max(root.left.val, root.right.val));
            int rootVal = root.val + root.left.val + root.right.val - leftVal - rightVal;

            if (root.val != rootVal || root.left.val != leftVal || root.right.val != rightVal) {
                recover(root.left);
                recover(root.right);
            } else
                return;

            root.val = rootVal;
            root.left.val = leftVal;
            root.right.val = rightVal;
        } else
            return;

    }


    public static void main (String[] args) {

        RecoverBinarySearchTree s = new RecoverBinarySearchTree();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        n1.right = n2;
        n2.left = n3;

        s.recoverTree(n1);


    }





    private boolean isMistakeFound (TreeNode root) {

        boolean isFound = false;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left == null && right == null)
            return isFound;
        else if (left == null && right != null) {
            //swap root and left
            if (root.val > right.val) {
                int tmp = right.val;
                right.val = root.val;
                root.val = tmp;
                isFound = true;
            }
        } else if (left != null && right == null) {
            if (root.val < left.val) {
                int tmp = left.val;
                left.val = root.val;
                root.val = tmp;
                isFound = true;
            }
        } else {
            //swap root and left
            if (root.val < left.val && root.val < right.val) {
                int tmp = left.val;
                left.val = root.val;
                root.val = tmp;
                isFound = true;
            }

            //swap root and right
            if (root.val > right.val && root.val > left.val) {
                int tmp = right.val;
                right.val = root.val;
                root.val = tmp;
                isFound = true;
            }

            //swap left and right
            if (left.val > right.val && root.val >= left.val) {
                int tmp = right.val;
                right.val = root.val;
                root.val = tmp;
                isFound = true;
            }
        }





        return isFound;
    }


}



















