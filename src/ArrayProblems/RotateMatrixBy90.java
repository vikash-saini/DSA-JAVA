package ArrayProblems;

/* Rotate Image  */

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int rotated[][] = rotateMatrix(arr);
        // for (int i = 0; i < rotated.length; i++) {
        //     for (int j = 0; j < rotated.length; j++) {
        //         System.out.print(rotated[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        // optimized
        int arr2[][] = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println("");
        }
        rotateMatrix_optimized(arr2);
        // rotateMatrix_optimized2(arr2);
        System.out.println("After Rotating to 90 degree: ");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println("");
        }
    }

    // Brute Force: Time complexity O(N*N) to linearly iterate and put it into some other matrix.
    // Space Complexity: O(N*N) to copy it into some other matrix.
    static int[][] rotateMatrix(int[][] arr){
        int n = arr.length;
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n-i-1] = arr[i][j];
            }
        }
        return matrix;
    }

    /* 
     * Optimized : modify the same array instead of taking new Array
     * Time Complexity : O(N*N) + O(N*N/2)
     * Space COmplexity : O(1) not taking any extra space
     */
    static int[][] rotateMatrix_optimized(int[][] matrix){

        // Tranpose the MatrixImage TC:O(N*N) 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row of Matrix/Image TC: O(N*N/2)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        return matrix;
    }

    /* 
     * Optimized : modify the same array instead of taking new Array
     * Time Complexity : O(N*N) + O(N*N/2)
     * Space COmplexity : O(1) not taking any extra space
     */
    static int[][] rotateMatrix_optimized2(int[][] matrix){

        // Tranpose the MatrixImage 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row of Matrix/Image
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        return matrix;
    }
}
