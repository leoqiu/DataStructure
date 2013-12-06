package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/25/13
 *
 * http://oj.leetcode.com/problems/reorder-list/
 *
 */

/*

目前想到的解法是，分三步来做：

1. 找出中间节点

2. 把中间节点之后的后半部分链表反序

3. 把前半部分链表及后半部分链表合并

 */


public class ReorderList {


    public void reorderList(ListNode head) {

        if(head == null)
            return;

        //find the median node
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            fast = fast.next;
            if(fast == null)
                break;
            fast = fast.next;
            if(fast == null)
                break;
            slow = slow.next;
        }

System.out.print("debug 1");
        //reverse the 2nd half list
        ListNode cur = slow;
        ListNode pre = slow.next;
        cur.next = null;

        while (pre != null) {
            ListNode tmp = pre;
            pre = pre.next;
            tmp.next = cur;
            cur = tmp;
        }

System.out.print("debug 2");

        //merge two lists
        ListNode first = head;
        ListNode sec = cur;

        while (first != null && sec != null && first != sec) {

            ListNode tmp = sec;
            sec = sec.next;
            tmp.next = first.next;
            first.next = tmp;
            first = tmp.next;
        }

System.out.print("debug 2");

    }

    public static void main (String[] args) {

        ReorderList s = new ReorderList();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;


//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        n1.next = n2;
//        n2.next = n3;

        s.reorderList(n1);
    }


}





































