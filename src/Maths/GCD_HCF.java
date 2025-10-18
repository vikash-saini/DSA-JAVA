package Maths;

public class GCD_HCF {
    public static void main(String[] args) {
        int a = 56;
        int b = 98;

        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
        checkGCD(a, b); // Time Complexity: O(min(a, b))
        checkGCD2(a, b); // Time Complexity: O(min(a, b))
        System.out.println("GCD By Euclidean Algo is: " + gcdEuclidean(a, b)); // Time Complexity: O(log min(a, b))
        System.out.println("GCD: " + gcdEuclidean2(a, b)); // Time Complexity: O(log min(a, b))
    }

    static int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    static int hcf(int a, int b){
        return gcd(a, b);
    }

    static void checkGCD(int a, int b){
        // Additional method to demonstrate GCD functionality if needed
        int gcd = 1;
        for(int i =1 ; i <= Math.min(a, b); i++){
            if (a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        System.out.println("GCD is: " + gcd);
    }

    static void checkGCD2(int a, int b){
        // Additional method to demonstrate GCD functionality if needed
        for(int i=Math.min(a, b) ; i >= 1; i--){
            if (a % i == 0 && b % i == 0){
                System.out.println("GCD is: " + i);
                break;
            }
        }
    }

    /* Euclidean Algorithm */
    static int gcdEuclidean(int a, int b){
        if (b == 0){
            return a;
        }
        return gcdEuclidean(b, a % b);
    }

    static int gcdEuclidean2(int a, int b){
        while (a > 0 && b > 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        if(a == 0) return b;
        else return a;
    }
}
