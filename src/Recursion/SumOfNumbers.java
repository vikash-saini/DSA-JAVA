package Recursion;

public class SumOfNumbers {
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum of first " + n + " numbers is: " + sumOfNumbers(n, 0) ); // Time Complexity: O(n)
        System.out.println("Sum of first " + n + " numbers is: " + sumOfNumbersFunctional(n) ); // Time Complexity: O(n)
    }
    static int sumOfNumbers(int n, int sum) {
        if(n == 0){
            return sum;
        }
       return sumOfNumbers(n-1, sum+n);
    }

    // functional programming approach
    static int sumOfNumbersFunctional(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNumbersFunctional(n-1);
    }
}
