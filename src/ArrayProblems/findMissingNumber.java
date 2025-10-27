package ArrayProblems;

public class findMissingNumber {
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 4, 5, 6};
        System.out.println("The missing number in the array is: " + findMissing(arr));
    }

    // Optimized Approach: Using Sum Formula , Time Complexity: O(n)
    // Space Complexity: O(1)
    static int findMissing(int[] arr){
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
        int actualSum = 0;
        for(int num : arr){
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    // Brute Force Approach: Sort the array and check for missing number , Time Complexity: O(n log n)
    static int findMissing_bruteforce(int[] arr){
        // Sorting the array and checking for missing number
        java.util.Arrays.sort(arr); // O(n log n)
        for(int i=0; i<arr.length; i++){ // O(n)
            if(arr[i] != i){
                return i;
            }
        }
        return arr.length; // If no number is missing in the range 0 to n-1, then n is missing
    }

    // Another Brute Force Approach: Nested Loops , Time Complexity: O(n^2)
    static int findMissing_bruteforce_method2(int[] arr){
        int n = arr.length;

        for(int i=0; i<n; i++){
            int flag =0;
            for(int j=0; j<n; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }   
        }
        return -1; // If no number is missing
    }

    static int findMissing_better(int[] arr){
        // This function can be implemented using HashSet to store elements and then check for missing number
        // Time Complexity: O(n), Space Complexity: O(n)
        // Total time: O(n) + O(n) = O(2n) = O(n)
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        for(int i=0; i<=arr.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1; // If no number is missing
    }

    // using Xor
    // Time Complexity: O(n), Space Complexity: O(1)
    static int findMissing_xor(int[] arr){
        int n = arr.length;
        int xor_full = 0;
        int xor_arr = 0;

        // Xor of all numbers from 0 to n
        for(int i=0; i<=n; i++){
            xor_full ^= i;
        }

        // Xor of all elements in the array
        for(int num : arr){
            xor_arr ^= num;
        }

        // Missing number is the xor of above two results
        return xor_full ^ xor_arr;
    }
}
