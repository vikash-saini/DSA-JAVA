package ArrayProblems;

/* 
 * FInd the Number that appears once in an array where every other number appears twice.
 * Given an array of integers where every element appears twice except for one, find that single one
 */
public class findNumberAppearOnes {
    public static void main(String[] args){
        int[] arr = {1,1,2,2,3,4,4,5,5};
        System.out.println("The number that appears once in the array is: " + findSingleNumber_better(arr));
    }

    // Brute Force Approach: Time Complexity: O(n^2), Space Complexity: O(1)
    static int findSingleNumber(int[] arr){
        
        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j=0; j<arr.length; j++){
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return arr[i];
            }
        }

        return -1; // If no such element is found
    }

    // Better Approach: Using HashMap , Time Complexity: O(n), Space Complexity: O(n)
    // Total time: O(n) + O(n) = O(2n) = O(n)
    // time complexity explanation: First loop to fill the map takes O(n) time, second loop to find the single occurrence also takes O(n) time.
    static int findSingleNumber_better(int[] arr){
        java.util.HashMap<Integer,Integer> map = new java.util.HashMap<>();
        for(int num: arr){
            map.put(num,map.getOrDefault(num,0)+1); // Counting occurrences of each number
        }
        for(java.util.Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        
        return -1; // If no such element is found
    }

    // Optimized Approach: Using XOR , Time Complexity: O(n), Space Complexity: O(1)
    static int findSingleNumber_optimized(int[] arr){
        int result = 0;
        for(int num : arr){
            result ^= num; // XOR operation
        }
        return result;
    }
}
