package ArrayProblems;

public class findLargestNumber {
    public static void main(String[] args){
        int[] arr = {34, 67, 23, 89, 12, 90, 45};
        System.out.println("The largest number in the array is: " + findLargest(arr));
    }

    // Optimized Approach: Single Pass , Time Complexity: O(n)
    static int findLargest(int[] arr){
        int largest = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    // Brute Force Approach: Sort the array and return the last element , Time Complexity: O(n log n)
    static int findLargest_bruteforce(int[] arr){
        // Sorting the array using built-in sort (which is typically O(n log n))
        java.util.Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
