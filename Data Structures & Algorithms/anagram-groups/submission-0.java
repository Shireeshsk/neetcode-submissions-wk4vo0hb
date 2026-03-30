class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String sk : strs){
            char ch[] = sk.toCharArray();
            Arrays.sort(ch);
            String newS = new String(ch);
            if(!map.containsKey(newS)){
                map.put(newS,new ArrayList<>());
            }
            map.get(newS).add(sk);
        }
        List<List<String>> res = new ArrayList<>();
        for(String sk : map.keySet()){
            res.add(map.get(sk));
        }
        return res;
    }
}
