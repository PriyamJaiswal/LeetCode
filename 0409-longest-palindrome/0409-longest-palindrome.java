class Solution {
    public int longestPalindrome(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        boolean odd = false;
        int res = 0;
        for(char c : map.keySet()){

            int val = map.get(c);
            if(val%2 == 0){
                res +=val;
            } 
            else{
                res += val-1;               
                odd = true;
            }
        }
        if (odd) res ++;         //if any odd freq. exists ->one char. can be placed in center;
        return res;
    }
}