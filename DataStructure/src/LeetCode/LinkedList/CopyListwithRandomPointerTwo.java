package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/24/13
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */



public class CopyListwithRandomPointerTwo {


    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode cur = head;

        if(cur == null)
            return null;

        while (cur != null) {

            RandomListNode curCopy = new RandomListNode(cur.label);
            RandomListNode tmp = cur.next;
            cur.next = curCopy;
            curCopy.next = tmp;
            cur = tmp;
        }

        cur = head;

        while (cur != null) {

            if (cur.random == null)
                cur.next.random = null;
            else
                cur.next.random = cur.random.next;

            cur = cur.next.next;
        }

        RandomListNode headCopy = head.next;
        RandomListNode pre = head;
        cur = headCopy;

        while (cur.next != null) {

            pre.next = cur.next;
            cur.next = cur.next.next;

            pre = pre.next;
            cur = cur.next;

        }

        return headCopy;
    }

    public static void main (String[] arg) {

        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        RandomListNode n6 = new RandomListNode(6);
        RandomListNode n7 = new RandomListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;

        n1.random = null;
        n2.random = n4;
        n3.random = n1;
        n4.random = null;
        n5.random = n3;
        n6.random = null;
        n7.random = null;

        CopyListwithRandomPointerTwo s = new CopyListwithRandomPointerTwo();
        s.copyRandomList(n1);
    }
}
