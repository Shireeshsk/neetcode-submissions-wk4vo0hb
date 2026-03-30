class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int idx = arr.length-1;
        int res[] = new int[arr.length];
        while(idx>=0){
            while(!st.isEmpty() && arr[st.peek()]<=arr[idx]) st.pop();
            res[idx] = st.isEmpty()?0:st.peek()-idx;
            st.push(idx);
            idx--;
        }
        return res;
    }
}
