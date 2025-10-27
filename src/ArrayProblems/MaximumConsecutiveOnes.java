package ArrayProblems;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println("Maximum consecutive ones in the array: " + maxConsecutiveOnes(arr));
    }

    static int maxConsecutiveOnes(int[] arr){
        int count = 0;
        int maxcount = 0;
        for(int i=0; i<arr.length; i++){
            if (arr[i]==1) {
                count++;
                maxcount = Math.max(maxcount,count);
            }
            else {
                count = 0;
            }
        }

        return maxcount;
    }
}
