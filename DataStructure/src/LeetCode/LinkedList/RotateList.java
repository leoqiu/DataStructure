package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/3/13
 *
 *
 *
 */


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }


public class RotateList {

    public ListNode rotateRight2(ListNode head, int n) {

        if(head == null || n == 0 || head.next == null)
            return head;

        ListNode head1 = head;
        ListNode end1 = null;

        ListNode head2 = null;
        ListNode end2 = null;

        int totalNum = 0;
        ListNode cur = head;

        while (cur.next != null) {
           totalNum++;
           cur = cur.next;
        }
        totalNum++;

        if(totalNum == n)
            return head;

        end2 = cur;

        int times = totalNum - n;
        cur = head;

        //
        while (times > 1) {
            cur = cur.next;
            times--;
        }

        end1 = cur;
        head2 = cur.next;

        end1.next = null;
        end2.next = head1;


        return head2;

    }


    public ListNode rotateRight(ListNode head, int n) {

        if (head == null || n == 0)
            return head;

        ListNode cur = head;

        int len = 0;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        len++;
        cur.next = head;

        int rotateTimes = len - n%len;

        cur = head;
        while(rotateTimes > 0) {
            cur = cur.next;
            rotateTimes--;
        }

        head = cur;

        while (len > 1) {
            cur = cur.next;
            len--;
        }
        cur.next = null;

        return head;

    }

    public static void main (String[] args) {

        //RotateList
        //Given 1->2->3->4->5->NULL and k = 2,
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

          // {1}, 0
//        ListNode n1 = new ListNode(1);

        //{1}, 1

        //{1,2} , 0

        //{1,2}, 1
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;



        RotateList s = new RotateList();
        s.rotateRight(n1, 1);
    }


}


























