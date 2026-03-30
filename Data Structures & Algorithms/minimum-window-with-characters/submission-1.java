class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> demo = new HashMap<>();
        for(char ch : t.toCharArray()) demo.put(ch,demo.getOrDefault(ch,0)+1);
        int l = 0;
        int have = 0;
        int need = demo.size();
        int minLen = Integer.MAX_VALUE;
        int st = -1;
        for(int r= 0;r<s.length();r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(demo.containsKey(ch) && demo.get(ch).equals(map.get(ch))) have++;
            while(have==need){
                if((r-l+1)<minLen){
                    st = l;
                    minLen = r-l+1;
                }
                char lc = s.charAt(l);
                map.put(lc,map.get(lc)-1);
                if(demo.containsKey(lc) && map.get(lc)<demo.get(lc)) have--;
                l++;
            }
        }
        return st==-1?"":s.substring(st,st+minLen);
    }
}
