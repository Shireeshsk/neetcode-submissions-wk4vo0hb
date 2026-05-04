class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,n,new StringBuilder(),res);
        return res;
    }
    public void helper(int open,int close,StringBuilder sb ,List<String> list){
        if(open<0 || close<0) return;
        if(open==0 && close==0){
            list.add(sb.toString());
            return ;
        }
        if(open!=0){
            sb.append("(");
            helper(open-1,close,sb,list);
            sb.setLength(sb.length()-1);
        }
        if(close>open){
            sb.append(")");
            helper(open,close-1,sb,list);
            sb.setLength(sb.length()-1);
        }
    }
}
