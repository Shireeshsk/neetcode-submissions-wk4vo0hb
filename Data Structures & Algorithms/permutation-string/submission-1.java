class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0;i<=s2.length()-s1.length();i++){
            String str = s2.substring(i,i+s1.length());
            if(isValid(str,s1)) return true;
        }
        return false;
    }
    public boolean isValid(String str,String s1){
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : str.toCharArray()){
            if(!map.containsKey(ch)) return false;
            map.put(ch,map.get(ch)-1);
            if(map.get(ch)==0){
                map.remove(ch);
            }
        }
        return map.size()==0;
    }
}
