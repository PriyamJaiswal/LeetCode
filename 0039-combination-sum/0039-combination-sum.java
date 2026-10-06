class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        int sum = 0;
        int idx = 0;

        fun(candidates, n, idx, diary, sum, res, target);
        return res;
    }

    void fun(int[] a, int n, int i, List<Integer> diary, int sum, List<List<Integer>> res, int k){

        if(i == n) {
            if(sum == k){                        //Base case
                res.add(new ArrayList<>(diary));
            }
            return;
        }

        fun( a, n, i+1, diary, sum, res, k); //nhi liye

        if(sum + a[i] <= k){       //take this choice
           
           diary.add(a[i]);
           sum+=a[i];
           fun( a, n, i, diary, sum, res, k);

           diary.remove(diary.size() -1); //undo
           sum -= a[i];
        }
    }
}