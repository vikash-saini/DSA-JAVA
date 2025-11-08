package BinarySearchOnAnswers;

public class findSqrtofnumber {
    public static void main(String[] args) {
        int n = 28;
        int low = 1; int high = 28; int ans = 1;
        while (low<=high) {
            int mid = (low+high)/2;
            int val = mid*mid;
            if (val <= n) {
                ans = mid;
                low = mid +1;
            }else{
                high = mid -1 ;
            }
        }
        System.out.println(ans);
    }
}
