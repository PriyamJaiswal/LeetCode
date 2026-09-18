class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int[] a = piles;
        int n = piles.length;

        int low = 1;
        int high = max(a);
        int res = -1;

        while(low <= high){
            int guess = (low+high)/2;
            long kokoHr = findHour(a,n,guess);

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


    public int max(int[] a){
        int res = 0;
        for(int i=0; i < a.length; i++){
          res = Math.max(res,a[i]);  
        }
        return res;
    }
}