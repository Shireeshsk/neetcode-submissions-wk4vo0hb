class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mt = new HashMap<>();
        for(char ch : t.toCharArray()) mt.put(ch,mt.getOrDefault(ch,0)+1);
        Map<Character,Integer> map = new HashMap<>();
        int st = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        int h = 0;
        int n = mt.size();
        int l = 0;
        int minlen = Integer.MAX_VALUE;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(mt.containsKey(ch) && map.get(ch)==mt.get(ch)) h++;
            while(h==n){
                if((i-l+1)<minlen){
                    st = l;
                    minlen = i-l+1;
                }
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(mt.containsKey(s.charAt(l)) && map.get(s.charAt(l))<mt.get(s.charAt(l))) h--;
                if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                l++;
            }
        }
        return st==Integer.MAX_VALUE?"":s.substring(st,st+minlen);
    }
}
