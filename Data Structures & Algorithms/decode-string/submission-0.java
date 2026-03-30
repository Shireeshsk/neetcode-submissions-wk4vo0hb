class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch==']'){
                StringBuilder sb = new StringBuilder();
                while(!st.peek().equals("[")) sb.insert(0,st.pop());
                st.pop();
                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) num.insert(0,st.pop());
                String temp = sb.toString().repeat(Integer.parseInt(num.toString()));
                st.push(temp);
            }
            else{
                st.push(String.valueOf(ch));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) res.insert(0,st.pop());
        return res.toString();
    }
}