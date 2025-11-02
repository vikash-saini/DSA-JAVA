package BinarySearch;

/* 
 * Binary Search : Always works only on sorted Array
 * Real World e.g : Dictionary
 * Take between low and hight index as search Space for the target element. 
 * FInd Middle point as (low+high)/2 , check if the target falls in the space between low->mid OR Mid->high
 * if target<mid the new search space low->Mid-1 , if target > high then mid+1->high
 * if mid==target , return mid
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {3,4,6,7,9,12,16,17};
        int target = 16;
        int lowIndex = 0;
        int highIndex = nums.length-1;
        System.out.println(target+" is at index: "+findWithBinarySearch(nums,target));
        System.out.println(12+" is at index: "+binarySearchRecursion(nums,lowIndex,highIndex,12));
        System.out.println(6+" is at index: "+findWithLinearSearch(nums,6));
    }

    /* Binary Search
     * Time Complexity: O(logN)
     */
    static int findWithBinarySearch(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        while (low<high) {
            int mid = (low+high)/2;
            if (target == nums[mid]) {
                return mid;
            }else if (target < nums[mid]) {
                high = mid -1;
            }else {
                low = mid + 1;
            }

        }
        return -1;
    }

    /* Binary Search
     * Time Complexity: O(logN)
     */
    static int binarySearchRecursion(int[] nums, int low, int high, int target){
        
        if (low > high) {
            return -1;
        }
        int mid = (low+high)/2;
        if (target == nums[mid]) {
            return mid;
        }
        else if (target < nums[mid]) {
            return binarySearchRecursion(nums, low,mid-1, target);
        }
        return binarySearchRecursion(nums, mid+1,high, target);
    }

    /* Linear Search
     * Time Complexity: O(N)
     */
    static int findWithLinearSearch(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
