package BinarySearch;
/* 
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.
    This is Similar to finding a Lower Bound Index
 */
public class SearchInsertionPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6}; int target = 5; // Output: 2
        System.out.println("Lower Bound for Value "+target+" is: "+findLowderBound(nums,target));
    }

    /* TC: O(logN) */
    static int findLowderBound(int[] nums, int target){
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
}
