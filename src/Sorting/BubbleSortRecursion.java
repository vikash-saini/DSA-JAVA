package Sorting;

public class BubbleSortRecursion {
    public static void main(String[] args){
        int[] arr = {64,34,25,12,22,11,90};
        System.out.println("Bubble Sort Recursion Implementation: ");
        bubble_sort_recursive(arr, arr.length); // Time Complexity: O(n^2)
        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
    
    static void bubble_sort_recursive(int[] arr, int n){
        // Base case
        if(n == 1) return;

        // One pass of bubble sort. After this pass, the largest element is moved (or bubbled) to end.
        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                // swap arr[i] and arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        // Largest element is fixed, recur for remaining array
        bubble_sort_recursive(arr, n-1);
    }
}
