package LeetCode.ArrayIntegers;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/6/13
 *
 * http://oj.leetcode.com/problems/plus-one/
 *
 */



public class PlusOne {


    public int[] plusOne(int[] digits) {

        int n = digits.length;

        int res = (1 + digits[n-1]) % 10;
        int carry = (1 + digits[n-1]) / 10;
        digits[n-1] = res;

        for (int i = n-2; i >= 0; i--) {

            int curDigit = digits[i];
            int curRes = (curDigit+carry) % 10;
            carry =  (curDigit+carry) / 10;
            digits[i] = curRes;

        }

        int[] digitsCarry;
        if(carry == 1) {
            digitsCarry = new int[n+1];
            for (int i = n-1; i >= 0; i--) {
                digitsCarry[i+1] = digits[i];
            }
            digitsCarry[0] = carry;
            return digitsCarry;
        }


        return digits;
    }

    public static void main (String[] args) {

        int[] digits = {9};
        PlusOne s = new PlusOne();
        s.plusOne(digits);

    }


}
