package sort;

/**
 * Created with IntelliJ IDEA.
 * User: shqiu
 * Date: 8/2/13
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasicOperations {

    private void printArray (int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    /**
     * Bubble sort
     *
     * #1. every inner loop, will swap till the biggest number to the end
     *
     * @param array
     */
    public void bubbleSort (int[] array) {

        int length = array.length;

        for (int pass = length - 1; pass > 0; pass--) {
            for (int i = 0; i < pass ; i++) {
                if (array[i] > array[i+1]){

                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            printArray(array);
        }
    }

    /**
     * Optimzied bubble sort
     *
     * @param array
     */
    public void bubbleSortOptimized (int[] array) {

        boolean swapped = true;
        int j = 0;

        while (swapped) {

            //if the list already sorted, swapped will be false then end the while loop
            swapped = false;
            j++;

            //this inner loop for swapping
            for (int i = 0; i < array.length - j; i++) {

                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }

            }

        }
    }

    /**
     *
     * Selection sort
     *
     * @param array
     */
    public void selectionSort (int[] array) {

        int min;

        for (int i = 0; i < array.length; i++) {

            min = i;
            for (int j = i + 1; j < array.length; j++) {

                //System.out.println(i + "  --  " + min);
                if(array[j] < array[min])
                    min = j;

            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

        }

        printArray(array);
    }


    /**
     * Insertion sort
     *
     * @param array
     */
    public void insertionSort (int[] array) {

        int current;

        for (int i = 1; i < array.length; i++) {

            current = array[i];
            int j = i;

            //every while loop will sort sub-list
            //then insert current into the correct position
            //in the sub-list
            while (j > 0 && array[j-1] > current) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = current;

        }
        printArray(array);
    }

    /**
     * Merge sort reference - http://www.vogella.com/articles/JavaAlgorithmsMergesort/article.html
     *
     * #1. MergeSort is so called divided and conquer algorithm
     * #2. To split a collection into 2 parts
     * #3. The resulting collections are again recursively sorted via MergeSort algorithm
     * #4. Once the sorting process of the two collections is finished, the results of the two collections is combined
     *
     *
     * @param array
     */
    public void mergeSort (int[] array) {



    }


    /**
     * QuickSort reference - http://www.vogella.com/articles/JavaAlgorithmsQuicksort/article.html
     *
     *
     * #1. If the array contains only one element or zero elements then the array is sorted.
     * #2. If the array contains more then one element then:
     *      #1. Select an element from the array. This element is called the "pivot element". For example select the element in the middle of the array.
     *      #2. All elements which are smaller then the pivot element are placed in one array and all elements which are larger are placed in another array.
     *      #3. Sort both arrays by recursively applying QuickSort to them.
     *      #4. Combine the arrays
     *
     * QuickSort can be implemented to sort "in-place". This means that the sorting takes place in the array and that no additional array need to be created.
     *
     * @param array
     */
    public void quickSort (int[] array, int low, int high) {

        int pivotIndex;

        if (high > low) {
            pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex-1);
            quickSort(array, pivotIndex+1, high);
        }

    }

    private int partition(int[] array, int low, int high) {

        int left = low;
        int right = high;
        //choose the left most at the pivot
        int pivot = array[low];

        while (left < right) {

            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            while (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                //left++;
               // right--;
            }

        }

        //finally right is the pivot new position
        array[low] = array[right];
        array[right] = pivot;
        //return pivot new index
        return right;
    }





    public static void main (String[] args) {

        int[] array = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 84, 19, 5, 33, 66, 5, 88};

        BasicOperations bo = new BasicOperations();
        //bo.bubbleSort(array);
        //bo.selectionSort(array);

        //bo.insertionSort(array);
        bo.quickSort(array, 0, 17 );
        bo.printArray(array);
    }

}







































































