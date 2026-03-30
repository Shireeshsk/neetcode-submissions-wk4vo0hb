class Solution {
    public boolean search(int[] arr, int target) {
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==target) return true;
            if(arr[l]<arr[mid]){
                if(target>=arr[l] && arr[mid]>target) r = mid-1;
                else l = mid+1;
            }
            else if(arr[l]>arr[mid]){
                if(target>arr[mid] && target<=arr[r]) l = mid+1;
                else r = mid-1;
            }
            else l++;
        }
        return false;
    }
}