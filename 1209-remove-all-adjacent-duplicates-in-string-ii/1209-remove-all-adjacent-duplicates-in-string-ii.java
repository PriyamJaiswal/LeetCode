class Solution {

    static class pair{
        char first;
        int second;
        pair(char first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<pair> st = new Stack<>();
        
        for(int i=0; i<n; i++){
        char c = s.charAt(i);

        if(st.empty()){               //if stack is empty
            st.push(new pair(c,1));
            continue;
        }               
         if(st.peek().first != c) {    //if current char. is different
             st.push(new pair(c,1));
             continue;
         }
         if(st.peek().second < k-1){    //same char. but count less than k
            pair p = st.peek();
            st.pop();
            st.push(new pair(p.first, p.second + 1));
            continue;
         }
         st.pop();                      //count already k-1 and add current (count becomes k so remove it)

        }
        //build ans from stack
         StringBuilder res = new StringBuilder();
         while(!st.empty()){
            pair p = st.peek();
            st.pop();
            while(p.second-- > 0){
                res.append(p.first);
            }
         }
         return res.reverse().toString();                                             
    }
}