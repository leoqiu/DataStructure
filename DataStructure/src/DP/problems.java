package DP;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/14/13
 */


import java.util.ArrayList;

/**
 * Dynamic programming = recursion + memorization
 *
 *
 */




public class problems {


    /**
     * problem #3
     *
     *
     * @param
     */
    public int tR (int n) {
        int sum = 0;

        if(n==0 || n==1)
            return 2;
        for (int i = 1; i < n; i++)
            sum += 2 * tR(i) * tR(i-1);

        return sum;
    }


    public int tDP(int n) {
        int t0 = 2;
        int t1 = 2;
        int t2 = 2 * t0 * t1;

        //extra table for memorization
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(t0);
        list.add(t1);
        list.add(t2);

        int ti = 0;

        for (int i = 3; i <= n; i++) {

            ti = 2 * list.get(i-1) * list.get(i-2);
            list.add(ti);

        }

        int tn = 0;
        for (int i = 0; i < list.size(); i++) {
            tn += list.get(i);
        }

        return tn;

    }







    public static void main (String[] args) {

        problems p = new problems();
        System.out.println(p.tDP(3));
        System.out.println(p.tR(3));

    }




}
















































