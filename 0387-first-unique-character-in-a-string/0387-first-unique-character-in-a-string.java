class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<n; i++){         //count freq. of every char. and put in hashmap. 
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c,0)+1);
        } 
        for(int i=0; i<n; i++){          //find 1st char. in hashmap whose freq. is 1.
            if(freq.get(s.charAt(i)) == 1) return i;
        }
        
        return -1;
    }
}