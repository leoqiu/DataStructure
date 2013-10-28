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

       // return buildTree2(head, null);

        int len = 0;
        ListNode cur = head;
        while (cur != null) {

            len++;
            cur = cur.next;

        }

        return buildTree(head, len);

    }


    private TreeNode buildTree (ListNode head, int len) {

        if (head == null || len == 0)
            return null;
//        if (len == 1)
//            return new TreeNode(head.val);
        else {

            ListNode middle = head;
            int leftLen = len/2;
            int rightLen = len-leftLen-1;

            //find the current middle element of the list
            for (int i = 0; i < leftLen ; ++i)
                middle = middle.next;   //when i == 0; middle = middle.next which the second element

            TreeNode root = new TreeNode(middle.val);
  //System.out.println(root.val);
            root.left = buildTree(head, leftLen);
            root.right = buildTree(middle.next, rightLen);

            return root;
        }
    }


    private TreeNode buildTree2 (ListNode head, ListNode end) {

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
        int rootPos = (len-1)/2;

        if(rootPos == 0)
            return new TreeNode(cur.val);

        while (rootPos >= 0) {
            if(rootPos == 0)
                break;

            rootPos--;
            cur = cur.next;
        }

        TreeNode root = new TreeNode(cur.val);
System.out.println(root.val);
        root.left = buildTree2(head, cur);
        root.right = buildTree2(cur.next, end);

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
        ListNode l11 = new ListNode(11);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;


        ConvertSortedListBST s = new ConvertSortedListBST();
        System.out.println(s.sortedListToBST(l1).val);

    }

}


























