package BinarySearch;

/* 
 * This Solution works only Unique element array not with duplicates
 * 1. FInd the sorted half from mid 
 * 2. store the smallest from that sorted half and eliminate that half
 * 3. search in unsorted half, compare minimun stored 
 * 
 */
public class MinInRotatedSorted {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println("min: "+findMin(nums));
        System.out.println("Total no. of Rotation: "+ findRotaions(nums));
    }

    // TC: O(logN)
    static int findMin(int[] nums) {
        int low = 0; int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2 ;

            //If the search space is already sorted then arr[low] will always be smaller
            //in that search space
            if(nums[low] <= nums[high]){
                min = Math.min(min,nums[low]);
                break;
            }
            if(nums[low] <= nums[mid] ){
                min = Math.min(min,nums[low]);
                low = mid +1;
            }else if(nums[high] >= nums[mid]){
                min = Math.min(min,nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

    /* 
     * The Index of minimum value in rotated sorted array will equals to the number of rotation in array
     * arr[MIN] , MIN = no. of rotations
     */
    static int findRotaions(int[] nums) {
        int low = 0; int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        int index = 0;
        while(low<=high){
            int mid = (low+high)/2 ;

            //If the search space is already sorted then arr[low] will always be smaller
            //in that search space
            if(nums[low] <= nums[high]){
                if (nums[low] < min) {
                    min = nums[low];
                    index = low;
                }
                break;
            }
            if(nums[low] <= nums[mid] ){
                if (nums[low] < min) {
                    min = nums[low];
                    index = low;
                }
                low = mid +1;
            }else if(nums[high] >= nums[mid]){
                if (nums[mid] < min) {
                    min = nums[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
