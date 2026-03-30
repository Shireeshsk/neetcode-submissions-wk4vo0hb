class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int i : arr){
            l = Math.max(l,i);
            r += i;
        }
        int res = r;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(helper(arr,mid,days)){
                res = Math.min(res,mid);
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
    public boolean helper(int arr[],int max,int d){
        int idx = 1;
        int curr = max;
        for(int i =0;i<arr.length;i++){
            if(curr-arr[i]<0){
                idx++;
                if(idx>d) return false;
                curr = max;
            }
            curr -= arr[i];
        }
        return true;
    }
}