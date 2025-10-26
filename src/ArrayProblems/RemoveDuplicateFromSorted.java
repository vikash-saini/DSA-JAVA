package ArrayProblems;

import java.util.Arrays;
import java.util.Set;

public class RemoveDuplicateFromSorted {
    public static void main(String[] args){
        int[] arr = {1,1,2,2,3,4,4,5};
        int newLength = removeDuplicates_better(arr);
        System.out.println("Array after removing duplicates has length: " + newLength);
        System.out.print("Array elements: ");
        for(int i=0; i<newLength; i++){
            System.out.print(arr[i] + " ");
        }

        // System.out.println("here: "+Arrays.toString(arr));
    }

    // Brute Force Approach: Using Set , O(n) time, O(n) space
    static int removeDuplicates(int[] arr){
        if(arr.length == 0) return 0;
        Set<Integer> set = new java.util.HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        for(int i=0; i<set.size(); i++){
            arr[i] = (int) set.toArray()[i];
        }
        int index = set.size();
        return index; // New length of array with unique elements
    }
    // Better Approach: Using Two Pointers , O(n) time, O(1) space
    static int removeDuplicates_better(int[] arr){
        if(arr.length == 0) return 0;

        int index = 1; // Index to place the next unique element
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                arr[index] = arr[i];
                index++;
            }
        }
        return index; // New length of array with unique elements
    }
}
