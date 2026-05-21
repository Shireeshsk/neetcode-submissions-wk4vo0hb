class Solution {
    public int maxProduct(int[] arr) {
        int l = 1;
        int r = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(l==0) l = 1;
            if(r==0) r = 1;
            l *= arr[i];
            r *= arr[arr.length-i-1];
            max = Math.max(max,Math.max(l,r));
        }
        return max;
    }
}
