package selectionalgorithms.problems;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 */



public class SelectionProblems {

    private void printArray (int[] array) {
        for (int m = 0; m < array.length; m++)
            System.out.print(array[m] + " ");
        System.out.println();
    }

    /**
     *
     * problem #5, {2, 3, 4, 5, 2, 1, 6, 8, 4, 6, 99, 2, 3, 4, 100, 8} => 99
     *
     *
     *
     */
     public void find2ndLargestElement () {

         int[] array = {2, 3, 4, 5, 2, 1, 6, 8, 4, 6, 99, 2, 3, 4, 100, 8};
         int n = array.length;





     }


    /**
     * problem #10 - find kth smallest number
     *
     * 4th smallest number
     * {2, 3, 4, 5, 2, 1, 6, 8, 4, 6, 99, 2, 3, 4, 100, 8} => 4
     *
     * running time: NlgK
     */

    public void findKthSmallestNumber (int[] array, int low, int high, int k) {

        int pivot;

        if (high > low) {
            pivot = partition(array, low, high);

            if (pivot   == k -1)
                System.out.println(array[pivot] + " : " + k);
            if (k -1 < pivot )
                findKthSmallestNumber(array, low, pivot-1, k);
            if (k - 1 > pivot )
                findKthSmallestNumber(array, pivot+1, high, k);
        }

    }

    public int partition (int[] array, int low, int high) {

        int pivot = array[low];

        int i = low;
        int j = high;

        while (i < j) {

            while (array[i] <= pivot)
                i++;

            while (array[j] > pivot)
                j--;

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        array[low] = array[j];
        array[j] = pivot;

        printArray(array);

        return j;

    }


    public void quickSort (int[] array, int low, int high) {

        int pivot;

        if (high > low) {
            pivot = partitionSub(array, low, high);
            quickSort(array, low, pivot-1);
            quickSort(array, pivot+1, high);
        }

    }

    public int partitionSub (int[] array, int low, int high) {

       // int pivotIndex = (high + low) / 2;
       // int pivot = array[pivotIndex];
        int pivot = array[low];

        int i = low;
        int j = high;

        while (i < j) {

            while (array[i] <= pivot)
                i++;

            while (array[j] > pivot)
                j--;

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        array[low] = array[j];
        array[j] = pivot;

        printArray(array);

        return j;

    }

    public int partitionSub2 (int[] array, int low, int high) {

        // int pivotIndex = (high + low) / 2;
        // int pivot = array[pivotIndex];
        int pivot = array[low];

        int i = low;
        int j = high;

        while (i < j) {

            while (array[i] <= pivot)
                i++;

            while (array[j] > pivot)
                j--;

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        array[low] = array[j];
        array[j] = pivot;

        printArray(array);

        return j;

    }


    public static void main (String[] args) {

        SelectionProblems sp = new SelectionProblems();
        int[] array =  {4, 5, 3, 2, 1, 7, 8, 14, 16, 15 , 10, 11, 12, 6, 9, 13};

        //int[] array =  {4, 5, 3, 2, 1, 7, 8, 14, 16, 15 , 10, 11, 12, 6, 9, 13};
        //int[] array =  {4, 5, 3, 2, 1, 7, 8, 14, 12, 15 , 10, 11, 12, 6, 9, 13};
        //int[] array =  {4, 5, 3, 2, 1, 7, 8, 16, 14, 15 , 10, 11, 12, 6, 9, 13};
        //sp.partition(array, 0, 15);
        //sp.findKthSmallestNumber(array, 0, 15, 4);
        sp.quickSort(array, 0, 15);
    }


}











































