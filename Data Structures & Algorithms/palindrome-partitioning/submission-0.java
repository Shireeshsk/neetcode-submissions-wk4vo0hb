class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(0,s,new ArrayList<>(),res);
        return res;
    }

    public void helper(int st,String s,List<String> list,List<List<String>> res){
        if(st>=s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = st;i<s.length();i++){
            if(helper(st,i,s)){
                list.add(s.substring(st,i+1));
                helper(i+1,s,list,res);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean helper(int st,int end,String s){
        while(st<end){
            if(s.charAt(st)!=s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
}
