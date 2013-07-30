package heaps.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 7/29/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapProblem {


    /**
     * problem #7. Given a min-heap, find the maximum element
     *
     * #1. for a min heap the max element will always be a leaf, means how to find the max leaf
     * #2. the next node of the last node's parent will be the first leaf node, then find the index of it (h.count - 1) / 2 + 1
     */

    /**
     * problem #21. Given a big file containing billions of numbers. how do we find  maximum 10 numbers from those files
     *
     * #1. Always remember that when we are asked about these types of questions where need to find max n elements
     * best data structure to use it priority queue
     *
     */

    /**
     * problem #22. Merge k sorted lists with total of n elements: we are given k sorted lists with total n inputs
     * in all the lists. Given an algorithm to merge them into one single sorted, suppose this is a ascending order
     *
     *
     * #1. Read all 1st elements (the smallest element in the list) from k lists and build a heap k*lgk
     * #2. delMin from this heap and put each element into a queue or linked list k
     * #3. repeat #1 & #2 to all 2nd elements from k lists k*lgk + k
     * #4. finish all k lists time cost is n*lgk + n = n*lgk, space complexity is k
     *
     */

    /**
     * problem #27. Dynamic median finding. Design a heap data structure that supports finding the median
     *
     * Median: In a set of n elements, median is the middle element, such that the number of elements smaller than
     * than the median is equal to the number of elements larger thant the median
     *
     *
     */

    /**
     * problem #28. sliding window problems.
     *       window position              max
     * #1. [1 3 -1] -3 5 3 6 7             3
     * #2. 1 [3 -1 -3] 5 3 6 7             3
     * #3. 1 3 [-1 -3 5] 3 6 7             5
     * #4. 1 3 -1 [-3 5 3] 6 7             5
     * #5. 1 3 -1 -3 [5 3 6] 7             6
     * #6. 1 3 -1 -3 5 [3 6 7]             7
     *
     */
      public void slidingWindow (int array[], int w) {

          int winAccount = 0;
          int max = Integer.MIN_VALUE;

          int i = 0;
          int j = 0;
          while ( (i + w) <= array.length) {

              while (j < w) {
                  if(array[i+j] > max)
                      max = array[i+j];
                  j++;
              }

              j = 0;
              System.out.println(max);
              i++;

          }

      }

    class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 < o2)
                return 1;
            if (o1 > o2)
                return -1;
            return 0;

        }
    }

    public void slidingWindowHeap (int array[], int w) {


        Comparator<Integer> comparator = new IntegerComparator();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(10, comparator);

        heap.add(array[0]);
        heap.add(array[1]);
        heap.add(array[2]);
        System.out.println(heap.peek());
        heap.remove(array[0]);

        //time complexity n*lgw
        for (int i = 1; i <= (array.length - w); i++) {

            heap.add(array[i+w-1]);
            System.out.println(heap.peek());
            heap.remove(array[i]);

        }

    }




    public static void main (String args[]) {

        HeapProblem hp = new HeapProblem();
        int[] array = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        //hp.slidingWindow(array, 3);

       hp.slidingWindowHeap(array, 3);
    }


}













































