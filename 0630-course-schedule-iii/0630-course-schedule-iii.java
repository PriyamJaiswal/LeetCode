class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;

        int[][] a = courses;                    // [duration, lastDay]

        Arrays.sort(a, (x, y) -> x[1] - y[1]);   // Sort by lastDay
                                                                    
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
                                                                   // Max heap -> largest duration on top
        int time = 0;
        for (int i = 0; i < n; i++) {

            int duration = a[i][0];
            int lastDay = a[i][1];

            time += duration;                    // Take this course
            pq.offer(duration);

            if (time > lastDay) {                      // Take this course
                     time -= pq.poll();                // Remove the course taking maximum time
            }
        }
        return pq.size();  
    }
}