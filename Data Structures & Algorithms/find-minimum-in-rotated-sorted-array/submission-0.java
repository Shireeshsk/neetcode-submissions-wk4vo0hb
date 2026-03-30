class Solution {
    public int findMin(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int res = Integer.MAX_VALUE;
        while(l<=r){
            if(arr[l]<arr[r]){
                res = Math.min(res,arr[l]);
                break;
            }
            int mid = l+(r-l)/2;
            res = Math.min(res,arr[mid]);
            if(arr[mid]<=arr[r]){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
}
