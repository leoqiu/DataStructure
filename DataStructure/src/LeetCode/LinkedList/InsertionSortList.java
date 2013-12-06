package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/25/13
 *
 *
 *
 */

public class InsertionSortList {



    public ListNode insertionSortList(ListNode head) {

        if (head == null)
            return head;

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode i = start;
        ListNode preJ = head;
        ListNode j = head.next;
        boolean isCurChanged = false;

        while (j != null) {

            while(!i.next.equals(j)) {
                if(i.next.val > j.val) {

                    preJ.next = j.next;
                    ListNode tmp = i.next;
                    i.next = j;
                    j.next = tmp;
                    j = preJ.next;
                    isCurChanged = true;
                    break;

                } else {
                    i = i.next;
                }
            }

            if(!isCurChanged) {
                preJ = preJ.next;
                j = j.next;
            } else
                isCurChanged = false;

            i = start;
        }

        return start.next;
    }


    public void insertionSortArr (int[] A) {

        for (int i = 1; i < A.length; i++) {
            int cur = A[i];
            for(int j = 0; j <i; j++) {
                if(A[j] > cur){
                    int k = i-1;
                    while (k >= j){
                        A[k+1] = A[k];
                        k--;
                    }
                    A[j] = cur;
                    break;
                }
            }
        }
    }


    public static void main (String[] args) {

        InsertionSortList s = new InsertionSortList();

        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

       // s.insertionSortList(n1);

        int[] A = {6,5,7,4,1,2,3};
        s.insertionSortArr(A);

    }






}


































