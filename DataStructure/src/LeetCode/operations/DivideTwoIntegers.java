package LeetCode.operations;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 11/19/13
 *
 * http://oj.leetcode.com/problems/divide-two-integers/
 *
 */




public class DivideTwoIntegers {


    public long divide(long dividend, long divisor) {

        if(dividend == 0)
            return 0;

        long dividendAbs = Math.abs(dividend);
        long divisorAbs = Math.abs(divisor);

        long count = 0;
        while (dividendAbs >= divisorAbs) {

            long curLeftMoveTimes = 1;
            long curDivisorAbs = divisorAbs;

            while (dividendAbs >= curDivisorAbs) {
                curDivisorAbs = curDivisorAbs<<1;
                curLeftMoveTimes = curLeftMoveTimes<<1;
            }

            curLeftMoveTimes = curLeftMoveTimes>>1;
            curDivisorAbs = curDivisorAbs>>1;
            dividendAbs = dividendAbs - curDivisorAbs;
            count = count + curLeftMoveTimes;
        }

        if( (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) )
            return -count;

        if( (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) )
            return count;

        return count;
    }

    public static void main (String[] args) {

        long dividend = 2147483647;
        long divisor = 1;

        DivideTwoIntegers s = new DivideTwoIntegers();


        System.out.print(s.divide(dividend, divisor));

    }

}






















