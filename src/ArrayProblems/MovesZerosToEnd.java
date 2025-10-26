package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovesZerosToEnd {
    public static void main(String[] args){
        int[] arr = {0,1,0,3,12,0,5};
        System.out.println("Array before moving zeros: ");
        printArray(arr);
        moveZerosToEnd_optimized2(arr);
        System.out.println("Array after moving zeros to the end: ");
        printArray(arr);
    }

    // Optimized Approach: Two Pointers Approach , O(n) time, O(1) space
    // Time Complexity: O(n), Space Complexity: O(1)
    // Total Time Complexity: O(n) + O(n) = O(2n) which is simplified to O(n) ≈ O(n)
    static void moveZerosToEnd(int[] arr){
        int n = arr.length;
        int nonZeroIndex = 0; // Index to place the next non-zero element

        // Move all non-zero elements to the front
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }
        // System.out.println("here: "+Arrays.toString(arr));
        // Fill the remaining positions with zeros
        for(int i=nonZeroIndex; i<n; i++){
            arr[i] = 0;
        }
    }

    // Brute Force Approach: Using Extra Array , O(n) time, O(n) space
    // Total Time Complexity: O(n) + O(n) + O(n) = O(3n) which is simplified to O(n) ≈ O(n)
    static void moveZerosToEnd_bruteforce(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;

        // Copy non-zero elements to temp array
        // First loop → iterates n times → O(n)
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                temp[index] = arr[i];
                index++;
            }
        }
        // Fill the remaining positions in temp with zeros
        // Second loop → iterates n-index(at most n times) times → O(n)
        while(index < n){
            temp[index] = 0;
            index++;
        }
        // Copy back to original array
        // Third loop → iterates n times → O(n)
        for(int i=0; i<n; i++){
            arr[i] = temp[i];
        }
    }

    // Brute Force Approach 2: Using ArrayList , O(n) time, O(n) space
    // Total Time Complexity: O(n) + O(n) + O(n) = O(3n) which is simplified to O(n) ≈ O(n)
    static void moveZerosToEnd_bruteforce2(int[] arr){
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();

        // Copy non-zero elements to temp array
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                temp.add(arr[i]);
            }
        }

        // Copy all nonzeros back to original array
        for(int i=0; i<temp.size(); i++){
            arr[i] = temp.get(i);
        }

        // Fill the remaining positions in original array with zeros
        for(int i=temp.size(); i<n; i++){
            arr[i] = 0;
        }
    }

    // Optimized Approach2: Single Pass , O(n) time, O(1) space
    // Time Complexity: O(n), Space Complexity: O(1)
    // 
    static void moveZerosToEnd_optimized2(int[] arr){
        int n = arr.length;
        int nonZeroIndex = -1; // Index of first non-zero element
        for(int i=0; i<n; i++){
            if(arr[i] == 0){
                nonZeroIndex = i;
                break;
            }
        }
        if (nonZeroIndex == -1) {
            return; // No zeros found, array is already in desired state
        }
        // Single pass to move non-zero elements forward and fill zeros
        for(int i=nonZeroIndex+1; i<n; i++){
            if(arr[i] != 0){
                // Swap only if i and nonZeroIndex are different
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }
    } 


    static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
