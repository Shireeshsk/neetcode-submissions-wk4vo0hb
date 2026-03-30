class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        int c = 0;
        while(l<=r){
            int sum = arr[l]+arr[r];
            if(sum<=limit){
                c++;
                l++;
                r--;
            }
            else{
                if(arr[r]<=limit){
                    c++;
                    r--;
                }
            }
        }
        return c;
    }
}