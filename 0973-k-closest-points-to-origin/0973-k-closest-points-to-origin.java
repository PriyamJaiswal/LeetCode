class Pair{
    int first;
    int second;

    Pair(int f, int s){
        first = f;   //distance
        second = s;  //index
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
         PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.first - a.first);

        for(int i=0; i<points.length; i++){

        int x = points[i][0], y = points[i][1];
        int distance = x * x + y * y;

        Pair curr = new Pair(distance, i);
    
         if(pq.size() < k){
            pq.offer(curr);
            continue;
          }     
         if(distance < pq.peek().first){
            pq.poll();
            pq.offer(curr);     
          }         
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair curr = pq.poll();

            int index = curr.second;

            res[i][0] = points[index][0];
            res[i][1] = points[index][1];
        }
        return res;
    }
}

