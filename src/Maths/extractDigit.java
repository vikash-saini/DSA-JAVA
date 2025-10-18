package Maths;

public class extractDigit {
    public static void main(String[] args){
        int number = 65466722;
        
        extractDigits(number);
        extractLastDigit(number);
        extractDigitATPosition(number);
        extractDigitATPosition2(number);
    }

    static void extractDigits(int number){
        System.out.print("Digits are: ");
        while (number > 0){
            int digit = number % 10;
            System.out.print(digit + " ");
            number = number/10;
        }
        System.out.println();
    }

    static void extractLastDigit(int number){
        int lastDigit = number % 10;
        System.out.println("Last Digit is: " + lastDigit);
    }

    static void extractDigitATPosition(int number){
        int position = 3; // Example: Extracting the 3rd digit from the right
        int extractedDigit = (number / (int)Math.pow(10, position - 1)) % 10;
        System.out.println("Digit at position " + position + " is: " + extractedDigit);
    }

    static void extractDigitATPosition2(int number){
        int position = 4; // Example: Extracting the 4th digit from the right
        int extractedDigit = 0;
        for(int i=1; i <= position; i++){
            extractedDigit = number % 10;
            number = number / 10;
        }

        System.out.println("Digit at position " + position + " is: " + extractedDigit);
    }

}
