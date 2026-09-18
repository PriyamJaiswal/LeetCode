class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int[] arr = piles;
        int n = arr.length;

        int low = 1;
        int high = 0;
        for (int a : arr) {
            high = Math.max(high, a);
        }

        int res = -1;

        while(low <= high){
            int guess = (low+high)/2;
            long kokoHr = findHour(arr,n,guess);

            if(kokoHr > h) low=guess+1;
            else {
                res = guess;
                high=guess-1;
            } 
        }
        return res;
    }

    public long findHour(int[] a,int n,int speed){
        long h = 0;
        for(int i=0; i<n; i++){
            h = h + (a[i]/speed);
            if(a[i] % speed != 0) h++;
        }
        return h;
    }
}