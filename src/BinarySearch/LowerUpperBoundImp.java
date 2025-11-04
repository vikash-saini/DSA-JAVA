package BinarySearch;

import java.util.Arrays;

/* 
 * Lower Bound Index: Smallest index is the index at which the number is nearest Greater or equals to the given number
 * arr[Index] >= x
 * Upper Bound: The index at which the number is Nearest greater than given number : arr[Index] > x
 */
public class LowerUpperBoundImp {
    public static void main(String[] args) {
        int[] nums = {3,4,6,7,9,12,16,17};
        int target = 18;
        System.out.println("Lower Bound for Value "+target+" is: "+findLowderBound(nums,target));
        System.out.println("Upper Bound for Value "+1+" is: "+findUpperBound(nums,1));
    }

    /* TC: O(logN) */
    int findLowderBound(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        int ans = nums.length;
        while (low<=high) {
            int mid = (low+high)/2;
            if (nums[mid] >= target ) {
                ans = mid;
                high = mid -1;
            }else {
                low = mid + 1;
            }

        }
        return ans;
    }

    /* TC: O(logN) */
    int findUpperBound(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        int ans = nums.length;
        while (low<=high) {
            int mid = (low+high)/2;
            if (nums[mid] > target ) {
                ans = mid;
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
