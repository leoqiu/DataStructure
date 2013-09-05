package company.amazon;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/20/13
 */
public class ProblemSetOne {


    /**
     *
     *
     * Given an array, with positive and negative integers, arrange it in such a way that, positive numbers
     * occupy even positions and negative numbers occupy odd position. All the remaining extra positive or
     * negative integers should be stored at the end of the array. Remember, the elements of the array should remain in the same order.
       EG: Input array {1,-2,3,-4,-5,-6,-7,8,9,4,10,11,12}
       output array {1,-2,3,-4,8,-5,9,-6,4,-7,10,11,12}
     */
    private void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }


     public void rearrangeArray () {

         int[] array = {1,-2,3,-4,-5,-6,-7,8,9,4,10,11,19,17,18};

         int currentPos = 0;
         int currentNeg = 0;

         boolean isRestAllNeg = false;

         printArray(array);

         while (currentPos < array.length && currentNeg < array.length) {

             //find current first positive number not in even position
             while (!(array[currentPos] > 0 && currentPos % 2 != 0) ) {
                 currentPos++;

                 //for part two
                 if ( !(currentPos < array.length) ) {
                     isRestAllNeg = true;
                     break;
                 }
             }

             while (!(array[currentNeg] < 0 && currentNeg % 2 == 0) ) {
                 currentNeg++;

                 //for part two
                 if ( !(currentNeg < array.length) ) {
                     isRestAllNeg = false;
                     break;
                 }
             }

             if (currentNeg < array.length && currentPos < array.length) {
                 int temp = array[currentPos];
                 array[currentPos] = array[currentNeg];
                 array[currentNeg] = temp;
             }

         }

         System.out.println(isRestAllNeg);

         //part two sort the rest all positives or negatives
         int startIndex = -1;
         int endIndex = -1;
         if (isRestAllNeg) {
             for (int i = 0; i < array.length; i++) {

                 //i is the last negative integer
                 if(array[i] < 0 && (i == array.length - 1))
                     break;

                 if (array[i] < 0 && array[i+1] < 0) {
                     startIndex = i;
                     endIndex = array.length - 1;
                     //sort (array, startIndex, endIndex); // nlgn
                 }
             }

         } else {
             for (int i = 0; i < array.length; i++) {

                 //i is the last negative integer
                 if(array[i] > 0 && (i == array.length - 1))
                     break;

                 if (array[i] > 0 && array[i+1] > 0) {
                     startIndex = i;
                     endIndex = array.length - 1;
                     //sort (array, startIndex, endIndex); // nlgn
                 }
             }

         }

         printArray(array);

     }


    /**
     * create a new array such that element at index "i" will be the element with highest frequency so far till i'th index in original array
     *
     * {1,2,3,6,1,3,6,7,3,9,4,2} -> Input
       {1,1,1,1,1,1,1,1,3,3,3,3} -> output should be
     *
     * @param
     */
    private int getCurrentMostFrequencyNumber (HashMap<Integer, Integer> hash) {
        int mostNum = 0;

        int currentFrequency = 0;
        Iterator it = hash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pairs = (Map.Entry) it.next();
            if(currentFrequency < pairs.getValue()) {
                currentFrequency = pairs.getValue();
                mostNum = pairs.getKey();
            }

        }

        return mostNum;
    }

    public void createFrequencyArray ( ) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        int[] input = {1,2,3,6,1,3,6,7,3,9,4,2};
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) {

            if (hash.containsKey(input[i])) {
                hash.put(input[i], hash.get(input[i]) + 1);
            } else {
                hash.put(input[i], 1);
            }

            int currentMost = getCurrentMostFrequencyNumber(hash);

            output[i] = currentMost;
        }

        printArray(output);
    }


    public void createFrequencyArray2 ( ) {

        int[] input = {1,2,3,6,1,3,6,7,3,9,4,2};
        int[] output = new int[input.length];
        int[] hash = new int[input.length];

        for (int i = 0; i < input.length; i++) {



        }

        printArray(output);
    }

    /**
     * Given 3 Arrays of integer sorted in ascending order, get the sum of minimum difference using one element from each array.
       where a, b, c are the elements from each array.
       diff = |a-b| + |b-c|+|c-a|
       worst case O(n)
     *
     *
     *
     * Given 3 Arrays of integer sorted in ascending order, get the sum of minimum difference using one element from each array.
     * The simple way has complexity O(n^3). However, we use the knowledge that, if a[i]=min(a[i],b[j],c[k]), then the best
     * possible step is i++. By doing this way, the complexity is O(n) or more exactly O(3n)
     */
    public void smallDistanceAmongThreeArray () {

        int a[]={1,2,13,15,18};
        int b[]={3,5,10,12,13};
        int c[]={2,4,6,12,13};


        int curA = 0;
        int curB = 0;
        int curC = 0;

        int finalA = 0;
        int finalB = 0;
        int finalC = 0;

        int minABS = Integer.MAX_VALUE;

        while (curA < a.length && curB < b.length && curC < c.length) {

            int curMinABC = Math.abs(a[curA] - b[curB]) + Math.abs(b[curB] - c[curC]) + Math.abs(c[curC] - a[curA]);

            if( curMinABC < minABS ) {
                minABS = curMinABC;
                finalA = curA;
                finalB = curB;
                finalC = curC;
            }

            //the best case
            if (curMinABC == 0)
                break;

            if (curA < a.length && a[curA] < b[curB] && a[curA] < c[curC]) {
                curA++;
            } else if (curB < b.length && b[curB] < a[curA] && b[curB] < c[curC]) {
                curB++;
            } else if (curC < c.length && c[curC] < a[curA] && c[curC] < a[curA]) {
                curC++;
            }
            else
                break;

        }
        System.out.println(finalA + " " + " " + finalB + " " + finalC);
        System.out.print(Math.abs(a[finalA] - b[finalB]) + Math.abs(b[finalB] - c[finalC]) + Math.abs(c[finalC] - a[finalA]));

    }


    /**
     *
     * "dsg((((asfda)))((()(((asfdsda)0s9df909((())"
     *
     * parenthesis matches or not
     *
     *
     * @param
     */
    public void parenthesisMatch () {

        String str = "(((asfda)))((()(((asfdsda)0s9df909((())";
        char[] charA = str.toCharArray();

        int cur = 0;
        int curFront = 0;
        int curBack = 0;

        int frontCount = 0;
        int backCount = 0;

        int n = charA.length;


        while (cur < n && curFront < n && curBack < n) {

            if (charA[cur] == '(') {

                curFront = cur;

                while (curFront < n && charA[curFront] == '(') {

                    frontCount++;
                }

            }




            cur++;
        }
    }

    /**
     *  parenthesisMatch easy version
     *
     *
     */
    public void parenthesisMatch2 () {

        String str = "(((asfda)))((()(((asfdsda)0s9df909((())";
        char[] charA = str.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        boolean isMatch = false;


        for (int i = 0; i < charA.length; i++) {

            char cur = charA[i];

            if (cur == '(')
                stack.push(cur);
            else if (cur == ')') {

                if(stack.isEmpty())
                    isMatch = false;
                else
                    stack.pop();

            }

        }

        if(stack.isEmpty())
            isMatch = true;
        else
            isMatch = false;

    }


    /**
     *  parenthesisMatch hard version
     *
     *  "{}{}[[]]()[(){}[](((}}{)({}}}}"
     *
     */


    /**
     * Input is a NxN matrix which contains only 0′s and 1′s. The condition is no 1 will occur in a row after 0. Find the index of the row which contains maximum number of zeros.
     Example: lets say 5×5 matrix

     1 0 0 0 0
     1 1 0 0 0
     1 1 1 1 1
     0 0 0 0 0
     1 1 1 0 0

     For this input answer is 4th row.
     solution should have time complexity less than N^2
     *
     * @param
     */
    public void lineHasMaxZeros () {

        int[] arr1 = {1, 0, 0, 0, 0};
        int[] arr2 = {1, 1, 1, 1, 0};
        int[] arr3 = {1, 1, 1, 1, 1};
        int[] arr4 = {0, 0, 0, 0, 0};
        int[] arr5 = {1, 1, 1, 0, 0};

        int[][] array = {arr1, arr2, arr3, arr4, arr5};
        int curLastOnePos = -1;
        int lastOnePosMaxZero = Integer.MAX_VALUE;
        int numOfArrayHasMostZero = -1;

//System.out.print(binarySearch1(arr1));
//System.out.print(binarySearch2(arr1, 0, 4));

        //nlgn
        for (int i = 0; i < array.length; i++) {

            //curLastOnePos = binarySearch1(array[i]);
            curLastOnePos = binarySearch2(array[i], 0, array[i].length - 1);

            if (curLastOnePos < lastOnePosMaxZero) {
                lastOnePosMaxZero = curLastOnePos;
                numOfArrayHasMostZero = i;
            }
        }

        System.out.print(numOfArrayHasMostZero + 1);
    }

    //iterative version
    private int binarySearch1 (int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        if(arr == null)
            return Integer.MIN_VALUE;
        else if (arr[0] == 0)
            return -1;
        else if (arr[arr.length-1] == 1)
            return arr.length-1;
        else {

            while (low < high) {

                mid = low + (high - low) /2;

                if (arr[mid] == 1)
                    low = mid;

                if (arr[mid] == 0)
                    high = mid;

                if (arr[mid] == 1 && arr[mid+1] == 0)
                    return mid;

            }
        }

        return -1;
    }


    //recursive
    //return number of 1's
    private int binarySearch2 (int[] arr, int low, int high) {

        if (arr == null)
            return Integer.MAX_VALUE;
        else if (arr[low] == 0)
            return 0;
        else if (arr[high] == 1)
            return Integer.MAX_VALUE;
        else {

            int mid = low + (high - low) / 2;

            //check return condition before recursive call
            if (arr[mid] == 1 && arr[mid+1] == 0)
                return mid+1;

            if (arr[mid] == 1)
                return binarySearch2(arr, mid, high);

            if (arr[mid] == 0)
                return binarySearch2(arr, low, mid);

        }

        return -1;
    }


    /**
     *
     * Give an array of integers, which are in repeated format except one integer, write a function to return that integer
        ex[2,2,3,3,4,4,4,5,5] = 4
        [2,2,2,3,3,3,3,4,4,4] = 3
     *
     *
     * @param
     */
     public void diffRepeatPattern () {

         int[] array = {2,2,3,3,4,4,4,5,5,6,6,7,7,8,8};

         HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

         for (int i = 0; i < array.length; i++){
             if(hash.containsKey(array[i]))
                hash.put(array[i], hash.get(array[i]) + 1);
             else
                 hash.put(array[i], 1);
         }





         /*

         int curRepeatTimes = -1;
         int preRepeatTimes = -1;

         int key1 = Integer.MIN_VALUE;
         int times1 = -1;
         int key2 = Integer.MIN_VALUE;
         int times2 = -1;

         Iterator it = hash.entrySet().iterator();
         while (it.hasNext()) {
             Map.Entry<Integer, Integer> entry =  (Map.Entry<Integer, Integer>) it.next();
             curRepeatTimes = entry.getValue();

             if (preRepeatTimes == -1){
                 preRepeatTimes = curRepeatTimes;
                 key1 = entry.getKey();
                 times1 = curRepeatTimes;
             }else if (preRepeatTimes == curRepeatTimes) {
                 preRepeatTimes = curRepeatTimes;
             } else if (preRepeatTimes != curRepeatTimes) {
                 key2 = entry.getKey();
                 times2 = curRepeatTimes;
                 break;
             }
         }

         int occurTime1 = 0;
         int occurTime2 = 0;
         while (it.hasNext()) {

             Map.Entry<Integer, Integer> entry =  (Map.Entry<Integer, Integer>) it.next();
             curRepeatTimes = entry.getValue();

             if(curRepeatTimes == times1)
                 occurTime1++;

             if(curRepeatTimes == times2)
                 occurTime2++;

             if(occurTime2 > 1) {
                 System.out.print(key1);
                 break;
             } else {
                 System.out.print(key2);
                 break;
             }
         }   */
     }













    public static void main (String[] args) {
        ProblemSetOne pso = new ProblemSetOne();
        //pso.rearrangeArray();
        //pso.createFrequencyArray();
        //pso.smallDistanceAmongThreeArray();
        //pso.lineHasMaxZeros();
        pso.diffRepeatPattern();
    }

}































































