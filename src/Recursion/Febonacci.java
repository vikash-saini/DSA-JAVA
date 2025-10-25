package Recursion;

public class Febonacci {
    
    public static void main(String[] args) {
        int n = 7;
        System.out.print("Fibonacci Series: 0 1 ");
        printFibonacci(0, 1, n - 2); // Time Complexity: O(n), Space Complexity: O(n)
        System.out.println("\nFibonacci Number at position " + n + " is: " + findFibonacci(n)); // Time Complexity: O(2^n), Space Complexity: O(n)
    }

    static void printFibonacci(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.print(c + " ");
        printFibonacci(b, c, n - 1);
    }

    static int findFibonacci(int n){

        if(n <= 1){
            return n;
        }
        return findFibonacci(n-1) + findFibonacci(n-2);
    }

}
