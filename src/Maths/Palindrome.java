package Maths;
/* 
 * Important Note: This code checks for palindrome for positive numbers only.
 * If you want to check for negative numbers as well, you need to handle the negative sign
 * accordingly since NEGATIVE numbers are not considered palindromes in the conventional sense.
 * 
 */
public class Palindrome {
    public static void main(String[] args) {
        checkPalindrome(121);
        checkPalindrome(-121);
        checkPalindrome(1234321);
    }

    static void checkPalindrome(int number){
        if (number < 0 || (number%10 ==0 && number !=0)) {
            System.out.println(number + " is not a Palindrome");
            return ;
        }

        int originalNumber = number;
        int reversed = 0;
        while (number != 0){
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number = number/10;
        }
        if (originalNumber == reversed){
            System.out.println(originalNumber + " is a Palindrome");
        } else {
            System.out.println(originalNumber + " is not a Palindrome");
        }
    }
}
