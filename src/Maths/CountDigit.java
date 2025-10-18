package Maths;
import java.lang.Math;

public class CountDigit {
    public static void main(String[] args) {
        int number = 345678;

        countDigitWithLoop(number); //6
        countNumberOfDigits(number); //5

    }

    static void countNumberOfDigits(int number) {
        int count = (int)Math.log10(number);
        System.out.println(count);
    }

    static void countDigitWithLoop(int number) {
        int count = 0;
        while(number!=0){
            number = number/10;
            count++;
        }

        System.out.println(count);
    }
}
