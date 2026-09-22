class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int[] a = nums;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(i=0; i<k; i++) pq.offer(a[i]);

        for(i=k; i<n; i++){
            if(a[i] <= pq.peek()) continue;
            pq.poll();
            pq.offer(a[i]);
        }
        return pq.peek();
    }
}