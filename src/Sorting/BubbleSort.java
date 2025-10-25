package Sorting;

/* Bubble Sort: Technique to push the maximum value at last with adjacent swaps 
 * Time Complexity: O(n^2)
 * Optimized Bubble Sort: Stops if no swaps are made in a pass (Best Case: O(n))
*/

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {64,34,25,12,22,11,90};
        System.out.println("Bubble Sort Implementation: ");
        bubble_sort(arr); // Time Complexity: O(n^2)
        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
        int[] arr2 = {2,3,5,10,15,20,25};
        bubble_sort_optimized(arr2); // Time Complexity: O(n^2) but better for nearly sorted arrays , Best Case: O(n)
        System.out.print("Sorted array (Optimized): ");
        for(int num : arr2){
            System.out.print(num + " ");
        }

        System.out.println();
        int[] arr3 = {5,1,4,2,8};
        bubble_sort_method2(arr3); // Time Complexity: O(n^2)
        System.out.print("Sorted array (Method 2): ");
        for(int num : arr3){
            System.out.print(num + " ");
        }
    }

    static void bubble_sort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void bubble_sort_method2(int[] arr){
        int n = arr.length;
        boolean swapped;
        for(int i=n-1; i>=0; i--){
            swapped = false;
            for(int j=0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if(!swapped) break;
        }
    }

    static void bubble_sort_optimized(int[] arr){
        int n = arr.length;
        boolean swapped;
        for(int i=0; i<n-1; i++){
            swapped = false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if(!swapped) break;
        }
    }
}
