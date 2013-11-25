package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/13/13
 *
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 */


public class RemoveDupsSortedListTwo {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null)
            return null;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {

            if(cur.val == next.val) {
                cur = next;
                next = next.next;
            } else {

                //corner case, dup start from head
                if(pre.next != cur && pre.next == head){
                    pre = cur;
                    head = next;
                    cur = head;
                    next = next.next;
                } else if(pre.next != cur) {

                    pre.next = next;
                    cur.next = null;
                    cur = next;
                    next = next.next;
                //move 3 pointers tgt
                } else {
                    pre = cur;
                    cur = next;
                    next = next.next;
                }
            }
        }

        if(pre.next != cur && pre.next == head)
            return null;
        else if(pre.next != cur){
            pre.next = null;
        }

        return head;
    }


    public static void main (String[] args) {
        RemoveDupsSortedListTwo s = new RemoveDupsSortedListTwo();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(1);
//        ListNode n4 = new ListNode(1);
//        ListNode n5 = new ListNode(1);
//        ListNode n6 = new ListNode(3);
//        ListNode n7 = new ListNode(2);
//        ListNode n8 = new ListNode(2);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;

        s.deleteDuplicates(n1);

    }


}




















