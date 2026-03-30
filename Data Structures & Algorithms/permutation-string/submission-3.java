class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int first[] = new int[26];
        int var[] = new int[26];

        for(int i = 0;i<s1.length();i++){
            first[s1.charAt(i)-'a']++;
            var[s2.charAt(i)-'a']++;
        }
        if(isMatch(first,var)) return true;
        int idx = 0;
        for(int i = s1.length();i<s2.length();i++){
            var[s2.charAt(idx++)-'a']--;
            var[s2.charAt(i)-'a']++;
            if(isMatch(first,var)) return true;
        }
        return false;
    }

    public boolean isMatch(int a[],int b[]){
        for(int i = 0;i<26;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}
