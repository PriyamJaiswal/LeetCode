class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        fun(n,0,0,curr,res);
        return res;
    }

    void fun(int n, int open, int close, StringBuilder curr, List<String> res){

        if(open==n && close==n){
            res.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append('(');
            fun(n, open+1, close, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close < open){
            curr.append(')');
            fun(n, open, close+1, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}