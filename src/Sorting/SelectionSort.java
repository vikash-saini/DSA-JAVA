package Sorting;

import java.util.Arrays;

/* Selection Sort: Technique to select the minimum value from unsorted array and place it at the beginning 
 * Time Complexity: O(n^2)
*/

public class SelectionSort {
    public static void main(String[] args){
    int[] arr = {13,46,24,52,20,9};
    System.out.println("Selection Sort Implementation: ");
    System.out.println(Arrays.toString(arr)+" Sorted to: "+Arrays.toString(selection_sort(arr))); //Time Complexity: O(n^2)
    // selection_sort(arr);
    }

    static int[] selection_sort(int[] arr){
        int n = arr.length;
        for(int i=0; i<=n-2; i++){
            int min_index = i;
            for(int j=i; j<=n-1; j++){
                if(arr[min_index] > arr[j]){
                    min_index = j;
                }
            }
            // swap
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp; 
        }

        return arr;
    }
}
