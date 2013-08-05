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
     * problem #11
     *
     * Median - https://en.wikipedia.org/wiki/Median
     *
     * @param args
     */



    public static void main (String[] args) {

        int[] array = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 1, 1, 1, 1, 84, 19, 5, 5, 5, 5, 5, 5, 33, 66, 5, 88, 88, 1, 1, 88, 88, 88, 88, 88, 88};

        int[] array1 = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 1, 1, 1, 1, 84, 19, 5, 5, 5, 5, 5, 5, 33, 66, 5, 88, 88, 1, 1, 88, 88, 88, 88, 88, 88};
        int[] array2 = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 1, 1, 1, 1, 84, 19, 5, 5, 5, 5, 5, 5, 33, 66, 5, 88, 88, 1, 1, 88, 88, 88, 88, 88, 88};
        SortProblem sp = new SortProblem();

        //sp.findTheMostOccurence(array);
        sp.findAElement(array1, array2, 95) ;

    }

}
