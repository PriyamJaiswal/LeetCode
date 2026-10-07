class Solution {
    public int hammingWeight(int n) {

        int res = 0;
        while(n>0){       //kernighan's algorithm
            res++;
            n = n & (n-1);
        }
        return res;
        
        // int res = 0;
        // while(n>0){

        //     int bit = n % 2;
        //     if(bit == 1) res++;

        //     n = n/2;   //change n
        // }
        // return res;
    }
}