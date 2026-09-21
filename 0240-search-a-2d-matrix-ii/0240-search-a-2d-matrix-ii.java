class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[][] a = matrix;

        int n = a.length;
        int m = a[0].length;

        int row = n-1, col = 0;

        while(row >= 0 && col < m){

            if(a[row][col] == target) return true;

            if(a[row][col] > target) row--;
            else col++; 
        }
        return false;
    }
}