package sort.problems;


/**
 * reference - http://code.google.com/p/kway/
 *
 *              {5, 10, 15, 20}
                {10, 13, 16, 19}
                {2, 19, 26, 40}
                {18, 22, 23, 24}

        2
    /       \
   2           5
 /   \       /   \
18     (2)    10     5

pop 2

        5
     /       \
   18          5
 /   \       /   \
18    <19> 19    10     (5)

 *
 *
 *
 *      Use a min heap for the minimum elements of each of the K lists. At each step we output the
 *      extracted minimum of the heap, and determine from which of the k lists it came and insert the next
 *      element from that list into the heap. Since we are using heap. that maximum depth of heap is logk
 *
 *
 *      nlgk - n lists and each list has k elements
 *
 *
 *
 *
 *
 */
public class KWaySort {


    /**
     * Give a algorithm for merging k-sorted lists
     *
     *
     */


}
