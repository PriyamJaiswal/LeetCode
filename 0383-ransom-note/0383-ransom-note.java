class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int r = ransomNote.length();
        int m = magazine.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++){
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i=0; i<r; i++){
            char c = ransomNote.charAt(i);
            
            if(!map.containsKey(c) || map.get(c) == 0)  return false; //key isn't in map or value is zero
            map.put(c,map.get(c)-1);  //If the value in the magazine is not zero, then we will subtract 1. 
        }
        return true;
    }
}