package LeetCode.LinkedList;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/24/13
 *
 *  http://oj.leetcode.com/problems/linked-list-cycle/
 *
 */




public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<ListNode>();

        while (true) {

            if (head == null)
                return false;

            if(set.contains(head) || head.next == head)
                break;

            set.add(head);
            head = head.next;

        }

        return false;
    }


    public boolean hasCycle2(ListNode head) {

        if(head == null)
            return false;

        ListNode one = head;
        ListNode two = head;

        while (true) {

            one = one.next;
            if(two.next != null)
                two = two.next.next;
            else
                two = two.next;

            if(one == null || two == null)
                return false;

            if (one.equals(two))
                return true;

        }
    }



}


















































