package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithSum {
    public static void main(String[] args) {
        int k = 3;
        int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        int count = subArrayswithCountK(arr,k);
        System.out.println("Total count of Subarray: "+count);
        System.out.println("Better Approach: "+subArrayswithCountK_Better(arr,k));
        System.out.println("Optimized Approach: "+subArrayswithCountK_Optimized(arr,k));
        
    }

    /* Brute Force : time complexity n*n*n = O(n^3)
     * Space Complexity O(1)
     * 
     */
    static int subArrayswithCountK(int[] arr, int totalSum){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <=j; k++) {
                    sum += arr[k];
                }
                if (sum == totalSum) {
                    count++;
                }
            }
        }

        return count;
    }

    /* Better : time complexity n*n = O(n^2)
     * Space Complexity O(1)
     * 
     */
    static int subArrayswithCountK_Better(int[] arr, int totalSum){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == totalSum) {
                    count++;
                }
            }
        }

        return count;
    }

    /* Better : time complexity Single pass + O(1) HashMap ops:  O(n) , worst case(possible of collision in map) : O(n²)
     * explain: Each operation on the HashMap (get, put) = O(1) average time.
     * The loop runs n times. So Total O(N)
     * Worset Case: If the HashMap has many hash collisions, operations degrade to O(n) each. Then the total could become O(n²)
     * 
     * Space Complexity O(n)
     * 
     */
    static int subArrayswithCountK_Optimized(int[] arr, int k){
        int n = arr.length; // size of the given array.
        Map<Integer,Integer> mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1); // TC O(1) , SC O(N)
        }
        return cnt;
    }
    
}


