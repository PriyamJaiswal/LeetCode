class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int[][] projects = new int[n][2]; // [capital, profit]

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> a[0] - b[0]);  // Sort according to capital

        // Max heap based on profit
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while (k-- > 0) {

            while (i < n && projects[i][0] <= w) {  // Add all projects that we can currently afford
                pq.offer(projects[i][1]);
                i++;
            }
            
            if (pq.isEmpty())  return w;  // No project can be started
               
            w += pq.poll();     // Take maximum profit
        }

        return w;
    }
}