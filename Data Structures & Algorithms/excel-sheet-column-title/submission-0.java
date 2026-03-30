class Solution {
    public String convertToTitle(int coln) {
        StringBuilder sb = new StringBuilder();
        int res = coln;
        while(res>0){
            res--;
            int dig = res%26;
            sb.append((char)('A'+dig));
            res /=26;
        }
        return sb.reverse().toString();
    }
}