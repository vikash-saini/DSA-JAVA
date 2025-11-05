package ArrayProblems;

public class rotateByDplaces {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        int d = 2; // Number of places to rotate
        System.out.println("Array before rotation: ");
        printArray(arr);
        leftRotateByDPlaces(arr, d);
        System.out.println("Array after rotation by " + d + " places: ");
        printArray(arr);
    }

    // Rotate array to left by d places , Time Complexity: O(n + d), Space Complexity: O(d) used for temp array to store d elements
    static void leftRotateByDPlaces(int[] arr, int r){
        int d = r % arr.length; // Handle cases where d >= n if d=n or multiple of n, array remains same 
        int n = arr.length;
        int[] temp = new int[d];
        // Store first d elements in temp
        for(int i=0; i<=d-1; i++){
            temp[i] = arr[i];
        }
        // Shift the rest of the elements to the left
        for(int i=d; i<n; i++){
            arr[i - d] = arr[i];
        }
        // Copy the d elements from temp to the end of arr
        // for(int i=0; i<d; i++){
        //     arr[n - d + i] = temp[i];
        // }
        for(int i=n-d; i<n; i++){
            arr[i] = temp[i - (n-d)];
        }

    }

    static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Optimized Approach using Reversal Algorithm, Time Complexity: O(n), Space Complexity: O(1)
    static void leftRotateByDPlaces_optimized(int[] arr, int r){
        int d = r % arr.length; // Handle cases where d >= n
        int n = arr.length;
        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);
        // Step 2: Reverse remaining n-d elements
        reverse(arr, d, n - 1);
        // Step 3: Reverse the whole array
        reverse(arr, 0, n - 1);
    }
    static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
