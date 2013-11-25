package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/3/13
 *
 *
 *
 */


public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;


        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (true) {

            if(l1 == null) {
                while (l2 != null) {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }

            if(l2 == null) {
                while (l1 != null) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }
            }

            if(l1 == null && l2 == null)
                return head.next;

            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
    }

    public static void main (String[] args) {

        MergeTwoSortedLists s = new MergeTwoSortedLists();
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(10);
        ListNode l15 = new ListNode(11);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(10);
        ListNode l25 = new ListNode(19);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;

        s.mergeTwoLists(l11, l21);
    }


}






















