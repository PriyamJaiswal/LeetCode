class Solution {
    public int[] searchRange(int[] nums, int target) {
        
                int start = first(nums,target);
                int end = last(nums,target);

                return new int[]{start,end};
    }

    private int first(int[] nums,int target){   //for starting position
        int n= nums.length;
        int x = target;

        int low =0;
        int high = n-1;
        int res =-1;
        while(low <= high){

            int guess= (low+high)/2;
            if(nums[guess] > x) high=guess-1;
            else if(nums[guess] < x) low=guess+1;
            else{
                res = guess;
                high = guess-1;
            }
        }
       return res; 
    }

    private int last(int[] nums,int target){ //for ending position
        int n= nums.length;
        int x = target;

        int low =0;
        int high = n-1;
        int res =-1;
        while(low <= high){

            int guess= (low+high)/2;
            if(nums[guess] > x) high=guess-1;
            else if(nums[guess] < x) low=guess+1;
            else{
                res = guess;
                low = guess+1;
            }
        }
       return res; 
    }
}