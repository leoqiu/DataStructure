package LeetCode.LinkedList;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/18/13
 *
 *
 *  http://oj.leetcode.com/problems/merge-k-sorted-lists/
 */



  class MListNode {
      int val;
    MListNode next;
    MListNode(int x) {
          val = x;
          next = null;
      }
  }


public class MergekSortedLists {

    public MListNode mergeKLists(ArrayList<MListNode> lists) {

        MListNode resHead = null;
        MListNode preNode = null;

        int whichList = 0;

        int loopTimes = 0;

        while (true) {

            int minVal = Integer.MAX_VALUE;
            int nullNum = 0;

            for (int i = 0; i < lists.size(); i++) {

                MListNode curHead = lists.get(i);

                if (curHead == null) {
                    nullNum++;
                    continue;
                }

                if (curHead.val < minVal) {
                    minVal = curHead.val;
                    whichList = i;
                }
            }

            loopTimes++;

            if(nullNum == lists.size())
                break;


            MListNode curNode = lists.get(whichList);
            lists.remove(whichList);
            lists.add(curNode.next);
            curNode.next = null;

            if(loopTimes ==  1) {
                resHead = curNode;
                preNode = curNode;
            } else {
                preNode.next = curNode;
                preNode = curNode;
            }

        }

        return resHead;

    }


    public MListNode mergeKListsTwo(ArrayList<MListNode> lists) {

        MListNode head = new MListNode(0);
        MListNode cur = head;

        while (true) {

            //every time minVal, nullNum will be reset to origin
            int minVal = Integer.MAX_VALUE;
            MListNode curMinNode = null;
            int nullNums = 0;

            for(int i = 0; i < lists.size(); i++) {

                MListNode curNode = lists.get(i);

                if(curNode == null) {
                    nullNums++;
                    continue;
                }

                if(curNode.val < minVal) {
                    minVal = curNode.val;
                    curMinNode = curNode;
                }
            }

            if(nullNums == lists.size())
                break;

            lists.remove(curMinNode);
            lists.add(curMinNode.next);

            cur.next = curMinNode;
            cur = cur.next;

        }
        return head.next;
    }


    public static void main (String[] args) {

//        MListNode l11 = new MListNode(1);
//        MListNode l12 = new MListNode(4);
//        MListNode l13 = new MListNode(7);
//        MListNode l14 = new MListNode(8);
//        MListNode l15 = new MListNode(10);
//        l11.next = l12;
//        l12.next = l13;
//        l13.next = l14;
//        l14.next = l15;
//
//        MListNode l21 = new MListNode(2);
//        MListNode l22 = new MListNode(6);
//        MListNode l23 = new MListNode(7);
//        MListNode l24 = new MListNode(9);
//        MListNode l25 = new MListNode(13);
//        l21.next = l22;
//        l22.next = l23;
//        l23.next = l24;
//        l24.next = l25;
//
//        MListNode l31 = new MListNode(-2);
//        MListNode l32 = new MListNode(0);
//        MListNode l33 = new MListNode(7);
//        MListNode l34 = new MListNode(19);
//        MListNode l35 = new MListNode(23);
//        l31.next = l32;
//        l32.next = l33;
//        l33.next = l34;
//        l34.next = l35;

//        lists.add(l11);
//        lists.add(l21);
//        lists.add(l31);

        ArrayList<MListNode> lists = new ArrayList<MListNode>();
        MListNode l111 = new MListNode(1);
        lists.add(l111);
        lists.add(null);

        MergekSortedLists s = new MergekSortedLists();
        //s.mergeKLists(lists);
        s.mergeKListsTwo(lists);
    }

}




























