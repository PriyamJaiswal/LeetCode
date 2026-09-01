class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i=0; i<n; i++){    //keep or not top element

            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek() == s.charAt(i)){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }

        while(!st.isEmpty()){        //stack element store in string
            res.append(st.peek());
            st.pop();
        }
        return res.reverse().toString();   //need to reverse string bcz stack always pop reverse value  
    }
}