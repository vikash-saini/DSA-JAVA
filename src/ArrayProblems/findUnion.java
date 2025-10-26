package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

/* Union of array will not store duplicate elements
    * Given two arrays, find the union of the two arrays and return it as a new array.
 */
public class findUnion {
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {4, 5, 6, 7, 8};
        int[] unionArray = findUnion(arr1, arr2);
        System.out.print("Union of the two arrays is: ");
        printArray(unionArray);
        // If both arrays are sorted
        ArrayList<Integer> unionArray_optimized = findUnion_optimized(arr1, arr2);
        System.out.print("Union of the two arrays (Optimized for sorted arrays) is: ");
        for(int num : unionArray_optimized){
            System.out.print(num + " ");
        }
    }

    // Brute Force Approach using HashSet to avoid duplicates
    // Time Complexity: O(m + n), Space Complexity: O(m + n) in worst case when there are no common elements
    static int[] findUnion(int[] arr1, int[] arr2){
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for(int num : arr1){
            set.add(num); 
        }
        for(int num : arr2){
            set.add(num);
        }
        int[] unionArr = new int[set.size()];
        int index = 0;
        for(int num : set){
            unionArr[index++] = num;
        }
        return unionArr;
    }

    static ArrayList<Integer> findUnion_optimized(int [] arr1, int[] arr2){
        // This function can be implemented if both arrays are sorted
        // Using two pointers technique to find union in O(m + n) time and O(1) space excluding output array
        // Space Complexity: O(m + n) for output array in worst case when there are no common elements
        ArrayList<Integer> unionList = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int i =0, j=0;
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                if(unionList.size() == 0 || unionList.get(unionList.size() - 1) != arr1[i]){
                    unionList.add(arr1[i]);
                }
                i++;
            } else if(arr2[j] < arr1[i]){
                if(unionList.size() == 0 || unionList.get(unionList.size() - 1) != arr2[j]){
                    unionList.add(arr2[j]);
                }
                j++;
            } else {
                // Both are equal
                if(unionList.size() == 0 || unionList.get(unionList.size() - 1) != arr1[i]){
                    unionList.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        // Add remaining elements of arr1
        while(i < n){
            if(unionList.size() == 0 || unionList.get(unionList.size() - 1) != arr1[i]){
                unionList.add(arr1[i]);
            }
            i++;
        }
        // Add remaining elements of arr2
        while(j < m){
            if(unionList.size() == 0 || unionList.get(unionList.size() - 1) != arr2[j]){
                unionList.add(arr2[j]);
            }
            j++;
        }

        return unionList;
    }

    static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
