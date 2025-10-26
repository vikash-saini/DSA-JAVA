package ArrayProblems;

public class findSecondLargest {
    public static void main(String[] args){
        int[] arr = {34, 67, 23, 89, 12, 90, 45};
        System.out.println("The second largest number in the array is: " + findSecondLargest(arr));
    }

    // Optimized Approach: Single Pass , Time Complexity: O(n)
    static int findSecondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int num : arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            } else if(num > secondLargest && num != largest){
                secondLargest = num;
            }
        }
        return secondLargest;
    }
    // Brute Force Approach: Sort the array and return the second last element , Time Complexity: O(n log n)
    static int findSecondLargest_bruteforce(int[] arr){
        // Sorting the array using built-in sort (which is typically O(n log n))
        java.util.Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        // Handle duplicates of the largest element
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] != largest){
                return arr[i];
            }
        }
        return Integer.MIN_VALUE; // In case there is no second largest (all elements are same)
    }
    // Better Approach: Two Passes , Time Complexity: O(n)
    static int findSecondLargest_better(int[] arr){
        int largest = Integer.MIN_VALUE;
        // First Pass: Find the largest element
        for(int num : arr){
            if(num > largest){
                largest = num;
            }
        }

        int secondLargest = Integer.MIN_VALUE;
        // Second Pass: Find the second largest element
        for(int num : arr){
            if(num > secondLargest && num != largest){
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
