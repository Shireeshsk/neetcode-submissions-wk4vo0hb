class Solution {
    public int calPoints(String[] arr) {
        Stack<Integer> st = new Stack<>();
        for(String str : arr){
            if(str.equals("D")){
                st.push(2*st.peek());
            }
            else if(str.equals("C")){
                st.pop();
            }
            else if(str.equals("+")){
                int up = st.pop();
                int temp = up + st.peek();
                st.push(up);
                st.push(temp);
            }
            else{
                st.push(Integer.parseInt(str));
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}