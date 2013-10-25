package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/24/13
 *
 * http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 */


public class ConvertSortedListBST{

    public TreeNode sortedListToBST(ListNode head) {

        return buildTree(head, null);

    }

    private TreeNode buildTree (ListNode head, ListNode end) {

        if (head == null)
            return null;

        if (head.next == end)
            return new TreeNode(head.val);

        ListNode cur = head;

        int len = 0;
        while (cur != end) {
            cur = cur.next;
            len++;
        }

        cur = head;
        int rootPos = len/2;

        while (rootPos >= 1) {

            if(rootPos == 1)
                break;

            rootPos--;
            cur = cur.next;
        }

        TreeNode root = new TreeNode(cur.val);

        root.left = buildTree(head, cur);
        root.right = buildTree(cur.next, end);

        return root;

    }


    public static void main (String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;


        ConvertSortedListBST s = new ConvertSortedListBST();
        s.sortedListToBST(l1);

    }

}


























