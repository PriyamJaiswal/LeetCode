class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int k = target;
        int[] a = nums;

        int low=0;
        int high=n-1;
        int res = -1;

        while(low <= high){
            int guess = (low+high)/2;

            if(a[guess] == k) return guess;

            if(a[guess] > a[n-1]){          

                if(a[guess] < k) low = guess+1;
                else{
                 if(a[0] > k) low = guess+1;
                 else high = guess-1;
                }
            }else{

                if(a[guess] > k) high = guess-1;
                else{
                 if(a[n-1] < k) high = guess-1;
                 else low = guess+1;
                }
            }
        }
        return -1;
    }
}