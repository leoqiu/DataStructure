package LeetCode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/21/13
 *
 * http://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 *
 */


  class RListNode {
      int val;
    RListNode next;
    RListNode(int x) {
          val = x;
          next = null;
      }
  }



public class ReverseNodesKGroup {



    public RListNode reverseKGroup(RListNode head, int k) {


        if(head == null || k == 1)
            return head;

        int count = k;

        RListNode nextHead;
        RListNode curHead = head;
        RListNode newHead;
        RListNode finalHead = head;

        RListNode preEnd = null;

        int groupNum = 0;

        while (head != null) {

            count--;
            head = head.next;

            if (count == 0) {
                groupNum++;

                //reverse
                nextHead = head;
                newHead = reverse (curHead, nextHead);

                if(preEnd != null)
                    preEnd.next = newHead;

                //curHead.next
                preEnd = curHead;

                curHead = nextHead;

                count = k;

                if (groupNum == 1) {
                    finalHead = newHead;
                }


            }
        }

        return finalHead;
    }




    private RListNode reverse (RListNode head, RListNode end) {


        if (head == end || head.next == end)
            return head;

        RListNode nextNode = head.next;
        head.next = end;

        RListNode reverseRest = reverse(nextNode, end);

        nextNode.next = head;
        return reverseRest;
    }



    public RListNode reverseKGroup2(RListNode head, int k) {


        ArrayList<ArrayList<RListNode>> listOfLists = new ArrayList<ArrayList<RListNode>>();

        ArrayList<RListNode> list = new ArrayList<RListNode>();

        int count = k;

        RListNode newHead = null;

        while (head != null) {

            list.add(head);
            count--;
            head = head.next;

            if (count == 0) {
                ArrayList<RListNode> curList = new ArrayList<RListNode>(list);
                listOfLists.add(curList);
                list.clear();
                count = k;
            }

            if (head == null)
                listOfLists.add(list);
        }

        for (int i = 0; i < listOfLists.size(); i++) {

            ArrayList<RListNode> cur = listOfLists.get(i);
            for (int j = k-1; j>=0; j--) {

                if (i == 0 && j == 2)
                    newHead = cur.get(j);


            }

        }


        return newHead;
    }


    public static void main (String[] args) {

        RListNode n1 = new RListNode(1);
        RListNode n2 = new RListNode(2);
        RListNode n3 = new RListNode(3);
        RListNode n4 = new RListNode(4);
        RListNode n5 = new RListNode(5);
        RListNode n6 = new RListNode(6);
        RListNode n7 = new RListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;



        ReverseNodesKGroup s = new ReverseNodesKGroup();
        s.reverseKGroup(n1, 7);
        //s.reverse(n1, n3);
    }























}

























