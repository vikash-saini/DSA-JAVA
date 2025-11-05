package BinarySearch;

public class MinInRotatedSortedDuplicates {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        // System.out.println("min: "+findMin(nums));
    }

    // TC: O(logN)
    // static int findMin(int[] nums) {
    //     int low = 0; int high = nums.length-1;
    //     int min = Integer.MAX_VALUE;
    //     while(low<=high){
    //         int mid = (low+high)/2 ;

    //         //If the search space is already sorted then arr[low] will always be smaller
    //         //in that search space
    //         if(nums[low] <= nums[high]){
    //             min = Math.min(min,nums[low]);
    //             break;
    //         }
    //         if(nums[low] <= nums[mid] ){
    //             min = Math.min(min,nums[low]);
    //             low = mid +1;
    //         }else if(nums[high] >= nums[mid]){
    //             min = Math.min(min,nums[mid]);
    //             high = mid - 1;
    //         }
    //     }
    //     return min;
    // }
}
