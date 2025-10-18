package Maths;

public class ReverseNumber {
    public static void main(String[] args) {
        int number = 159000;
        reverseNumber(number);
    }

    static void reverseNumber(int number){
        int reversed = 0;
        while (number != 0){
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number = number/10;
        }

        System.out.println("Reversed Number: " + reversed);
    }
}
