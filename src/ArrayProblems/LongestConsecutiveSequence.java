package ArrayProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {0,2,10,3,11,12,4,14,1,5};
        System.err.println("Longest Sequence Size: "+ findLongestSequenceBetter(arr));

        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }

     /* Optimal Solution : Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
      * Reason: O(N) for putting all the elements into the set data structure. After that for every starting element, we are finding the consecutive elements. Though we are using nested loops, the set will be traversed at most twice in the worst case. So, the time complexity is O(2*N) instead of O(N2).
        Space Complexity: O(N), as we are using the set data structure to solve this problem.
      */
    static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    // Brute force : Time Complexity n * n = O(2n)(approx) , SC : O(1)
    static int findLongestSequence(int[] arr){
        int longest =1;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int count = 1;
            while (linearSearch(arr,x+1)==true) {
                x = x+1;
                count++;
            }

            longest = Math.max(longest, count);
        }
        return longest;
    }

    // Better Approach : TC Nlongn +N
    static int findLongestSequenceBetter(int[] arr){
        Arrays.sort(arr); //nlogn
        System.err.println("Sorted: "+ Arrays.toString(arr));
        int longest =1; int lastSmallest = Integer.MIN_VALUE; 
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i]-1 == lastSmallest) {
                lastSmallest = arr[i];
                count++;
            }else if (arr[i] != lastSmallest){
                lastSmallest = arr[i];
                count = 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    static boolean linearSearch(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
}
