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

            if(a[guess] > a[n-1]){      //part 1    

                if(a[guess] < k) low = guess+1; //move right side
                else{
                 if(a[0] > k) low = guess+1;    //move right side
                 else high = guess-1;           //move left side
                }
            }else{                      //part 2 

                if(a[guess] > k) high = guess-1;  //move left side
                else{
                 if(a[n-1] < k) high = guess-1;   //move left side
                 else low = guess+1;              //move right side
                }
            }
        }
        return -1;
    }
}