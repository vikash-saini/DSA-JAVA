package ArrayProblems;

public class checkIfSorted {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        System.out.println("Is the array sorted? " + isSorted(arr));
    }

    static boolean isSorted(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
