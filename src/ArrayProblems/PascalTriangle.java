package ArrayProblems;

import java.util.ArrayList;

/* Pascal Triangle: an infinite triangular array of numbers where each number is the sum of the two directly above it.
    It starts with a single 1 at the top, and every row begins and ends with 1
 * P1: Print element from given row and col. r=5, c=3
 * P2: Print Nth row from parcal Triangle
 * P3: Print parcal of N rows 
 * Note: Nth row contains N columns
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int rows = 6;

        ArrayList<ArrayList<Long>> parcal = generateParcal(rows);
        for (ArrayList<Long> row : parcal) {
            for (Long num : row) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
        System.out.println("3rd Element of 6th Row: "+ findNCR(6-1,3-1));
        System.out.println("4th Element of 5th Row: "+ findNCR(5-1,4-1));
        System.out.println("6th Row: "+ generateRow(6));
    }

    /* Problem3: Print parcal of N rows 
     * Optimal Approach: TC- O(N) * O(N) =n^2
     * SC: Using space to return the result - O(N) + O(N)
    */
    static ArrayList<ArrayList<Long>> generateParcal(int n){
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();

        for (int row = 1; row <=n; row++) {
            ArrayList<Long> eachRow = new ArrayList<>();
            long res = 1;
            eachRow.add(res);
            for (int col = 1; col<row; col++) {
                res = res*(row-col);
                res = res/col;
                eachRow.add(res);
            }
            ans.add(eachRow);
        }
        return ans;
    }

    /* Problem1: Find element at given row and col
     * Time Complexity: O(column)
     */
    static int findNCR(int row, int col){
        /* Formula
         * nCr = n!/(r!*(n-r)!) // n:Row-1, r:Col-1
         * Elemnt at R,C will be NCR of R-1 and C-1
         * Element(row,col)=>(row-1,col-1) = row!/(col!*(row-col)!)
         * e.g: R=6,C=4 => (6-1,4-1)=> 5!/(3!*(3-2)!) => 5*4*3*2!/(3*2*1)(2!) => 5*4*3/(3*2*1) 
         * now observe R value will multiply till C times . that is: 3
         * R=6,C=3 =(6-1,3-1) => 5*4/(2*1)
         */

         int res = 1;
         for (int i = 0; i<col; i++) {
            res = res*(row-i);
            res = res/(i+1); 
         }
         return res;
    }

    /* Problem2: Print Nth row of Pascal
    Approach 1 : can use findNCR() to get each element of each but TC will be O(N) * O(N) =n^2
     * Optimal: TC: O(n)
     */
    static ArrayList<Integer> generateRow(int n){
        ArrayList<Integer> row = new ArrayList<>();
        int res = 1;
        row.add(res);
        for (int i = 1; i <n; i++) {
            res = res*(n-i);
            res = res/i;
            row.add(res);
        }
        return row;
    }
}
