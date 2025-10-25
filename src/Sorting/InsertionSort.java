package Sorting;

/* Insertion Sort: Technique to build a sorted array one element at a time by comparing and inserting
* Time Complexity: O(n^2) , Best Case: O(n) when nearly sorted
* IN Short: Pick an element and place it at its correct position in the sorted part of the array
 */
// /* Alternative Method 2: Swapping adjacent elements until the current element is in the correct position

public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {12,11,13,5,6};
        System.out.println("Insertion Sort Implementation: ");
        insertion_sort(arr); // Time Complexity: O(n^2) best O(n) when nearly sorted
        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
        int[] arr2 = {31,41,59,26,41,58};
        insertion_sort_method2(arr2); // Time Complexity: O(n^2) 
        System.out.print("\nSorted array (Method 2): ");
        for(int num : arr2){
            System.out.print(num + " ");
        }
    }

    static void insertion_sort(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    static void insertion_sort_method2(int[] arr){
        int n = arr.length;
        for(int i=0; i<=n-1; i++){
            int j = i;
            
            while(j>0 && arr[j-1] > arr[j]){
                // swap arr[j] and arr[j-1]
                int temp = arr[j];
                arr[j] = arr[j-1]; 
                arr[j-1] = temp;
                j--;
            }
            
        }
    }
    static void insertion_sort_recursive(int[] arr, int n){
        // Base case
        if(n <= 1) return;

        // Sort first n-1 elements
        insertion_sort_recursive(arr, n-1);

        // Insert last element at its correct position in sorted array.
        int last = arr[n-1];
        int j = n-2;

        // Move elements of arr[0..n-1], that are greater than last,
        // to one position ahead of their current position
        while(j>=0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
}
