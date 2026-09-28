class Solution {
    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch,0)+1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.first - a.first);

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getValue(),String.valueOf(entry.getKey()) ) );
        } 
        StringBuilder res = new StringBuilder();

        Pair p = pq.poll();
        while(!pq.isEmpty()){

            Pair p2 = pq.poll();

            res.append(p.second);
            p.first--;

            if(p.first > 0) pq.offer(p);

            p=p2;
        }

        res.append(p.second);
        p.first--;

        if(p.first > 0) return "";

        return res.toString();
    }
}

class Pair{
    int first; //freq.
    String second; //char.

    Pair(int f, String s){
        first = f;
        second = s;
    }
}