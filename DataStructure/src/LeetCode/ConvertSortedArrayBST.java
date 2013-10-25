package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/24/13
 *
 * http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 */



public class ConvertSortedArrayBST {


    public TreeNode sortedArrayToBST(int[] num) {

        return buildBST(num, 0, num.length-1);

    }


    private TreeNode buildBST (int[] num, int low, int high) {


        if (low > high)
            return null;
        if (low == high)
            return new TreeNode(num[low]);
        else {

            int middle = (low+high) / 2;
            TreeNode root = new TreeNode(num[middle]);
            root.left = buildBST(num, low, middle-1);
            root.right = buildBST(num, middle+1, high);

            return root;
        }
    }



    public static void main (String[] args) {

        ConvertSortedArrayBST s = new ConvertSortedArrayBST();
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        s.sortedArrayToBST(num);
    }





}


















