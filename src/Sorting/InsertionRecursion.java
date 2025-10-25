package Sorting;

public class InsertionRecursion {
    public static void main(String[] args){
        int[] arr = {12,11,13,5,6};
        System.out.println("Insertion Sort Recursion Implementation: ");
        insertion_sort_recursive(arr, arr.length); // Time Complexity: O(n^2)
        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num + " ");
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
        while(j >= 0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
}
