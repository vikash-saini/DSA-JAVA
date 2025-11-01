package ArrayProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
 * Majority Element by Floor(n/3), n:size of array
 * floor function is a mathematical function that rounds a given number down to the greatest integer less than or equal to it. 
 * It is denoted as ⌊x⌋ or floor(x). For example, ⌊6.359⌋ is 6 and ⌊-1342⌋ is -14. 
 * There will maximum=2 and min=0 elements will present which are in Majority or greater than floor(n/3)
 * 
 */
public class MajorityElement_Part2 {
    public static void main(String[] args) {
        int[] arr = {2,4,2,2,5,1,1,2,2,2,1,2,1,1,1,1};
        List majorityElements = findMajorityElement(arr);
        System.out.println(majorityElements);
    }

    // Moore's Voting algorithm
    // Time Complexity: n+n = 2n, Space complexity: O(1)
    static List findMajorityElement(int[] arr){
        List list = new ArrayList<>();
        int count1 = 0, ele1 = Integer.MIN_VALUE;
        int count2 = 0, ele2 = Integer.MIN_VALUE;
        int majority = (arr.length/3) + 1;

        for(int i=0; i<arr.length; i++){
            if (count1 == 0 && arr[i] != ele2) {
                count1 = 1;
                ele1 = arr[i];
            }else if (count2 == 0 && arr[i] != ele1) {
                count2 = 1;
                ele2 = arr[i];
            }else if (arr[i] == ele1) {
                count1++;
            }else if (arr[i] == ele2) {
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        // verify if elements occurs more than floor(n/3) times
        // this step will not require if it is given that the majority element always exists in the array, in this case direclty return the ele
        count1=0; count2=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele1) {
                count1++;
            }
            if (arr[i] == ele2) {
                count2++;
            }
        }
        if (count1 > majority) list.add(ele1);
        if (count2 > majority) list.add(ele2);
        return list;
    }

    /* Brute: Loop throgh array and count occurance of each element , if(arr[i][j] == majority) . add into list
     * TC: N*N = O(N^2)
     * SC: O(2) == O(1) , storing only Two element in list 
     */

    /* Better: Use HshMap and store each element from arr as list and occurance as value. 
     * Loop through HasMap if(map.getValue[i] > floor(n/3)) add into list and return
     * TC: Iterate arr and store elements in HashMap : O(N)*O(1), Iterate Hash and add majority elemnt in list :O(N)
     * Total: O(N) + O(N) = N^2
     * SC: HashMap :O(N), List: O(N) = O(2) two elements
     */
     

    /* 
     * Slightly Better than above HashMap approach 
     * TC: O(N)
     * SC: O(N)
     */
    static List findMajorityHashMap(int[] arr){
        List list = new ArrayList<>(); 
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = (int) (arr.length/3) + 1;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            if (map.get(arr[i]) == min) {
                list.add(arr[i]);
            }
            if (list.size()==2) break;
        }
        return list;
    }    
}
