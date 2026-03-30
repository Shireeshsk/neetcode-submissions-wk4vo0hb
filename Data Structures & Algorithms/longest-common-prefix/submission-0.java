class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        for(int i = 1;i<strs.length;i++){
            if(str.length()>strs[i].length()){
                str = strs[i];
            }
        }
        for(int i = 0;i<strs.length;i++){
            str = helper(str,strs[i]);
        }
        return str;
    }

    public String helper(String str,String g){
        int idx = 0;
        while(idx<str.length()){
            if(str.charAt(idx)!=g.charAt(idx)) break;
            idx++;
        }
        return str.substring(0,idx);
    }
}