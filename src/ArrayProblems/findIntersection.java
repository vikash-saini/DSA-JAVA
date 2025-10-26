package ArrayProblems;

public class findIntersection {
    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5,5,6,8,8,9};
        int[] arr2 = {4,5,5,5,6,7,8,8};
        int[] intersectionArray = findIntersectionNumber(arr1, arr2);
        System.out.print("Intersection of the two arrays is: ");
        printArray(intersectionArray);
        // If both arrays are sorted
        int[] intersectionArray_optimized = findIntersectionNumber_optimized(arr1, arr2);  
        System.out.print("Intersection of the two arrays (Optimized for sorted arrays) is: ");
        printArray(intersectionArray_optimized);
    }

    // Brute Force Approach: Time Complexity: O(n*m), Space Complexity: O(min(n,m)) for intersection array in worst case 
    static int[] findIntersectionNumber(int[] arr1, int[] arr2){
        java.util.ArrayList<Integer> intersectionList = new java.util.ArrayList<>();
        int[] visited = new int[arr2.length]; // To keep track of visited elements in arr2
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if(arr1[i] == arr2[j] && visited[j] == 0){
                    visited[j] = 1; // Mark as visited
                    intersectionList.add(arr1[i]);
                    break; // Move to next element in arr1
                }
                if (arr1[i] < arr2[j]) break; // Since arrays are sorted, no need to check further
            }
        }
        // Convert ArrayList to array
        int[] intersectionArr = new int[intersectionList.size()];
        for(int i=0; i<intersectionList.size(); i++){
            intersectionArr[i] = intersectionList.get(i);
        }
        return intersectionArr;
    }

    static int[] findIntersectionNumber_optimized(int[] arr1, int[] arr2){
        // This function can be implemented if both arrays are sorted
        // Using two pointers technique to find intersection in O(n + m) time and O(min(n, m)) space for intersection array in worst case
        java.util.ArrayList<Integer> intersectionList = new java.util.ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
               
                intersectionList.add(arr1[i]);
                
                i++;
                j++;
            } else if(arr1[i] < arr2[j]){
                i++;
            } else {
                j++;
            }
        }
        // Convert ArrayList to array
        int[] intersectionArr = new int[intersectionList.size()];
        for(int k=0; k<intersectionList.size(); k++){
            intersectionArr[k] = intersectionList.get(k);
        }
        return intersectionArr;
    }

    static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
