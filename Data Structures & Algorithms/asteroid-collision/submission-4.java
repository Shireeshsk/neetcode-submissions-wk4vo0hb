class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            if(st.isEmpty()) st.push(arr[i]);
            else if(!isCollision(st.peek(),arr[i])) st.push(arr[i]);
            else if(Math.abs(st.peek())==Math.abs(arr[i])) st.pop();
            else{
                while(!st.isEmpty() && isCollision(st.peek(),arr[i]) && Math.abs(st.peek())<Math.abs(arr[i]) ) st.pop();
                if(!st.isEmpty() && isCollision(st.peek(),arr[i]) && Math.abs(st.peek()) == Math.abs(arr[i])) st.pop();
                if(st.isEmpty() || !isCollision(st.peek(),arr[i])) st.push(arr[i]);
            }
        }
        if(st.isEmpty()) return new int[]{};
        int res[] = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
    public boolean isCollision(int st,int val){
        if(st>0 && val<0) return true;
        return false;
    }
}