class Solution {

    class Pair {
    int first;
    char second;

    Pair(int f, char s) {
        first = f;
        second = s;
    }
  }

    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> freq = new HashMap<>();   // task frequency
        HashMap<Character, Integer> free = new HashMap<>();   // task next seat where task can be used

        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            free.put(ch, 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> { if (a.first != b.first)
                            return b.first - a.first;
                      return b.second - a.second;
            });

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {   // Put all tasks into heap
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
        }

        int seat = 1;
        while (!pq.isEmpty()) {     

            ArrayList<Pair> pulled = new ArrayList<>();
 
            while (!pq.isEmpty()) {   // Inner while

                Pair p = pq.poll();
                char child = p.second;

                if (free.get(child) <= seat) {                // Task is available

                    if (p.first > 1)  pq.offer(new Pair(p.first - 1, p.second));  // Frequency decrease
                    free.put(child, seat + n + 1);                    // Next available seat
                    break;
                }
                else  pulled.add(p);                             // Task is in cooldown
                    
            }

            for (Pair p : pulled)   pq.offer(p);          // Put cooldown tasks back into heap

            seat++;                 // Move to next seat
        }
        return seat - 1;
    }
}