package Recursion;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsequences {
    public static void main(String[] args) {
        // printSequences();
        int[] arr = {3, 1, 2};
        List<Integer> list = new ArrayList<>();
        // printSubsequencesRecursively(arr, 0, ""); // Time Complexity: O(n*2^n), Space Complexity: O(n)
        printSubsequencesRecursively2(arr, 0, list); // Time Complexity: O(n*2^n), Space Complexity: O(n)
    }

    static void printSequences() {
        int[] arr = {3, 1, 2};
        int n = arr.length;
        int total = (int)Math.pow(2, n);

        for (int i = 0; i < total; i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    static void printSubsequencesRecursively(int[] arr, int index, String current) {
        if (index == arr.length) {
            System.out.println("{ " + current + "}");
            return;
        }

        printSubsequencesRecursively(arr, index + 1, current + arr[index] + " ");
        printSubsequencesRecursively(arr, index + 1, current);
    }

    static void printSubsequencesRecursively2(int[] arr, int index, List<Integer> newArr) {
        if (index == arr.length) {
            System.out.println(newArr);
            return;
        }

        printSubsequencesRecursively2(arr, index + 1, newArr);
        newArr.add(arr[index]);
        printSubsequencesRecursively2(arr, index + 1, newArr);
        newArr.remove(newArr.size() - 1);
    }
}
