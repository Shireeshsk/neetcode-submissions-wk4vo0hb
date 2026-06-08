class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        Map<String,Integer> map = new LinkedHashMap<>();
        DSU dsu = new DSU(acc.size());
        for(int i = 0;i<acc.size();i++){
            for(int j = 1;j<acc.get(i).size();j++){
                String str = acc.get(i).get(j);
                if(map.containsKey(str)){
                    dsu.union(i,map.get(str));
                }
                else{
                    map.put(str,i);
                }
            }
        }

        Map<Integer,List<String>> res = new HashMap<>();
        for(int i = 0;i<acc.size();i++) res.put(i,new ArrayList<>());
        for(String str : map.keySet()){
            int parent = dsu.findParent(map.get(str));
            res.get(parent).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i : res.keySet()){
            if(res.get(i).size()!=0){
                Collections.sort(res.get(i));
                List<String> temp = new ArrayList<>();
                temp.add(acc.get(i).get(0));
                temp.addAll(res.get(i));
                ans.add(temp);
            }
        }
        return ans;
    }

    class DSU{
        int parent[];
        DSU(int n){
            this.parent = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
            }
        }

        public int findParent(int n){
            if(parent[n]==n) return n;
            return parent[n] = findParent(parent[n]);
        }

        public void union(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu==pv) return;
            parent[pu] = pv;
        }
    }
}