class CountSquares {
    Map<List<Integer>,Integer> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> temp = Arrays.asList(point[0],point[1]);
        map.put(temp,map.getOrDefault(temp,0)+1);
    }
    
    public int count(int[] point) {
        int res = 0;
        int px = point[0];
        int py = point[1];
        for(List<Integer> p : map.keySet()){
            int x = p.get(0);
            int y = p.get(1);
            if(Math.abs(px-x)!=Math.abs(py-y) || px==x || py==y){
                continue;
            }
            res += map.get(p) * map.getOrDefault(Arrays.asList(x,py),0)*map.getOrDefault(Arrays.asList(px,y),0);
        }
        return res;
    }
}
