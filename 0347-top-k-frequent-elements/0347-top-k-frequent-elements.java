class Pair {
    int first;
    String second;

    Pair(int f, String s) {
        first = f;
        second = s;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {                      // Frequency map
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(             // Min heap
            (a, b) -> {
                if (a.first != b.first)  return a.first - b.first; 
                
                return a.second.compareTo(b.second);
            }
        );

        for (Map.Entry<Integer, Integer> i : freq.entrySet()) {       // Keep only k most frequent elements

            int element = i.getKey();
            int frequency = i.getValue();

            Pair curr = new Pair(frequency, String.valueOf(element));

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }

            if (curr.first > pq.peek().first) {
                pq.poll();
                pq.offer(curr);
            }
        }

        int[] res = new int[k];                       // for  answer
        for (int i = 0; i < k; i++) {
            res[i] = Integer.parseInt(pq.poll().second);
        }

        return res; 
    }
}