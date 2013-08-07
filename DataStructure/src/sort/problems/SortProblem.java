package sort.problems;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/2/13
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortProblem {


    private void printArray (int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    /**
     * problem #4. find the most occurence number in the array
     *
     *
     */
    public void findTheMostOccurence (int[] array) {

        Arrays.sort(array);
        int maxOccurence = 0;
        int currentOccurence = 0;
        int maxIndex = 0;

        for (int i = 0; i < array.length; ) {

            int j = i + 1;
            while (j < array.length && array[i] == array[j]) {
                j++;
                currentOccurence++;
            }

            if(maxOccurence < currentOccurence) {
                maxOccurence = currentOccurence;
                maxIndex = i;
            }

            i = j + 1;
            currentOccurence = 0;

        }

       System.out.print(array[maxIndex]);
    }

    /**
     * problem #9
     *
     * @param array1
     * @param array2
     * @param sum
     * @return
     */
    public int findAElement (int[] array1, int[] array2, int sum) {

        Arrays.sort(array1);

        for (int i = 0; i < array2.length; i++) {
            int sub = sum - array2[i];

            int index = Arrays.binarySearch(array1, sub);
            if (index >= 0) {
System.out.println(array1[index]);
System.out.println(array2[i]);
                return index;
            }

        }

        return -1;

    }

    /**
     *
     * problem #10
     *
     * @param
     */


    /**
     * problem #11 Given an array of n elements, can we output in sorted order the K elements
     * following the median in the sorted order in time O(n+klgk)
     *
     * Median - https://en.wikipedia.org/wiki/Median
     *
     * @param
     */
    public void kSortedElementsAfterMedian () {

        int[] array = {2, 3, 21, 1, 7, 27, 84, 19, 5, 1, 88};

        int median = getMedian(array);
        int i = 0;
        int j = array.length - 1;

        //O(n)
        while (i <= j) {

            while (array[i] < median) {
                i++;
            }

            while (array[j] > median) {
                j--;
            }

            if(i < j) {

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;

            }

        }
System.out.println(j);
printArray(array);

        int startIndex = -1;
        //O(n)
        for (int n = 0; n < array.length; n++) {

            if (array[n] >= median) {
                startIndex = n;
                break;
            }
        }

        //klgk
        //sortAlgorithm(array, n, n+k);

    }

    private int getMedian (int[] array) {

        int length = array.length;
        int median = Integer.MIN_VALUE;

        if(length % 2 == 0) {
            median = (array[length/2] + array[length/2 + 1]) / 2;

        }  else {
            median = array[(length + 1) / 2];
        }

        return median;
    }


    /**
     * problem #17 - input = {0, 1, 0, 2, 1, 0, 1, 2, 2}  => output = {0, 0, 0, 1, 1, 1, 2, 2, 2}
     *
     * use quicksort and use 1 as pivot, only one scan taking O(n) time and O(1) space
     *
     * @param
     */

    /**
     * problem #33 -  merge sorted list array1 with m+n space but only m elements and sorted list array2 with n spaces and n elements
     *
     */
    public void mergeTwoSortedArray () {


        int[] array1 = new int[15];
        array1[0] = 0;
        array1[1] = 3;
        array1[2] = 7;
        array1[3] = 8;
        array1[4] = 10;

        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};

        int i = 0;
        int j = 0;

        int m = 4;
        int n = 9;
        int count = array1.length;

        while (m >= 0 && n >= 0) {

            if(array2[n] > array1[m]){
                array1[--count] = array2[n];
                n--;
            } else {
                array1[--count] = array1[m];
                m--;
            }
        }

        printArray(array1);
    }


    /**
     * Nuts and Bolts, a set of n different nuts and a set of n bolts, only one to one unique mapping exists,
     * how to pair them
     *
     *
     * #1. select a nuts as pivot
     * #2. nuts are smaller than pivot nut on left group                  n
     * #3. nuts are greater than pivot nut on the right group            n
     * #4. traverse bolts find pivot bolt matches the pivot nut         n
     * #5. bolts smaller than pivot bolt on left group                     n
     * #6. bolts greater than pivot bolt on the right group                 n
     * #7 repeat #2 - #6                                                     lgn
     * nlgn
     *
     *
     * @param
     */




    public static void main (String[] args) {

        int[] array = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 1, 1, 1, 1, 84, 19, 5, 5, 5, 5, 5, 5, 33, 66, 5, 88, 88, 1, 1, 88, 88, 88, 88, 88, 88};

        int[] array1 = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 1, 1, 1, 1, 84, 19, 5, 5, 5, 5, 5, 5, 33, 66, 5, 88, 88, 1, 1, 88, 88, 88, 88, 88, 88};
        int[] array2 = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 1, 1, 1, 1, 84, 19, 5, 5, 5, 5, 5, 5, 33, 66, 5, 88, 88, 1, 1, 88, 88, 88, 88, 88, 88};
        SortProblem sp = new SortProblem();

        //sp.findTheMostOccurence(array);
        //sp.findAElement(array1, array2, 95) ;

        int[] array3 = {2, 3, 21, 1, 7, 27, 84, 19, 5, 1, 88};
        //sp.kSortedElementsAfterMedian();
        sp.mergeTwoSortedArray();
    }

}




















































