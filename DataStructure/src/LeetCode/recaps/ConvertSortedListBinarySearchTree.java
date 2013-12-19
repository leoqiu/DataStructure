package LeetCode.recaps;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/10/13
 *
 * http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 */



public class ConvertSortedListBinarySearchTree {


    public TreeNode sortedListToBST(ListNode head) {

        ListNode cur = head;
        int len = 0;

        while (cur != null) {
            len++;
            cur = cur.next;
        }

        TreeNode root = buildTree(head, len);

        return root;
    }

    private TreeNode buildTree (ListNode head, int len) {

        if(head == null || len == 0)
            return null;
        else {

            ListNode mid = head;
            int leftLen = len/2;
            int rightLen = len - leftLen - 1;

            for (int i = 0; i < leftLen; i++)
                mid = mid.next;

            TreeNode root = new TreeNode(mid.val);

            root.left = buildTree(head, leftLen);
            root.right = buildTree(mid.next, rightLen);

            return root;

        }
    }

    public static void main (String[] args) {
        ConvertSortedListBinarySearchTree s = new ConvertSortedListBinarySearchTree();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        s.sortedListToBST(n1);

    }

}























