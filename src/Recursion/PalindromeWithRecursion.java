package Recursion;

public class PalindromeWithRecursion {
    public static void main(String[] args) {
        int number = 23332;
        int end = Integer.toString(number).length() - 1;
        System.out.println("Palindrome Check for " +number+": " + checkPalindromeOptimized(number, 0, end)); // time Complexity: O(n)
        System.out.println("Palindrome Check for " +234+": " + checkPalindrome(234)); // time Complexity: O(n)
        // System.out.println("Palindrome Check for " +number+": " + checkPalindromeOptimized2(number, 0, end + 1)); // time Complexity: O(n)
    }

    static boolean checkPalindrome(int number){
        String numStr = Integer.toString(number);
        if (numStr.length() <= 1) {
            return true;
        }
        if (numStr.charAt(0) != numStr.charAt(numStr.length() - 1)) {
            return false;
        }
        int truncatedNumber = Integer.parseInt(numStr.substring(1, numStr.length() - 1));
        return checkPalindrome(truncatedNumber);
    }

    static boolean checkPalindromeOptimized(int number, int start, int end){
        String numStr = Integer.toString(number);
        if (start >= end) {
            return true;
        }
        if (numStr.charAt(start) != numStr.charAt(end)) {
            return false;
        }
        return checkPalindromeOptimized(number, start + 1, end - 1);
    }

    // static boolean checkPalindromeOptimized2(int number, int start, int end){
    //     String numStr = Integer.toString(number);
    //     if (start >= end/2) {
    //         return true;
    //     }
    //     if (numStr.charAt(start) != numStr.charAt(end - start - 1)) {
    //         return false;
    //     }
    //     return checkPalindromeOptimized(number, start + 1, end);
    // }
}
