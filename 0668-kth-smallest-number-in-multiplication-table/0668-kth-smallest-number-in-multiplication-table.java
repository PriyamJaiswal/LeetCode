class Solution {
    public int findKthNumber(int m, int n, int k) {

        int low = 1, high = m * n, res = -1;
    
        while (low <= high) {

            int guess = (low + high)/2;

            int count = 0;  
            for (int row = 1; row <= m; row++) {         // count no. =< guess
                count += Math.min(n, guess / row);
            }

            if (count >= k) {
                res = guess;
                high = guess - 1;

            } else low = guess + 1;
        }
        return res;
    }
}