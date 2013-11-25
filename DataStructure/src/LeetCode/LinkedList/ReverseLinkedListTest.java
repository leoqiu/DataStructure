package LeetCode.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/15/13
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinkedListTest {



    private ListNode reverse (ListNode head) {


        if (head == null || head.next == null)
            return head;

        ListNode nextNode = head.next;
        head.next = null;

        ListNode reverseRest = reverse(nextNode);

        nextNode.next = head;
        return reverseRest;
    }

    public void test (ListNode head) {

        ListNode start = reverse(head);
        System.out.print("");
    }

    public static void main (String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;



        ReverseLinkedListTest s = new ReverseLinkedListTest();
        s.test(n1);

    }

}
