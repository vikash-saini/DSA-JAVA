package Maths;

public class PrintDivisions {
    public static void main(String[] args) {
        int number = 36;
        printDivisions(number);
        printAllDivisions(number); // number of divisors with time complexity O(n)
    }

    static void printDivisions(int number){
        System.out.print("Divisions by 10 are: ");
        while (number > 0){
            System.out.print(number + " ");
            number = number / 10;
        }
        System.out.println();
    }

    static void printAllDivisions(int number){
        System.out.print("All Divisions are: ");
        for(int i=1; i<= number; i++){
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
