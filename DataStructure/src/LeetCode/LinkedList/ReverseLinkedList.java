package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/15/13
 *
 *  http://oj.leetcode.com/problems/reverse-linked-list-ii/
 *
 */


public class ReverseLinkedList {


    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = start;
        int count = 0;

        ListNode leftNode = null;
        ListNode rightNode = null;

        ListNode pre = start;
        ListNode next = null;

        while (cur != null) {
            cur = cur.next;
            count++;

            if(count == m-1) {
                pre = cur;
            }

            if(count == m) {
                leftNode = cur;
            }

            if(count == n) {
                rightNode = cur;
            }

            if(count == n+1) {
                next = cur;
                break;
            }
        }

        ListNode tmp = reverse(leftNode, rightNode.next);
        rightNode = leftNode;
        leftNode = tmp;

        pre.next = leftNode;
        rightNode.next = next;

        return start.next;

    }

    private ListNode reverse (ListNode head, ListNode end) {


        if (head == end || head.next == end)
            return head;

        ListNode nextNode = head.next;
        head.next = end;

        ListNode reverseRest = reverse(nextNode, end);

        nextNode.next = head;
        return reverseRest;
    }

    public static void main (String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

//        ListNode n1 = new ListNode(5);

        ReverseLinkedList s = new ReverseLinkedList();
        s.reverseBetween(n1, 1, 4);

    }


}




















