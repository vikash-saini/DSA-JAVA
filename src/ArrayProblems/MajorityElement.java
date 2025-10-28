package ArrayProblems;
/* Majority Element:
 * Majority element is the one which apears more than N/2 times , N:size of the Array
 * Note: even if a element appear N/2 time, it will not be considered as majority element. 
 * it should be more than N/2 times always
 */

 /* Moore's Voting Algorithm :is a two-pass, two-phase algorithm to find a potential majority element (one that appears more than \(N/2\) times) in a sequence.
  * First, choose a candidate from the given set of elements if it is the same as the candidate element, increase the votes. 
    Otherwise, decrease the votes if votes become 0, select another new element as the new candidate
  */
public class MajorityElement {
    public static void main(String[] args){
        int[] arr = {2,4,2,2,5,1,1,2,2,2,1,1,1,1,1,1,1};
        int ele = findMajorityElement(arr);
        System.out.print("Majority element n/2: "+ele);
    }

    // Moon's Voting algorithm
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
}
