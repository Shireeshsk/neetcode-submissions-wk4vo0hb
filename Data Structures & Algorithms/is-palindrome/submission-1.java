class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        String strs[] = s.split(" ");
        for(String str : strs){
            for(char ch : str.toCharArray()){
                if((ch>='a' && ch<='z')||(ch>='0' && ch<='9')){
                    sb.append(ch);
                }
            }
        }
        return helper(sb.toString());
    }
    public boolean helper(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
