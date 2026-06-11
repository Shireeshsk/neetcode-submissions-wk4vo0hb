class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        helper(0,digits,new StringBuilder(),res,map);
        return res;
    }
    public void helper(int idx,String str,StringBuilder sb,List<String> res,Map<Integer,String> map){
        if(idx>=str.length()){
            res.add(sb.toString());
            return ;
        }
        for(char ch : map.get(str.charAt(idx)-'0').toCharArray()){
            sb.append(ch);
            helper(idx+1,str,sb,res,map);
            sb.setLength(sb.length()-1);
        }
    }
}
