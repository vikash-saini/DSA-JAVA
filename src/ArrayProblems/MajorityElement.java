package ArrayProblems;
/* Majority Element:
 * Majority element is the one which apears more than N/2 times , N:size of the Array
 * Note: even if a element appear N/2 times, it will not be considered as majority element. 
 * it should be more than N/2 times always
 */

import java.util.HashMap;
import java.util.Map;

/* Moore's Voting Algorithm :is a two-pass, two-phase algorithm to find a potential majority element (one that appears more than \(N/2\) times) in a sequence.
  * First, choose a candidate from the given set of elements if it is the same as the candidate element, increase the votes. 
    Otherwise, decrease the votes if votes become 0, select another new element as the new candidate
  */
public class MajorityElement {
    public static void main(String[] args){
        int[] arr = {2,4,2,2,5,1,1,2,2,2,1,1,1,1,1,1,1};
        int ele = findMajorityElement(arr);
        System.out.println("Majority element > n/2: "+ele);
        System.out.println("Majority By HashMap: " + findMajorityWithHash(arr));
    }

    /* Brute:
     * TC: n*n = O(n^2)
     * SC: O(1)
     */
    static int majorityElementBrute(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count =0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > n/2) {
                return arr[i];
            }
        }
        return -1;
    }
    // Moore's Voting algorithm
    // Time Complexity: n+n = 2n, Space complexity: O(1)
    static int findMajorityElement(int[] arr){
        int ele = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if (count == 0) {
                count = 1;
                ele = arr[i];
            }else if (arr[i] == ele) {
                count++;
            }else{
                count--;
            }
        }
    
        // verify if ele occurs more than n/2 times
        // this step will not require if it is given that the majority element always exists in the array, in this case direclty return the ele
        int count1=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                count1++;
            }
        }
        if (count1 > (arr.length/2)) {
            return ele;
        }
        return -1;
    }

    /* Time Complexity: O(n) + O(n) = 2n
    Explain: 1st Loop runs n times (for each element in arr), Each put() and getOrDefault() operation in a HashMap takes O(1) on average.
    Therefore O(n)
    Iterate through the map for n entries (if all elements are unique) : O(n)
    Total O(n) + O(n) = 2n
    Space: The HashMap can store up to n key-value pairs (in worst case all unique elements),so O(N)
    */ 
    static int findMajorityWithHash(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num,0) +1);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue() > arr.length/2) {
                return entry.getKey();
            } 
        }
        return -1;
    }
}
