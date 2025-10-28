package ArrayProblems;

/* Dutch National Flag Algorithm: This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following
 * arr[0….low-1] contains 0. [Extreme left part]
 * arr[low….mid-1] contains 1.
 * arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
 * The middle part i.e. arr[mid….high] is the unsorted segment.
 */
public class sortZerosOnesTwos {
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2,1,2,0,0,0,1};
        sortWithDutchAlgo(arr);
        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num + "");
        }

    }
    
    // Brute force: using sorting , Time complexity : O(nlogn)   
    static void sortZerosOnesTwos_brute(int[] arr, int left, int right){
        if (left < right) {
            int mid = (left + right)/2;
            sortZerosOnesTwos_brute(arr, left, mid);
            sortZerosOnesTwos_brute(arr, mid + 1, right);
            // merge(arr, left, mid, right);
        }
    }

    // Better Approach : Time Complexity n + n = 2n
    // No extra storage used to SpaceComplexity O(1)
    static void sortArray(int[] arr){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = arr.length;

        // count number of 0s, 1s, 2s O(n)
        for(int i = 0; i<=n-1; i++){
            if(arr[i] == 0) count0++;
            if(arr[i] == 1) count1++;
            if(arr[i] == 2) count2++;
        }

        // insert in array in sorted manner
        // Combine TimeComplexity  of all 3 loops O(n)
        for(int i = 0; i<=count0-1; i++){
            arr[i] = 0;
        }
        for(int i = count0; i<=(count0+count1)-1; i++){
            arr[i] = 1;
        }
        for(int i = (count0+count1); i<=n-1; i++){
            arr[i] = 2;
        }
    }

    // Dutch National Flag Algorithm
    // Optimal Approach , Time Complexity O(n) SC O(1)
    static void sortWithDutchAlgo(int[] arr){
        int n = arr.length;
        int low =0, mid=0, high=n-1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                // swapping arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        
    }

}
