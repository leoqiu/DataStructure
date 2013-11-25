package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/14/13
 *
 *
 *
 */


public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        if(head == null)
            return null;

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode n1 = start;
        ListNode n2 = start.next;

        while (n2 != null && n2.val < x) {
            n1 = n2;
            n2 = n2.next;
        }

        ListNode pre = n1;

        while (n2 != null) {

            if(n2.val < x) {
                n1.next = n2.next;
                n2.next = null;
                n2.next = pre.next;
                pre.next = n2;
                n2 = n1.next;
                pre = pre.next;
            } else {
                n1 = n2;
                n2 = n2.next;
            }
        }

        return start.next;
    }

    public static void main (String[] args) {
        PartitionList s = new PartitionList();
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(4);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(2);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        n1.next = n2;

        s.partition(n1, 2);

    }


}
