package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/17/13
 *
 *
 * http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 */


  class ListNodeRL {
      int val;
    ListNodeRL next;
    ListNodeRL(int x) {
          val = x;
          next = null;
      }
 }



public class RemoveNthNodeFromEndList {

    public ListNodeRL removeNthFromEnd(ListNodeRL head, int n) {

        if (head == null )
            return null;

        int count = 0;
        ListNodeRL res = head;
        while (head != null) {
            count++;
            head = head.next;
        }

        if (n>count)
            return head;

        //if delete the first node
        int pre = count - n;
        if (pre == 0)
            return res.next;
        //if delete the first node

        int countS = 0;
        head = res;
        while (head != null) {

            countS++;

            if(countS == pre) {
                ListNodeRL temp = head.next;
                head.next = head.next.next;
                temp.next = null;
                break;
            }

            head = head.next;

        }

        return res;
    }

    public static void main (String[] args) {

        ListNodeRL n1 = new ListNodeRL(1);
        ListNodeRL n2 = new ListNodeRL(2);
        ListNodeRL n3 = new ListNodeRL(3);

        n1.next = n2;
        n2.next = n3;

        RemoveNthNodeFromEndList s = new RemoveNthNodeFromEndList();
        s.removeNthFromEnd(n1, 2);

    }

}




























