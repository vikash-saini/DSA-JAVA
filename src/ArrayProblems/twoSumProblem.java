package ArrayProblems;

import java.util.Arrays;

public class twoSumProblem {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        if(result.length == 2){
            System.out.println("Indices of the two numbers that add up to " + target + " are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers add up to the target.");
        }
        int[] arr2 = {1,6,7,8,10};
        int target2 = 14;
        int[] result2 = twoSum_optimized(arr2, target2);
        if(result2.length == 2){
            System.out.println("Indices of the two numbers that add up to " + target2 + " are: " + result2[0] + " and " + result2[1]);
        } else {
            System.out.println("No two numbers add up to the target.");
        }
    }

    // Brute Force Approach: Time Complexity: O(n^2), Space Complexity: O(1)
    static int[] twoSum(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i, j}; // Return the indices of the two numbers
                }
            }
        }
        return new int[]{}; // Return empty array if no such pair is found
    }

    // Optimized Approach: Using HashMap , Time Complexity: O(n), Space Complexity: O(n)
    // This function returns the indices of the two numbers
    static int[] twoSum_optimized(int[] arr, int target){
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for(int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i}; // Return the indices of the two numbers
            }
            map.put(arr[i], i); // Store the number and its index in the map
        }
        return new int[]{}; // Return empty array if no such pair is found
    }

    // Another Optimized Approach: Using HashSet , Time Complexity: O(n), Space Complexity: O(n)
    // This function returns the two numbers instead of their indices
    static int[] twoSum_optimized_withSet(int[] arr, int target){
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for(int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(set.contains(complement)){
                return new int[]{complement, arr[i]}; // Return the two numbers
            }
            set.add(arr[i]); // Add the current element to the set
        }
        return new int[]{}; // Return empty array if no such pair is found
    }

    // Optimized Approach for Sorted Array: Using Two Pointers , Time Complexity: O(n), Space Complexity: O(1)
    static int[] twoSum_sortedArray(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{left, right}; // Return the indices of the two numbers
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{}; // Return empty array if no such pair is found
    }

    // For Unsorted Array: First sort the array and then use Two Pointers , Time Complexity: O(n log n) due to sorting, Space Complexity: O(1)
    static int[] twoSum_unsortedArray(int[] arr, int target){
        Arrays.sort(arr); // Sort the array first O(n log n)
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{arr[left], arr[right]}; // Return the two numbers
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{}; // Return empty array if no such pair is found
    }
    
}
