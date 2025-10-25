package Sorting;

/* Quick Sort: Divide and Conquer technique to sort an array by partitioning 
 * Time Complexity: O(n log n) on average, O(n^2) in worst case
 * Step 1: Choose a pivot element from the array. it can be the first, last, or any random element.
 * Step 2: Partition the array into two sub-arrays: elements less than the pivot and elements greater than the pivot.
 * Smaller elements are moved to the left of the pivot and larger elements to the right.
 * Step 3: Recursively apply the above steps to the sub-arrays.
*/

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {4,6,2,5,7,9,1,3};
        System.out.println("Quick Sort Implementation: ");
        quick_sort(arr, 0, arr.length - 1); // Time Complexity: O(n log n) on average
        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num + " ");
        }

        System.out.println();
        int[] arr2 = {10,7,8,9,1,5};   
        quick_sort_method2(arr2, 0, arr2.length - 1); // Time Complexity: O(n log n) on average
        System.out.print("Sorted array (Method 2): ");
        for(int num : arr2){
            System.out.print(num + " ");
        }
    }

    static void quick_sort(int[] arr, int low, int high){
        if(low < high){
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);
            // Recursively sort elements before partition and after partition
            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; // pivot
        int i = (low - 1); // Index of smaller element

        for(int j = low; j < high; j++){
            // If current element is smaller than or equal to pivot
            if(arr[j] <= pivot){
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void quick_sort_method2(int[] arr, int low, int high){
        if(low < high){
            // pi is partitioning index, arr[pi] is now at right place
            int pi2 = partition_method2(arr, low, high); // Alternative partition method
            // Recursively sort elements before partition and after partition
            quick_sort(arr, low, pi2 - 1);
            quick_sort(arr, pi2 + 1, high);
        }
    }

    static int partition_method2(int[] arr, int low, int high){
        int pivot = arr[low]; // pivot
        int i = low;
        int j = high;

        while(i < j){
            while(i <= high-1 && arr[i] <= pivot){
                i++;
            }
            while(j >= low+1 && arr[j] > pivot){
                j--;
            }
            if(i > j){
                break;
            } else {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[low] and arr[j] (or pivot)
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}
