package Recursion;

class FactorialOfNumber {

    public static void main(String[] args) {
        int number = 4;
        System.out.println("Factorial of " + number + " is: " + factorial(number)); //time complexity O(n), Space Complexity: O(n)
    }
    static int factorial(int n) {
       if (n == 0){return 1;}
       return n * factorial(n-1);
    }
}