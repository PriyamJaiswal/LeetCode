class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> freq = new HashMap<>();
        for(String i : words)
            freq.put(i, freq.getOrDefault(i,0)+1);

         PriorityQueue<String> pq = new PriorityQueue<>
             ((a,b) -> {
            if(!freq.get(a).equals(freq.get(b)))
                 return freq.get(a) - freq.get(b);
                 
            return b.compareTo(a);     
    });   

            for(String i : freq.keySet()){
                pq.offer(i);

            if(pq.size() > k)
                     pq.poll();
            }

        List<String> res = new ArrayList<>();
         while(!pq.isEmpty()){
            res.add(pq.poll());
         }
         Collections.reverse(res);
         return res;  
    }
}