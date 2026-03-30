class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int k = Integer.MIN_VALUE;
        for(int i : arr) k = Math.max(k,i);
        int l = 1;
        int r = k;
        int res = r;
        while(l<=r){
            int mid = l+(r-l)/2;
            int time = helper(arr,mid);
            if(time<=h){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
    public int helper(int arr[],int k){
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            res += Math.ceil((double)arr[i]/k);
        }
        return res;
    }
}
