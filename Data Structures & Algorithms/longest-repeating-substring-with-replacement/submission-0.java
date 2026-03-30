class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int maxf = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int r = 0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            maxf = Math.max(maxf,map.get(s.charAt(r)));
            while((r-l+1)-maxf>k){
                char ch = s.charAt(l);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) map.remove(ch);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
