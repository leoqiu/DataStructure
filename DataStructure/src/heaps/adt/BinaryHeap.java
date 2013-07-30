package heaps.adt;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 7/29/13
 * Time: 4:04 PM
 *
 * Definition:
 *
 *
 */
public class BinaryHeap {

    //array as heap storage
    public int[] array;
    //
    public int count;
    //
    public int capacity;
    //heap type: 0 = min heap & 1 = max heap
    public int heapType;

    //constructor
    public BinaryHeap (int heapType, int capacity) {

        this.heapType = heapType;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    //return the ith element's parent
    public int parent (int i) {

        if (i <= 0 || i >= this.count)
            return -1;
        return (i-1) / 2 ;
    }

    // return the ith element's left child
    public int leftChild (int i) {

        int left = 2*i + 1;
        if (left >= this.count)
            return -1;
        return left;
    }

    //
    public int rightChild (int i) {

        // ....

        return 0;
    }

    //supposed this is a maximum heap
    //which is the 1st element in the array
    public int getMax () {

        if(this.count == 0)
            return -1;
        return this.array[0];
    }

    //percolate
    //swap small element from top to down
    //to place it at the right location
    public void percolateDown (int i) {

    }


    /**
     *
     * #1. copy the first element into some variable
     * #2. copy the last element into the first element location
     * #3. percolateDown the first element
     *
     * @return
     */
    public int deleteMax () {

        //...

        return 0;
    }

    /**
     * insert an element
     *
     * #1. increase the heap size
     * #2. keep the new element at the end of the heap
     * #3. heapify the element from bottom to top (root)
     *
     */

}




























