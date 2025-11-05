package BinarySearch;

public class CountDuplicateOccurance {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,11,13};
        int target = 8;
        // Using LowerUpperBound Method
        LowerUpperBoundImp lb= new LowerUpperBoundImp();
        int first = lb.findLowderBound(arr, target);
        if (first == -1) {
            System.out.println("Occurance: -1");
        }else{
            System.out.print("{");
            System.out.print(lb.findUpperBound(arr, target) - first -1 + 1);
            System.out.print("}");
        }
    }
}
