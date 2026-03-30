class Solution {
    public int maxArea(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int max = Integer.MIN_VALUE;
        while(l<r){
            int area = (int)Math.min(arr[l],arr[r])*(r-l);
            max = Math.max(area,max);
            if(arr[l]>arr[r]) r--;
            else l++;
        }
        return max;
    }
}
