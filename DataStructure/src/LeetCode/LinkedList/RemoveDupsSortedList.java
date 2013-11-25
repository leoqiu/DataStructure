package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/12/13
 *
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 */




public class RemoveDupsSortedList {


    public ListNode deleteDuplicates(ListNode head) {

        if(head == null)
            return head;

        ListNode pre = head;
        ListNode next = head.next;

        while (next != null) {

            if(pre.val == next.val) {
                pre.next = next.next;
                next.next = null;
                next = pre.next;
            } else {
                pre = next;
                next = next.next;
            }
        }

        return head;
    }

    public static void main (String[] args) {

        //Given 1->2->3->4->5->NULL and k = 2,
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(2);
//        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        RemoveDupsSortedList s = new RemoveDupsSortedList();
        s.deleteDuplicates(n1);

    }



}















