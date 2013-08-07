package sort;


public class Quicksort  {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // Check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];
        //int pivot = numbers[low];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }

        System.out.print("pivot : " + pivot + " | " + " - j: " + j + " | " );
        for (int k = low; k <= high; k++) {
            System.out.print( numbers[k] + " ");
        }
        System.out.println();

        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);


    }





    public static void main (String[] args) {
        int[] array = {2, 3, 21, 1, 5, 5, 8, 22, 19, 7, 27, 84, 19, 5, 33, 66, 5, 88};
        Quicksort qs = new Quicksort();

        int[] array2 = {2, 3, 21, 1, 7, 27, 84, 19, 5, 1, 88};
        qs.sort(array2);

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

    }
}
