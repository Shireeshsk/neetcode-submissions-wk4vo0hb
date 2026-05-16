class Solution {
    public boolean isAlienSorted(String[] words, String o) {
        int order[] = new int[26];
        for(int i = 0;i<o.length();i++){
            order[o.charAt(i)-'a'] = i;
        }
        for(int i = 1;i<words.length;i++){
            String s1 = words[i-1];
            String s2 = words[i];
            int j = 0;
            while(j<s1.length() && j<s2.length()){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1!=c2){
                    if(order[c1-'a']>order[c2-'a']) return false;
                    break;
                }
                j++;
            }
            if(j==s2.length() && s1.length()>s2.length()) return false;
        }
        return true;
    }
}