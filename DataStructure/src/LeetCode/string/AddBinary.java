package LeetCode.string;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/6/13
 *
 * http://oj.leetcode.com/problems/add-binary/
 *
 */


public class AddBinary {





    public String addBinary(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();

        char carry = '0';

        int i = lenA-1;
        int j = lenB-1;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {

            char curA = a.charAt(i);
            char curB = b.charAt(j);
            char curRes = '3';

            if(curA == '1' && curB == '1') {

                if (carry == '0')
                    curRes = '0';
                else if (carry == '1')
                    curRes = '1';
                carry = '1';
            } else if (curA == '1' || curB == '1') {
                if (carry == '0') {
                    curRes = '1';
                    carry = '0';
                } else if (carry == '1'){
                    curRes = '0';
                    carry = '1';
                }
            } else if (curA != '1' && curB != '1' ) {
                if (carry == '0')
                    curRes = '0';
                else if (carry == '1')
                    curRes = '1';
                carry = '0';

            }

            sb.append(curRes);
            i--;
            j--;
        }

        if(i == j) {
            if(carry == '1')
                sb.append(carry);
        } else if (i < j) {
            while (j >= 0) {

                char curB = b.charAt(j);
                if (curB == '0') {
                    if (carry == '0')
                        sb.append('0');
                    else if (carry == '1')
                        sb.append('1');
                    carry = '0';
                } else if (curB == '1') {
                    if (carry == '0') {
                        sb.append('1');
                        carry = '0';
                    } else if (carry == '1'){
                        sb.append('0');
                        carry = '1';
                    }

                }
                j--;

            }

            if(carry == '1')
                sb.append(carry);
        } else {
            while (i >= 0) {

                char curA = a.charAt(i);
                if (curA == '0') {
                    if (carry == '0')
                        sb.append('0');
                    else if (carry == '1')
                        sb.append('1');
                    carry = '0';
                } else if (curA == '1') {
                    if (carry == '0') {
                        sb.append('1');
                        carry = '0';
                    } else if (carry == '1'){
                        sb.append('0');
                        carry = '1';
                    }

                }

                i--;

            }
            if(carry == '1')
                sb.append(carry);
        }

         return sb.reverse().toString();
    }

    public static void main (String[] args) {

        String a = "1";
        String b = "1";


        AddBinary s = new AddBinary();
        System.out.print(s.addBinary(a, b));

    }

}








































