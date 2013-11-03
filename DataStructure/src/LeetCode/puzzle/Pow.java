package LeetCode.puzzle;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 10/31/13
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pow {

    public double pow2(double x, int n) {

        double res = 1;

        for (int i = 1; i <= n; i++)
            res = res*x;

        return res;
    }


    public double powBinary(double x, int n) {

        if(n == 0)
            return 1;

        double binaryVal = powBinary(x, n/2);

        if(n%2 == 0)
            return binaryVal*binaryVal;
        else
            return binaryVal*binaryVal*x;

    }

    public double pow(double x, int n) {

        if(n < 0)
            return 1.0/powBinary(x, -n);
        else
            return powBinary(x, n);
    }

    public static void main (String[] args) {

        Pow s = new Pow();
        System.out.print(s.pow(2, 4));

    }

}
