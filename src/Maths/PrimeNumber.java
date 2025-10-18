package Maths;

/* Prime Number:
 * A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
 * A prime number is only divisible by 1 and itself.
 */
public class PrimeNumber {
    public static void main(String[] args){
        checkPrime(13); // Prime Number Time Complexity: O(√n)
        checkPrime(15); // Not a Prime Number  Time Complexity: O(√n)
        checkPrimeSimple(29); // Prime Number Time Complexity: O(√n)
        checkPrimeBruteForce(30); // Not a Prime Number Time Complexity: O(n)
        checkPrimeOptimized(37); // Prime Number Time Complexity: O(√n)
    }

    static void checkPrime(int number){
        boolean isPrime = true;
        for(int i=2; i<=Math.sqrt(number); i++){
            if(number % i == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime){
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }

    static void checkPrimeOptimized(int number){
        if(number <= 1){
            System.out.println(number + " is not a Prime Number");
            return;
        }
        if(number == 2 || number == 3){
            System.out.println(number + " is a Prime Number");
            return;
        }
        if(number % 2 == 0 || number % 3 == 0){
            System.out.println(number + " is not a Prime Number");
            return;
        }

        boolean isPrime = true;
        for(int i=5; i*i<=number; i+=6){
            if(number % i == 0 || number % (i + 2) == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime){
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }

    static void checkPrimeBruteForce(int number){
        if(number <= 1){
            System.out.println(number + " is not a Prime Number");
            return;
        }

        boolean isPrime = true;
        for(int i=2; i<number; i++){
            if(number % i == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime){
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }

    static void checkPrimeSimple(int number){
        if(number <= 1){
            System.out.println(number + " is not a Prime Number");
            return;
        }

        int divisorCount = 0;
        for(int i=1; i<=Math.sqrt(number); i++){
            if(number % i == 0){
                divisorCount++;
                if(i !=  number / i){
                    divisorCount++;
                }
            }
        }
        if(divisorCount == 2){
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
    }
}
