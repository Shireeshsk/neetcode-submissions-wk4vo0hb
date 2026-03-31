class TimeMap {
    Map<String,Map<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            if(map.get(key).containsKey(timestamp)){
                map.get(key).put(timestamp,value);
            }
            else{
                map.get(key).put(timestamp,value);
            }
        }
        else{
            map.put(key,new HashMap<>());
            map.get(key).put(timestamp,value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        int idx = -1;
        for(int i : map.get(key).keySet()){
            if(i<=timestamp){
                idx = Math.max(i,idx);
            }
        }
        return idx==-1?"":map.get(key).get(idx);
    }
}
