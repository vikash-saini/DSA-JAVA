package Maths;

public class ArmstrongDigit {
    public static void main(String[] args) {
        isArmstrong(153);
        isArmstrong(1634);
        isArmstrong(333);
        armstrongNumber(371);
    }

    static void isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;

        /* Covert number to a string to easily count how many digits it has .
         * This tells us how many times to raise each digit to a power
         * for example: 153 has 3 digits so each digit is raised to the power of 3
         * 1^3 + 5^3 + 3^3 = 153
         * 1634 has 4 digits so each digit is raised to the power of 4
         * 1^4 + 6^4 + 3^4 + 4^4 = 1634
         */
        int digits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
    }

    // only works for 3 digits armstrong number
    static void armstrongNumber(int number){
        int originalNumber = number;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number = number / 10;
        }

        if (sum == originalNumber) {
            System.out.println(originalNumber + " is armstrong number");
        }else { 
            System.out.println(originalNumber + " is not armstrong number");
        }
    }
}
