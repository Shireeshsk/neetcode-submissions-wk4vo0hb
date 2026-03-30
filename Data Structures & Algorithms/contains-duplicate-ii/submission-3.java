class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        if(arr.length==1) return false;
        int l = 0;
        int r = k;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = l;i<=r && i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        if(map.size()<(k+1)) return true;
        r++;
        while(r<arr.length){
            map.put(arr[l],map.get(arr[l])-1);
            if(map.get(arr[l])==0){
                map.remove(arr[l]);
            }
            l++;
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            r++;
            if(map.size()<(k+1)) return true;
        }
        if(map.size()<(k+1)) return true;
        return false;
    }
}