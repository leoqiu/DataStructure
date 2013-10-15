package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 10/14/13
 *
 *
 * http://oj.leetcode.com/problems/add-two-numbers/
 *
 */


public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        int n = list1.size();
        int m = list2.size();
        int len = 0;

        if (m == n) {
          len = m;
        } else if (m > n) {
            for (int i = 0; i < (m - n); i++)
                list1.add(0);
            len = m;
        } else {
            for (int i = 0; i < (n - m); i++)
                list2.add(0);
            len = n;
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum = sum + list1.get(i) + list2.get(i);
            if (sum < 10) {
                res.add(sum);
                sum = 0;
            } else {
                res.add(sum - 10);
                sum = 1;
            }
        }

        if (sum == 1)
            res.add(1);


        int k = res.size();
        ListNode head = new ListNode(res.get(0));
        ListNode current = head;
        for (int i = 1; i < k; i++) {
            ListNode node = new ListNode(res.get(i));
            current.next = node;
            current = node;
        }

        return head;
    }


    public static void main (String[] args) {

        AddTwoNumbers s = new AddTwoNumbers();

        ListNode l1 = new ListNode(5);
//        ListNode l12 = new ListNode(8);
//       ListNode l13 = new ListNode(3);
//       l1.next = l12;
//        l12.next = l13;

        ListNode l2 = new ListNode(5);
//       ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l2.next = l22;
 //       l22.next = l23;


        s.addTwoNumbers(l1, l2);




    }

}




class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

