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
        for (int i = 1; i < n; i++) {
            sum += 2 * tR(i) * tR(i-1);
            //System.out.println(sum);
        }


        return sum;
    }


    public int tDP(int n) {
        int t0 = 2;
        int t1 = 2;
        int t2 = 2 * t0 * t1;

        //extra table for memorization to record every sub-sum
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(t0);         //2
        list.add(t1);         //2
        list.add(t2);         //8

        int ti = 0;

        //from index 3 to calculate cuz already add 3 elements
        for (int i = 3; i <= n; i++) {

            //ti = 2 * (list.get(i-1) + list.get(i-2) )* list.get(i-2);
            ti = list.get(i-1) + 2 * list.get(i-1) * list.get(i-2);
            list.add(ti);

        }

//        int tn = 0;
//        for (int i = 2; i < list.size(); i++) {
//            tn += list.get(i);
//        }

        return list.get(list.size() - 1);

    }


    /**
     *
     * problem #4 - Maximum value contiguous subsequence: {-2, 11, -4, 13, -5, 2} => 20
     *                                                    {1, -3, 4, -2, -1, 6}  => 7
     *
     *
     * @running time O(n^2)
     */
    public void findMaxContiguousSum () {

        int[] array = {-2, 11, -4, 13, -5, 2};
        int maxSum = Integer.MIN_VALUE;
        int maxSumStartIndex = -1;
        int maxSumEndIndex = -1;

        for (int i = 0; i < array.length; i++) {

            int currentSum = 0;

            for (int j = i; j < array.length; j++) {

                currentSum += array[j];
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumStartIndex = i;
                    maxSumEndIndex = j;
                }

            }
        }

        System.out.print("Max subsequence of sum is from [" + maxSumStartIndex + "] to [" + maxSumEndIndex + "] = " + maxSum);

    }

    /**
     *  problem #4
     * accumulate only the sum is positive, otherwise set sumStartHere to 0
     *
     */
    public void findMaxContiguousSum2 () {

        int[] array = {-2, 11, -4, 13, -19, 2};

        int maxSum = Integer.MIN_VALUE;
        int sumStartHere = 0;

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < array.length; i++){

            sumStartHere = sumStartHere + array[i];
            if(sumStartHere < 0){
                startIndex = i + 1;
                sumStartHere = 0;
                continue;
            }

            if(maxSum < sumStartHere) {

                endIndex = i;
                maxSum = sumStartHere;
            }

        }

        System.out.print("Max subsequence of sum is from [" + startIndex + "] to [" + endIndex + "] = " + maxSum);

    }

    /**
     *
     * problem #4
     */
    public void findMaxContiguousSumDP () {

        //int[] array = {-2, 6, -6, 23, 11, -4, 13, -19, 2};
        int[] array = {-2, -6, -6, -23, -11, -4, -13, -19, -2};

        int[] m = new int[array.length];

        int maxSumStart = 0;
        int maxSumEnd = 0;
        int maxSum = Integer.MIN_VALUE;

        if(array[0] > 0)
            m[0] = array[0];
        else {
            //special case, when the first element is negative
            maxSumStart = 1;
            m[0] = 0;
        }

       for (int i = 1; i < array.length; i++) {
           if(m[i-1] + array[i] > 0 )
               m[i] = m[i-1] + array[i];
           else {
               m[i] = 0;
               maxSumStart = i+1;
           }
       }

       for (int i = 0; i < array.length; i++)
           if (m[i] > maxSum) {
               maxSum = m[i];
               maxSumEnd = i;
           }
        System.out.print("Max subsequence of sum is from [" + maxSumStart + "] to [" + maxSumEnd + "] = " + maxSum);

    }

    /**
     * problem #4 - if we can not select two contiguous numbers
     *
     * @param
     */
     public void findMaxSumNoContiguousNumbers () {

         int[] array = {-2, 6, -6, 23, 11, -4, 13, -19, 2};
         int[] m = new int[array.length];

         int maxSum = Integer.MIN_VALUE;
         int startIndex = 0;

         //find the start Index, the first positive number
         for (int i = 0; i < array.length; i++) {
             if(array[i] > 0) {
                 m[0] = array[i];
                 startIndex = i;
                 break;
             }
         }

         int mIndex = 0;
         int nextJ = 0;
         for (int j = startIndex + 2; j < array.length; j = nextJ) {

             mIndex++;

             //special case
             if( j == (array.length -1) && array[j] > 0 ) {
                 m[mIndex] =  m[mIndex-1] + array[j];
                 break;
             }

             if(array[j] > array[j+1]) {
                 if( (m[mIndex-1] + array[j]) > 0 ) {
                     m[mIndex] =  m[mIndex-1] + array[j];
                 } else {
                     m[mIndex] = 0;
                 }

                 nextJ = j+2;
             } else {
                 if ((m[mIndex-1] + array[j+1]) > 0 ) {
                     m[mIndex] =  m[mIndex-1] + array[j+1];
                 }  else {
                     m[mIndex] = 0;
                 }

                 nextJ =j+1+2;
             }
         }

        for (int i = 0; i < m.length; i++) {
            if(m[i] > maxSum)
                maxSum = m[i];
        }

         System.out.print(maxSum);
     }








    public static void main (String[] args) {

        problems p = new problems();
        //System.out.println(p.tDP(6));
        //System.out.println(p.tR(6));
        //p.findMaxContiguousSum();
        //p.findMaxContiguousSum2();
        //p.findMaxContiguousSumDP();
        p.findMaxSumNoContiguousNumbers();


    }




}
















































