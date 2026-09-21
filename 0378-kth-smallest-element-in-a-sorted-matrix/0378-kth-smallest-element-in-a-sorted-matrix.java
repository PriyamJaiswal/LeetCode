class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[][] a = matrix;

        int n = a.length, m = a[0].length;
        int low = a[0][0], high = a[n-1][m-1];
        int res = -1;

        while(low <= high){

            int guess = (low+high)/2;
            int ans = fun(a,n,m,guess);

            if( ans < k) low = guess+1;
            else{
                res = guess;
                high = guess-1;
            }
        }
        return res;
    }

    public int fun(int[][] a, int m, int n, int guess){
    
        int row = n-1, col = 0, count = 0;
        while(row >=0 && col < m){

            if(a[row][col] <= guess){
                count = count + row + 1;
                col++;
            }
            else row--;
        }
        return count;
    }
}