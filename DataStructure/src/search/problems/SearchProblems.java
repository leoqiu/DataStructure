package search.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/6/13
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchProblems {

    private void printArray (int[] array) {

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.println();
    }



    /**
     * problem #4  find duplicates in an array - negate array[original_array[i]]
     *
     *          #1. 0 < array[i] < n - 1
     *          #2. array[i] > 0
     *
     *
     * @param
     */
    public void findDuplicateNegate (int[] array) {



    }

    /**
     * problem #8 find maximum repetition of number in an array
     *
     */
    public void mostRepetition() {

        int[] array = {2, 3, 1 ,4 ,5 ,6 ,7 ,8, 9, 3, 2, 2, 11, 14, 12, 10,9, 16, 2};
        int n = array.length;
        int maxOccurence = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {

            int tempIndex = array[i] % n;
            array[tempIndex] = array[tempIndex] + n;
        }

        printArray(array);

        for (int i = 0; i < n; i++) {

            int currentOccurence = array[i] / n;
            if (maxOccurence < currentOccurence){
                maxOccurence = currentOccurence;
                index = i;
            }
        }

        System.out.print("maximum occurence is : " + index + " occur " + maxOccurence);

    }

    /**
     * problem #11 - find the first duplicate number, eg. {3, 2, 1, 2, 2, 3} => 3
     *
     * #1. brute force
     * #2, hash + negate
     *
     * @param
     */
    public void findFirstDup () {

        int[] array = {2, 3, 4, 5, 6, 4, 5, 6, 4, 5};
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {

            if (hash.containsKey(array[i]) && hash.get(array[i]) > 0)
                hash.put(array[i], -hash.get(array[i]));

            if (!hash.containsKey(array[i]))
                hash.put(array[i], i+1);

        }

        Iterator it = hash.entrySet().iterator();
        int maxMinusValue = -Integer.MAX_VALUE;
        int firstOccurrenceNum = 0;
        while (it.hasNext()) {

            Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
            int key = entry.getKey();
            int value = entry.getValue();

            if (value < 0) {
                if (value > maxMinusValue) {

                    maxMinusValue = value;
                    firstOccurrenceNum = key;
                }
            }
        }

        System.out.println("first firstOccurrenceNum : " + firstOccurrenceNum + " first occurence index is : " + (-maxMinusValue - 1));
    }


    /**
     * problem #14 - finding the missing number from an array - []
     *
     * nlgn
     */
    public void findMissingNumber () {

        int[] array = {2, 3, 4, 1, 5 ,10 ,8, 9, 7};

        Arrays.sort(array);
        int missingNum = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {

            int j = i + 1;

            if(j < array.length && (array[j] == array[i] + 2) ) {
                missingNum = array[i] + 1;
                break;
            }
        }

        System.out.print("missingNum is : " + missingNum);
    }

    /**
     *
     *   problem #14
     *
     *   hash
     *
     * @param
     */
    public void findMissingNumberHash () {

        int[] array = {2, 3, 4, 1, 5 ,10 ,8, 9, 7};
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            hash.put(array[i], 0);
        }

        Iterator it = hash.entrySet().iterator();
        int missingNum = -Integer.MAX_VALUE;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
            int key = entry.getKey();

            if(!hash.containsKey(key - 1)) {
                if (key > missingNum)
                    missingNum = key - 1;
            }
        }

        System.out.print("missingNum : " + missingNum + "  --- " + Integer.MIN_VALUE);

    }

    /**
     *
     * problem #18 - find number occurring odd number of times, {1,2,3,2,3,1,3} => 3
     *
     *
     * A XOR A = 0, then even time occurrence number will eventually become 0, the one left will be
     * the number occurs odd number of times
     *
     * @param
     */
    public void findOddOccurrence () {
        int[] array = {1,2,3,2,3,1,3};

        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = res^array[i];
            System.out.print(res + " ");
        }


        System.out.println();
        System.out.println(res);
    }

    /**
     * problem #21 - find 2 duplicate number from 1 - n+2, numbers range is [1, n]
     *
     * use a counting array size of n
     *
     * @param
     */
    public void findTwoDupsFromOneToN (){

        //input
        int[] array = {2, 1, 3, 4, 7, 6, 5, 9, 8 , 2, 5, 1};
        //output => 2 , 5

        int n = array.length;
        int[] countArr = new int[n-2];
        for (int i = 0; i < n; i++) {

            countArr[array[i]]++;
            if(countArr[array[i]] == 2)
                System.out.println(array[i]);

        }

    }

    /**
     * problem #24 array = {1, 1, 1, 2, 2, 2, 4, 4, 4, 3, 3, 3, 5, 5, 5, 6, 6, 7, 7, 7, 9, 9, 9, 10, 10, 10}, find 6 which occurs twice
     *
     * O(n) + O(1)
     *
     * a XOR a XOR a = a
     * a XOR a XOR a XOR a = 0
     *
     * @param
     */
    public void findElementOccurTwice () {

        int[] array = {1, 1, 1, 2, 2, 2, 4, 4, 4, 3, 3, 3, 5, 5, 5, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10};
        int[] array2 = {1, 1, 2, 2, 4, 4, 3, 3, 5, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};

        int n = 10;
        int res = 0;

        for (int i = 1; i <= n; i++) {
            res = res^i;
        }

        for (int i = 0; i < array.length; i++)
            res = res^array[i];

        System.out.println(res);

    }

    /**
     *
     * problem #31 - Two elements whose sum is closest to zero, array = {1, 60, -10, 70, -80, 85} => 80 and -85
     *
     * Sorting
     *
     * nlgn
     *
     * @param
     */
    public void findSumClosestToZero () {

        int[] array = {1, 60, -10, 70, -80, 85};

        Arrays.sort(array);
        int positiveClosest = Integer.MAX_VALUE;
        int negativeClosest = Integer.MIN_VALUE;

        int i = 0;
        int j = array.length - 1;

        int indexNeg1 = -1;
        int indexNeg2 = -1;

        int indexPos1 = -1;
        int indexPos2 = -1;

        while (i < j) {

            int sum = array[i] + array[j];

            if (sum > 0) {
                if (sum < positiveClosest){
                    positiveClosest = sum;
                    indexPos1 = i;
                    indexPos2 = j;
                }

                j--;

            }

            if (sum < 0) {
                if (sum > negativeClosest) {
                    negativeClosest = sum;
                    indexNeg1 = i;
                    indexNeg2 = j;
                }

                i++;
            }

            if (sum == 0)
                System.out.print(array[i] + " + " + array[j]);

        }

        if (positiveClosest*positiveClosest <= negativeClosest*negativeClosest)
            System.out.print(array[indexPos1] + " + " + array[indexPos2] + " = " + positiveClosest);
        else
            System.out.print(array[indexNeg1] + " + " + array[indexNeg2] + " = " + negativeClosest);

    }

    /**
     * problem #34 - find 3 elements that A[i] + A[j] + A[k] = K in an array
     *
     *
     * @param
     */
     public void findThreeElementsSumK () {

         int[] array = {2, 3, 4, 5, 3, 5, 7, 8, 1, 10, 22, 12, 61, 32, 29, 27 ,7};
         int sum = 89;

         Arrays.sort(array);

         for (int k = 0; k < array.length; k++) {

             int i = k+1;
             int j = array.length - 1;

             while (i < j) {

                 if (array[k] + array[i] + array[j] > sum) {
                     j--;
                 }

                 if (array[k] + array[i] + array[j] < sum) {
                     i++;
                 }

                 if (array[k] + array[i] + array[j] == sum) {

                     System.out.print(array[i] + " + " + array[j] + " + " + array[k]);
                     System.out.println();
                     break;
                 }

             }

         }

     }


    /**
     * Given an array of n integers, find 3 integers whose sum is closest to zero
     *
     * {2, 3, 4, 5, 3, 5, 7, 8, 1, 10, 22, -10, -18, -84, -22, 12, 61, 32, 29, 27 ,7} => -22 + 22 + 1 = 1
     *
     *
     * @param
     */
    public void findThreeElementsSumClosestToZero () {

        int[] array = {2, 3, 4, 5, 3, 5, 7, 8, 1, 10, 22, -10, -18, -84, -22, 12, 61, 32, 29, 27 ,7};
        Arrays.sort(array);

        int posMinSum = Integer.MAX_VALUE;
        int negMaxSum = Integer.MIN_VALUE;
        int indexNeg1 = -1;
        int indexNeg2 = -1;
        int indexNeg3 = -1;

        int indexPos1 = -1;
        int indexPos2 = -1;
        int indexPos3 = -1;

        boolean isDistanceZero = false;

        for (int k = 0; k < array.length; k++) {

            int i = k  + 1;
            int j = array.length - 1;

            while (i < j){

                int sum = array[i] + array[j] + array[k];

                if(sum > 0) {
                    if (sum < posMinSum) {
                        indexPos1 = i;
                        indexPos2 = j;
                        indexPos3 = k;
                        posMinSum = sum;
                    }
                    j--;
                }

                if(sum < 0) {
                    if (sum > negMaxSum) {

                        indexNeg1 = i;
                        indexNeg2 = j;
                        indexNeg3 = k;
                        negMaxSum = sum;
                    }

                    i++;
                }

                if (sum == 0) {
                    System.out.print(array[i] + " + " + array[j] + " + " + array[k] + " = " + sum);
                    System.out.println();
                    isDistanceZero = true;
                    break;
                }

            }
        }

        if(!isDistanceZero) {
            if (posMinSum*posMinSum < negMaxSum*negMaxSum)
                System.out.print(array[indexPos1] + " + " + array[indexPos2] + " + " + array[indexPos3] + " = " + posMinSum);
            else
                System.out.print(array[indexNeg1] + " + " + array[indexNeg2] + " + " + array[indexNeg3] + " = " + posMinSum);
        }

    }




    public static void main (String[] args) {

        SearchProblems sp = new SearchProblems();
        //sp.mostRepetition();
        //sp.findFirstDup();
        //sp.findMissingNumber();
        //sp.findMissingNumberHash();
        //sp.findOddOccurrence();
        //sp.findTwoDupsFromOneToN();
        //sp.findElementOccurTwice();
        //sp.findSumClosestToZero();
        //sp.findThreeElementsSumK();
        sp.findThreeElementsSumClosestToZero();



    }
}




































































