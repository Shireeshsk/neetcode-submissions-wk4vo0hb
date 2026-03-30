class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while(i<word.length() && j<abbr.length()){
            if(!Character.isDigit(abbr.charAt(j))){
                if(word.charAt(i)!=abbr.charAt(j)) return false;
                i++;
                j++;
            }
            else{
                int num = 0;
                if(abbr.charAt(j)=='0') return false;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                    num = (num*10) + (abbr.charAt(j)-'0');
                    j++;
                }
                i += num;
            }
        }
        return i==word.length() && j==abbr.length();
    }
}