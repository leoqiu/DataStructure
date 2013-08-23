package COMPANY.amazon;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/21/13
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 *
 * A palindromic number or numeral palindrome is a number that remains the same when its digits are reversed. Like 16461
 *
 * recursion to reverse a linked list
 *
 * @param
 *
 *
 */
class LLNode {
    int num;
    LLNode next;

    public LLNode (int num, LLNode next) {
        this.num = num;
        this.next = next;
    }
}

public class IdentifyPalindrome {


    LLNode head = getListHead();

    private LLNode getListHead () {

        //initialize
        LLNode node10 = new LLNode(1, null);
        LLNode node9 = new LLNode(2, node10);
        LLNode node8 = new LLNode(3, node9);
        LLNode node7 = new LLNode(4, node8);
        LLNode node6 = new LLNode(5, node7);

        LLNode node5 = new LLNode(5, node6);
        LLNode node4 = new LLNode(4, node5);
        LLNode node3 = new LLNode(3, node4);
        LLNode node2 = new LLNode(2, node3);
        LLNode node1 = new LLNode(1, node2);

        return  node1;
    }

    private int getCurrentNode (int index) {

        LLNode myHead = head;

        while (index > 0) {
            index--;
            myHead = myHead.next;
        }

        int curNum = myHead.num;

        return curNum;
    }

    int index = 0;
    public void reverseLL (LLNode head) {

        boolean isPalindromic = true;


        if (head == null)
            return;
        else {
            reverseLL(head.next);
            System.out.print(head.num);
            int curNumR = head.num;
            int curNum = getCurrentNode(index++) ;
            if(curNum != curNumR)
                isPalindromic = false;

        }

        System.out.println(isPalindromic);

    }


    public static void main (String[] args) {

        IdentifyPalindrome ip = new IdentifyPalindrome();

        ip.reverseLL(ip.head);

    }

}











































