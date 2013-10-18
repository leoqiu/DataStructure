package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/18/13
 *
 * http://oj.leetcode.com/problems/swap-nodes-in-pairs/
 *
 */



public class SwapNodesPairs {


    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode sec = first.next;
        ListNode res = sec;
        ListNode pre;

        while (true) {

            ListNode tmp = sec.next;
            sec.next = first;
            first.next = tmp;
            pre = first;

            first = first.next;

            if(first == null)
                break;

            sec = first.next;

            if(sec == null)
                break;

            pre.next = sec;
        }


        return res;


    }


}
