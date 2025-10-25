package Recursion;

public class RecursionProblems {
    public static void main(String[] args) {
        // You can add test cases for recursion problems here

        printDigits(5); // Example call to print digits from 1 to 5
        printDigitWithRecursion(1, 5); // Example call to print digits from 5 to 1
    }

    // Example: Factorial of a number using recursion
    

    // Print digits 1 to n using backtracking
    static void printDigits(int n) {
        if (n ==0){
            return;
        }
        printDigits(n-1);
        System.out.print(n + " ");
    }

    static void printDigitWithRecursion(int initial, int n) {
        if (initial > n) {
            return;
        }
        System.out.print(initial + " ");
        printDigitWithRecursion(initial+1, n);
    }
}
