package LeetCode.recaps;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 12/9/13
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class ReverseNodesKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k == 1)
            return head;

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode curPre = start;
        ListNode curHead = head;
        ListNode curTail = curPre;
        int curSteps = 0;

        while (curTail != null) {

            curSteps++;
            curTail = curTail.next;

            if(curSteps == k && curTail != null) {

                ListNode newHead = reverseList(curHead, curTail);
                curPre.next = newHead;
                curPre = curHead;
                curTail = curPre;
                curHead = curHead.next;

                curSteps = 0;
            }


        }

        return start.next;
    }


    private ListNode reverseList (ListNode head, ListNode tail) {

        if(head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode sec = head.next;
        first.next = tail.next;

        while (first != tail) {

            ListNode tmp = sec.next;
            sec.next = first;
            first = sec;
            sec = tmp;

        }

        return first;
    }


    public static void main (String[] args) {

        ReverseNodesKGroup s = new ReverseNodesKGroup();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;

        //s.reverseList(n1, n4);
        s.reverseKGroup(n1, 3);
    }



}
























