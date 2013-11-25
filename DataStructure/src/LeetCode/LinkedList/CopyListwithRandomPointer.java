package LeetCode.LinkedList;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/23/13
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 *
 * http://oj.leetcode.com/problems/copy-list-with-random-pointer/
 *
 */


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}



public class CopyListwithRandomPointer {


    private int findRandomPos (RandomListNode head, RandomListNode rNode) {

        if(rNode == null)
            return -1;

        int count = 0;
        RandomListNode cur = head;

        while (cur != rNode) {
            cur = cur.next;
            count++;
        }

        return count;
    }

    private RandomListNode getRandom (int count, RandomListNode copyHead) {

        RandomListNode cur = copyHead;

        int step = 0;
        while (step != count) {
            cur = cur.next;
            step++;
        }

        return cur;
    }


    public RandomListNode copyRandomList(RandomListNode head) {

        if(head == null)
            return  null;

        ArrayList<Integer> poss = new ArrayList<Integer>();

        int pos = findRandomPos ( head,  head.random);
        poss.add(pos);

        RandomListNode cur = head.next;
        RandomListNode copyHead = new RandomListNode(head.label);
        RandomListNode preCopy = copyHead;

        while (cur != null) {

            poss.add(findRandomPos (head,  cur.random));

            RandomListNode curCopy = new RandomListNode(cur.label);
            preCopy.next = curCopy;
            preCopy = curCopy;

            cur = cur.next;

        }

        int count = 0;
        RandomListNode curC = copyHead;
        while (curC != null) {

            if(poss.get(count) == -1)
                curC.random = null;
            else {
                curC.random = getRandom (poss.get(count), copyHead);
            }

            curC = curC.next;
            count++;
        }

        return copyHead;

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

        CopyListwithRandomPointer s = new CopyListwithRandomPointer();
        s.copyRandomList(null);
    }


}


































