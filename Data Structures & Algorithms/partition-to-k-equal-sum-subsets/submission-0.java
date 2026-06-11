class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int t = 0;
        for(int i : nums) t += i;
        if(t%k!=0) return false;
        boolean vis[] =new boolean[nums.length];
        return helper(0,0,k,t/k,nums,vis);
    }
    
    public boolean helper(int idx,int curr,int k,int target,int arr[],boolean vis[]){
        if(k==0) return true;
        if(curr==target){
            return helper(0,0,k-1,target,arr,vis);
        }
        for(int i = idx;i<arr.length;i++){
            if(vis[i]) continue;
            if(curr+arr[i]>target) continue;
            vis[i] = true;
            if(helper(i+1,curr+arr[i],k,target,arr,vis)) return true;
            vis[i] = false;
        }
        return false;
    }
}