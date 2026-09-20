class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[][] a = matrix;
        int x = target;
        int n = a.length;
        int m = a[0].length;

        int low=0, high=n-1, row=-1;     //Find the row
        while(low <= high){

            int guess= (low+high)/2;

            if(a[guess][0] == x) return true;

            if(a[guess][0] < x){
                row = guess;
                low = guess+1;
            }else high = guess-1;
        }

        if(row == -1) return false;      //No possible row

        low = 0; high = m-1;
        while(low <= high){              //Binary search inside row
                      
            int guess = (low+high)/2;

            if(a[row][guess] == x) return true;
            
            if(a[row][guess] < x) low = guess+1;
            else high = guess-1; 
        }
        return false;
    }
}