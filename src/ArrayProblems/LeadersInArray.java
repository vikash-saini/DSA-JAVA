package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

/* Leader : element is greater than all the elements on its right
 * 
 */
public class LeadersInArray {
    public static void main(String[] args) {
        int[] nums = {10,22,12,4,3,6};
        List<Integer> list = findLeadersOptimized(nums);
        System.out.print("Leaders in Array: {");
        for(int num:list){
            System.out.print(num+" ");
        }
        System.out.print("}");
    }

    // Brute Force: TimeComplexity O(n)*O(n) = n*n(approax) , 
    // Space Complexity: O(n) here the space is used to return the output not to solve
    // O(n) is the worst case SC when all the elements are leaders e.g.[5,4,3,2,1]
    static List<Integer> findLeaders(int[] nums){
        List<Integer> leaders = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            boolean leader = true;
            for(int j=i; j<nums.length; j++){
                if (nums[j] > nums[i]) leader = false;
            }
            if (leader) {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }

    // Optimal: TimeComplexity O(n) 
    // Space Complexity: O(n) here the space is used to return the output 
    static List<Integer> findLeadersOptimized(int[] nums){
        List<Integer> leaders = new ArrayList<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            
            if (nums[i] > max) {
                leaders.add(nums[i]);
            }
            max = Math.max(max, nums[i]);
        }
        return leaders;
    }
}
