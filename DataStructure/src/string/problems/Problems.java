package string.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu


 */
public class Problems {


    private void printChars (char[] array) {

        for (int i = 0; i < array.length; i++) {

            if(array[i] != '\0')
                System.out.print(array[i]);
        }
        System.out.println();

    }

    /**
     *
     * problem #7 - reverse the string without using any temporary variable
     *
     *
     * @param
     */
    public void reverseString () {

        String str = "abcdef";

        int i = 0;
        int j = str.length() - 1;

        while ( i < j) {




        }
    }

    /**
     *
     * permutation of a string
     *
     * This one can not deal with duplicates
     *
     * @param
     */
    public void permutationInOrder (String prefix, String str) {

        int len = str.length();
        if(len == 0)
            System.out.println(prefix + " -- ");
        else {

            for (int i = 0; i < len; i++)
                permutationInOrder(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1));
        }
    }

    public void permutationInOrderNoDup (String prefix, String str) {

        int len = str.length();
        if(len == 0)
            System.out.println(prefix);
        else {

            for (int i = 0; i < len; i++) {
                String dup = str.charAt(i) + "";
                if(str.indexOf(dup, i+1) != -1)
                    continue;
                permutationInOrder(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1));
            }


        }
    }


    /**
     *
     * permutation string without duplicates
     *
     *
     * @param
     */
    private void swap (char[] array, int i, int j) {

        char temp = array[i];
        array[j] = array[i];
        array[i] = array[j];

    }

    /**
     *
     * ???????????????
     *
     * @param array
     * @param length
     */
    public void permutationNotInOrder (char[] array, int length) {

        if(length == 1) {
            System.out.println(array);
            return;
        }

        for (int i = 0; i < length; i++) {

            swap(array, 0, i);
            permutationNotInOrder(array, length-1);
            swap(array, 0, i);
        }

    }

    /**
     * combination of string
     *
     * @param prefix
     * @param str
     */
    public void combinationsString (String prefix, String str) {

        System.out.println(prefix);
        for (int i = 0; i < str.length(); i++)
            combinationsString(prefix + str.charAt(i), str.substring(i+1));

    }


    /**
     * problem #11 - remove adjacent duplicate chars, ABCCBCBA => ABBCBA => ACBA
     *
     * @param
     */
     public void removeAdjacentDupsBOOKWRONG () {

         char[] array = {'A', 'B', 'C', 'C', 'B', 'C', 'B', 'A', 'C', 'B', 'C', 'C', 'B'};

         System.out.println(array);

         int j = 0;
         for (int i = 1; i <= array.length; i++) {

             while ((array[i] == array[j]) && (j >= 0)) {
                 i++;
                 j--;
             }
             array[++j] = array[i];
         }

         System.out.println(array);
     }


    public void removeAdjacentDupsWrong () {

        char[] array = {'A', 'B', 'C', 'C', 'B', 'C', 'B', 'A', 'C', 'B', 'C', 'C', 'B'};
        printChars(array);

        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length -1; i++) {

            if (array[i] == array[i+1]) {

                start = i;
                end = i+1;
                while (array[start] == array[end]) {
                    end++;
                }

                cancelPair(array, start, end);

                if (start >= 0 && end < array.length) {
                    while (array[--start] == array[end] && start >= 0)
                        array[start] = '\0';

                    while (array[end] == array[++end])
                        array[end] = '\0';

                }

                i = end;
                start = 0;
                end = 0;
            }



        }
    }

    private void cancelPair (char[] array, int start, int end) {

        for (int i = start; i < end; i++) {
            array[i] = '\0';
        }
    }

    /**
     * PROBLEM #11 - Remove duplicate pair
     *
     *
     */
    public void removeAdjacentDups () {

        char[] array = {'A', 'B', 'C', 'C', 'B', 'C', 'B', 'A', 'C', 'B', 'C', 'C', 'B', 'C', 'A'};
        printChars(array);

        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length -1; i++) {

            if (array[i] == array[i+1]) {
                start = i;
                end = i+1;
                array[start] = '\0';
                array[end] = '\0';

                while (start > 0 && end < array.length -1 && array[--start] == array[++end]) {

                    array[start] = '\0';
                    array[end] = '\0';
                }

                i =  end -1;

            }

        }

        printChars(array);
    }

    /**
     *
     * problem #12 - sliding window, char[]
     *
     * find min sliding window
     *
     * AAB
     * {'A', 'B' , 'B', 'A', 'C', 'B', 'A', 'A'} => BAA , mim sliding window of size 3
     *
     * @param
     *
     */

    public void findMinSlidingWinBF () {

        char[] array = {'A', 'B' , 'B', 'A', 'C', 'B', 'A', 'A'};

        String str = "AAB";

        int countA = 0;
        int countB = 0;

        int start = -1;
        int end = -1;

        int minWinSize = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {

            int j = i;

            while (j < array.length) {
                if(array[j] == 'A')
                    countA++;
                if (array[j] == 'B')
                    countB++;

                if (countA >= 2 && countB >= 1) {


                    int currentSize = j - i + 1;
                    if (currentSize < minWinSize){
                        start = i;
                        end = j;
                        minWinSize = currentSize;
                    }

                    countA = 0;
                    countB = 0;
                    break;
                }

                j++;
            }
        }

        System.out.println("from [" + start + "] " + " to [" + end + "] and min window size is " + minWinSize);

    }


    ///////////////////////////////////////////


    private int getWinSize (HashMap<Character, Integer> hash) {

        Iterator it = hash.entrySet().iterator();
        int winSize = 0;

        while (it.hasNext()) {

            Map.Entry<Character, Integer> entry = (Map.Entry)it.next();
            int value = entry.getValue();
            winSize += value;
        }

        return winSize;

    }

    private boolean isAWin (HashMap<Character, Integer> hash) {

        boolean isAWin = false;

//        Iterator it = hash.keySet().iterator();
//
//        while (it.hasNext()) {
//
//            Map.Entry<Character, Integer> entry = (Map.Entry) it.next();
//
//
//        }

        int countA = -1;
        int countB = -1;

        if (hash.get('B') != null)
            countB = hash.get('B');

        if (hash.get('A') != null)
            countA = hash.get('A');

        if (countA >=2 && countB >= 1)
            isAWin = true;

        return isAWin;
    }

    private void removeElementFromHash (HashMap<Character, Integer> hash, char c) {

        if (hash.get(c) == 1) {
            hash.remove(c);
        } else {
            hash.put(c, (hash.get(c) - 1) );
        }

    }

    private void addElementToHash (HashMap<Character, Integer> hash, char c) {

        if (hash.get(c) == null)
            hash.put(c, 1);
        else
            hash.put(c, (hash.get(c) + 1) );
    }

    public void findMinSlidingWin () {

        //2 A, 1 B
        String str = "AAB";
        int winANum = 2;
        int winBNum = 1;

        int minWinStart = -1;
        int minWinEnd = -1;
        int minWinSize = Integer.MAX_VALUE;

        char[] array = {'A', 'B' , 'B', 'A', 'C', 'B', 'A', 'A'};

        int currentStart = 0;
        int currentEnd = 0;

        int winCount = 0;

        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

        while (currentEnd < array.length) {

            //add a element into hash
            addElementToHash(hash, array[currentEnd]);

            //find a window
            if(isAWin(hash)) {

                winCount++;

                int currentWinSize = getWinSize(hash);
                if (currentWinSize < minWinSize) {
                    minWinSize = currentWinSize;
                    minWinStart = currentStart;
                    minWinEnd = currentEnd;

                }

                //odd number window found, move currentStart forward one step
                if (winCount % 2 == 1) {
                    removeElementFromHash(hash, array[currentStart]);
                    currentStart++;
                } else {           //even number window found, move currentStart forward till POSSIBLE min size window found

                    while (isAWin(hash)) {
                        removeElementFromHash(hash, array[currentStart]);
                        currentStart++;
                        winCount++;

                    }

                    currentStart--;
                    addElementToHash(hash, array[currentStart]);

                    currentWinSize = getWinSize(hash);
                    if (currentWinSize < minWinSize) {
                        minWinSize = currentWinSize;
                        minWinStart = currentStart;
                        minWinEnd = currentEnd;

                    }
                }



            }


            currentEnd++;
        }


        System.out.print("Minimum window from [" + minWinStart + "] to [" + minWinEnd + "] and minimum window size is " + minWinSize);

    }














    public static void main (String[] args) {


        Problems p = new Problems();
        //p.permutationInOrder("", "aab");
        //p.permutationInOrderNoDup("", "aabc");
        char[] array = {'a', 'b', 'c'};
       // p.permutationNotInOrder(array, 3);
        //p.combinationsString( "" , "abc");
        //p.removeAdjacentDups();
        //p.removeAdjacentDups();
        //p.findMinSlidingWinBF();
        p.findMinSlidingWin();
    }



}


























































