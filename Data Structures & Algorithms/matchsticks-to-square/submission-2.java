class Solution {
    public boolean makesquare(int[] arr) {
        int t = 0;
        for(int i :arr) t+=i;
        if(t%4!=0) return false;
        boolean vis[] = new boolean[arr.length];
        return helper(0,0,t/4,0,arr,vis);
    }
    public boolean helper(int idx,int curr,int target,int s,int arr[],boolean vis[]){
        if(s==3) return true;
        if(curr==target){
            return helper(0,0,target,s+1,arr,vis);
        }
        for(int i = idx;i<arr.length;i++){
            if(vis[i]) continue;
            if(curr+arr[i]>target) return false;
            vis[i] = true;
            if(helper(i+1,curr+arr[i],target,s,arr,vis)) return true;
            vis[i] = false;
        }
        return false;
    }
}