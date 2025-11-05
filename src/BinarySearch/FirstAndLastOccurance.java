package BinarySearch;

import java.util.Arrays;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,11,13};
        
        // Linear Search O(N)
        int[] res = findOccurance(arr, 8);
        System.err.print("Linear Search: {");
        for (int num : res) {
            System.err.print(num+" ");
        }
        System.err.print("}");
        
        // Binary Search : TC O(logN)
        int target = 6;
        int[] range = searchRange(arr,target);
        System.out.println("Binary Search: "+Arrays.toString(range));

        // Using LowerUpperBound Method
        LowerUpperBoundImp lb= new LowerUpperBoundImp();
        int first = lb.findLowderBound(arr, target);
        if (first == -1) {
            System.out.println("LowerUpperBound: -1,-1");
        }else{
            System.out.print("LowerUpperBound: {");
            System.out.print(first+","+(lb.findUpperBound(arr, target) - 1));
            System.out.print("}");
        }

        // Count Occurance of duplicate values
        System.out.println();
    }

    /* Linear Search: TC O(n) */
    static int[] findOccurance(int[] nums,int target){
        int[] pair = new int[2];
        int first = -1; int second =-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && first == -1) {
                first = i ; 
                second = i;
            }else if (nums[i] == target && first != -1) {
                second = i;
            }
        }
        return new int[]{first,second};
    }

    static int[] searchRange(int[] nums, int target) {
        int first = firstOccurance(nums,target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int second = lastOccurance(nums,target);
        return new int[]{first,second};
    }
    static int firstOccurance(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid + 1;
            }
            
        }
        return ans;
    }

    static int lastOccurance(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                ans = mid;
                low = mid+1;
            } else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid - 1;
            }
            
        }
        return ans;
    }

}
