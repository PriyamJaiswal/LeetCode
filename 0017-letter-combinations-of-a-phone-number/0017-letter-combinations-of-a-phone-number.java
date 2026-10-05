class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();

         if (n == 0)   return new ArrayList<>();

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder diary = new StringBuilder();

        fun(digits, n, 0, map, diary, res);
        return res;
}

    void fun(String s,int n, int i, HashMap<Character, String> map,
                                 StringBuilder diary, List<String> res) {

    
        if (i == n) {
            res.add(diary.toString());
            return;
        }

        String choice = map.get(s.charAt(i));

        for (int j = 0; j < choice.length(); j++) {    // try all choice
           
            diary.append(choice.charAt(j));    // take
            fun(s, n, i + 1, map, diary, res);    // Recurse
            diary.deleteCharAt(diary.length() - 1); //undo
        }
    }
}