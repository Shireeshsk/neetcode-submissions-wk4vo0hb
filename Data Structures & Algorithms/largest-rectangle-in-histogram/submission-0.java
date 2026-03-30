class Solution {
    public int largestRectangleArea(int[] arr) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();
            right[i] = st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        st.clear();
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();
            left[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        for(int i = 0;i<arr.length;i++){
            int width = right[i] - left[i] - 1;
            int area = arr[i]*width;
            max = Math.max(max,area);
        }   
        return max;
    }
}
