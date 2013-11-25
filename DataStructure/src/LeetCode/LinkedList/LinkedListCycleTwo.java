package LeetCode.LinkedList;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/24/13
 *
 *  http://oj.leetcode.com/problems/linked-list-cycle-ii/
 *
 */


public class LinkedListCycleTwo {

    public ListNode detectCycle(ListNode head) {

        if(head == null)
            return head;

        HashSet<ListNode> set = new HashSet<ListNode>();

        while (true) {

            if(head == null)
                return null;

            if(set.contains(head))
                return head;

            set.add(head);
            head = head.next;

        }
    }



}
