class Solution {
    public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] a = nums;

    Stack<Integer> st = new Stack<>();
    for(int i = n-2; i>=0; i--) st.push(a[i]);

    int[] res = new int[n];
    res[0] = -1;
    
    for(int i = n-1; i>=0; i--){
         
        while(!st.isEmpty() && st.peek() <= a[i]) {
            st.pop();
        } 
        if (st.isEmpty()) res[i] = -1;
        else res[i] = st.peek();

        st.push(a[i]);
    }
    return res;
    }
}