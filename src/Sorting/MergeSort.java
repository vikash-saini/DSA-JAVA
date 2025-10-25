package Sorting;

import java.util.Arrays;

/* Merge Sort: Divide and Merge algorithm that divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves.
 * Time Complexity: O(n log n)
*/

public class MergeSort {

    public static void main(String[] args) {
        int[]  arr= {10,4,15,12,8,11,6};
        System.out.println("Merge Sort Implementation: ");
        merge_sort(arr, 0, arr.length - 1); // Time Complexity: O(n log n)
        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
        int[] arr2 = {38,27,43,3,9,82,10};
        merge_sort_method2(arr2, 0, arr2.length - 1); // Time Complexity: O(n log n)
        System.out.print("Sorted array (Method 2): " + Arrays.toString(arr2));  

    }

    static void merge_sort(int[] arr, int low, int high){
        if (low >= high) {
            return; // Base case: array of one element
        }
        int midIndex = (low + high)/2;
        merge_sort(arr, low, midIndex); // Sort left half
        merge_sort(arr, midIndex + 1, high); // Sort right half
        merge(arr, low, midIndex, high); // Merge sorted halves
    }

    static void merge(int[] arr, int low,int mid,int high){
        // Find sizes of two subarrays to be merged
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        // Merge the two subarrays into temp[]
        while(left<=mid && right<=high){
            if(arr[left] <=arr[right]){
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        // Copy remaining elements of left subarray if any
        while (left <=mid) {
            temp[k++] = arr[left++];
        }
        // Copy remaining elements of right subarray if any
        while (right <=high) {
            temp[k++] = arr[right++];
        }
        // Copy back the merged elements to original array
        for(int i=0; i<temp.length; i++){
            arr[low + i] = temp[i];
        }
    }

    static void merge_sort_method2(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            merge_sort_method2(arr, left, mid);
            merge_sort_method2(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

}
