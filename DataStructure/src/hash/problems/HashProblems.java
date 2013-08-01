package hash.problems;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 7/31/13
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class HashProblems {


    /**
     * problem #2 ~ #4 - Given an array of characters, give a algorithm for removing the duplicates
     *
     * @param
     */
    //O(n^2)
    public void removeDuplicate (int[] array) {

        int currentLen = array.length;
        //print before removing duplicates
        for(int i = 0; i < currentLen; i++)
            System.out.print (array[i] + " ");
        System.out.println();

        ///////////////////////////////////
        for(int i = 0; i < currentLen; i++){
            int current = array[i];
            for(int j = i + 1; j < currentLen;){
                if(current == array[j])
                    array[j] = array[--currentLen];
                else
                    j++;
            }

        }
        ///////////////////////////////////

        //print after removing duplicates
        for(int i = 0; i < currentLen; i++)
            System.out.print (array[i] + " ");
    }

    /**
     * #1. sort array nlgn
     * #2. iterate array to remove consecutive element which is duplicate, n
     *
     * n + nlgn = nlgn
     * space: n
     *
     * @param array
     */
    public void removeDuplicate2 (int[] array) {

        //nlgn
        Arrays.sort(array);
        for(int k = 0; k < array.length; k++)
            System.out.print (array[k] + " ");

        ArrayList<Integer> list = new ArrayList<Integer>();
        //
        int length = array.length;
        int current = array[0];
        list.add(current);
        for (int i = 1; i < length; i++) {

            if(current == array[i]){

            } else {
                current = array[i];
                list.add(current);
            }

        }

        System.out.println();
        System.out.print(list);

    }

    /**
     * ????
     *
     * @param array
     */
    public void removeDuplicate22 (int[] array) {

        Arrays.sort(array);

        int len = array.length;
        int currentLen = len;
        int current = array[0];
        int j = 0;
        for (int i = 0; i < len; i++) {

            if(current == array[i]){
                currentLen--;

            } else {
                j++;
            }

        }

    }

    /**
     *
     * ??????????????????
     *
     * @param array
     */
    public void removeDuplicate222 (int[] array) {

        Arrays.sort(array);

        int length = array.length;
        int tail = 1;
        int j;
        for (int i = 1; i < length; i++) {
            for (j = 0; j < tail; j++){
                if (array[i] == array[j])
                    break;
            }

            if(j == tail) {
                array[tail] = array[i];
                ++tail;
            }

        }

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " " );

    }

    /**
     * time : O(n)
     * space: O(n)
     *
     * @param array
     */
    public void removeDuplicate3 (int[] array) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i = 0; i < array.length; i++) {

            if(hash.containsKey(array[i]))
                ;
            else
                hash.put(array[i], 0);

        }

        Iterator it = hash.entrySet().iterator();
        while(it.hasNext()){

            Map.Entry<Integer, Integer> pairs = (Map.Entry) it.next();
            System.out.print(pairs.getKey() + " ");
        }

    }


    /**
     * problem #5 ~ 7: Given two arrays of unordered numbers, check both arrays have the same set of numbers
     *
     * @param array1
     * @param array2
     */
    public boolean compareTwoArray (int[] array1, int[] array2) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int length = array1.length;
        if (length != array2.length)
            return false;

        //O(n)
        for (int i = 0; i < length; i++) {
            if (hash.containsKey(array1[i]))
                hash.put(array1[i], hash.get(array1[i])+1);
            else
                hash.put(array1[i], 1);
        }

        //O(n)
        for (int i = 0; i < length; i++) {
            if (hash.containsKey(array2[i]))
                hash.put(array2[i], hash.get(array2[i])-1);
        }

        //O(n)
        Iterator it = hash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pairs = (Map.Entry) it.next();
            if(pairs.getValue() > 0)
                return false;
        }

        return true;


    }

    /**
     *
     */
    public void hashTest () {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        hash.put(1, 10);
        hash.put(1, 101);


        Iterator it = hash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pairs = (Map.Entry) it.next();
            System.out.println(pairs.getKey() + " - " + pairs.getValue());
        }

    }
    /**
     *
     */

    /**
     * problem #8 symmetric pairs {{1,3} {2,6} {3,5} {7,4} {3,5} {5,3} {8,7} {3,1} {6,2} {1,1}}
     *
     * @param
     */
    public void symmetricPairs () {

        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] a = new int[]{1, 3};
        list.add(a);
        int[] b = new int[]{2, 6};
        list.add(b);
        int[] c = new int[]{3, 5};
        list.add(c);
        int[] d = new int[]{7, 4};
        list.add(d);
        int[] e = new int[]{3, 5};
        list.add(e);
        int[] f = new int[]{5, 3};
        list.add(f);
        int[] g = new int[]{8, 7};
        list.add(g);
        int[] x = new int[]{9, 9};
        list.add(x);
        int[] h = new int[]{3, 1};
        list.add(h);
        int[] i = new int[]{6, 2};
        list.add(i);
        int[] y = new int[]{9, 9};
        list.add(y);
        int[] j = new int[]{1, 1};
        list.add(j);

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int n = 0; n < list.size(); n++){

            if(hash.containsKey(list.get(n)[1]) && (hash.get(list.get(n)[1]) == list.get(n)[0]))
                System.out.println("{"+ list.get(n)[0] + " " + list.get(n)[1] + "}");

            hash.put(list.get(n)[0], list.get(n)[1]);
        }


    }


    /**
     * problem #10 Find element repeated 3 times
     * @param
     */
    public void findRepeatThreeTimesElement (int[] array) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {

            if(hash.containsKey(array[i]))
                hash.put(array[i], (hash.get(array[i]) + 1) );
            else
                hash.put(array[i], 1);
        }

        Iterator it = hash.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            if(entry.getValue().equals(3))
                System.out.println(entry.getKey());

        }

    }


    /**
     * problem #12 Set A and Set B and a number K, one element from A and one element from B, add up to K
     *
     * @param
     */
    public void addUpToK () {

        int[] array1 = new int[]{1,2,3,4,5,6,7};
        int[] array2 = new int[]{8,9,11,32,12,33,19,21};
        int k = 40;

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        //supposed array1 length smaller than array2 length
        for (int i = 0; i < array1.length; i++)
            hash.put(array1[i], array1[i]);


        for (int i = 0; i < array2.length; i++) {
            int sub = k - array2[i];

            if(hash.containsKey(sub)){
                System.out.println(sub + " - " + array2[i]);
            }
        }
    }

    /**
     * problem #13 - Give an algo to remove the specified char from a given string which are given in another string
     *
     *
     * @param args
     */

    /**
     * problem #14. Give an algorithm for finding the 1st non-repeated character in a string. for example, the 1st
     * non-repeated character in the string "abzddab" is z
     *
     *
     * @param
     */
    public void findFirstNonRepeatedChar () {

        char[] array = new char[]{'a', 'b', 'z', 'd', 'd', 'a', 'b'};

        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

        //
        for(int i = 0; i < array.length; i++) {

            if(hash.containsKey(array[i]))
                hash.put(array[i], (hash.get(array[i]) + 1) );
            else
                hash.put(array[i], 1);

        }

        //
        for(int i = 0; i < array.length; i++) {

            if(hash.get(array[i]) == 1)   {
                System.out.println(array[i]);
                break;
            }

        }

    }

    /**
     * problem #15
     *
     *
     * @param args
     */


    public static void main (String args[]) {

        HashProblems hp = new HashProblems();

        // {2, 4, 6, 1, 22, 5, 8, 10}
        int[] array = new int[]{10, 2, 4, 6, 1, 22, 2, 5, 6, 8, 10};
        //hp.removeDuplicate(array);

        //hp.removeDuplicate2(array);
        //hp.removeDuplicate222(array);
        //hp.removeDuplicate3(array);

        int[] array1 = new int[]{10, 2, 4, 6, 1, 22, 2, 5, 6, 8, 10};
        int[] array2 = new int[]{10, 2, 4, 6, 1, 22, 2, 5, 6, 8, 10};
        //System.out.print(hp.compareTwoArray(array1, array2));

       // hp.hashTest();
        //hp.symmetricPairs();
        //int[] array3 = new int[]{10, 2, 4, 6, 1, 22, 2, 5, 6, 8, 10, 6, 2, 1, 4, 1, 5, 10};
        //hp.findRepeatThreeTimesElement(array3);

        //hp.addUpToK();

        hp.findFirstNonRepeatedChar();
    }
}


























