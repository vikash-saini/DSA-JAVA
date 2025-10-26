package ArrayProblems;

/* Linear Search:
 * Given an array and a target value, find the index of the target value in the array using linear search.
 * If the target value is not found, return -1.
 */

public class LinearSearch {
    public static void main(String[] args){
        int[] arr = {10, 23, 45, 70, 11, 5, 90};
        int target = 70;
        int resultIndex = linearSearch(arr, target);
        if(resultIndex != -1){
            System.out.println("Element " + target + " found at index: " + resultIndex);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }

    // this code only return first occurrence of target element
    static int linearSearch(int[] arr , int target){
        for(int i =0; i<arr.length; i++){
            if(arr[i] == target){
                return i; // Return the index if target is found
            }
        }
        return -1; // Return -1 if target is not found
    }

}
