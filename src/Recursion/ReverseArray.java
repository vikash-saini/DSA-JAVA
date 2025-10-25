package Recursion;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length - 1); // Time Complexity: O(n), Space Complexity: O(n)
        // reverseArrayBruteForce(arr); // Time Complexity: O(n), Space Complexity: O(1)
        // reverseArrayWithOneVariable(arr, 0, arr.length); // Time Complexity: O(n), Space Complexity: O(n)
        System.out.print("Reversed Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void reverseArray(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursive call for the next pair
        reverseArray(arr, start + 1, end - 1);
    }

    // brute force approach
    static void reverseArrayBruteForce(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static void reverseArrayWithOneVariable(int[] arr, int start, int end) {
        if (start >= end/2) {
            return;
        }
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end - start - 1];
        arr[end - start - 1] = temp;

        // Recursive call for the next pair
        reverseArray(arr, start + 1, end);
    }
}
