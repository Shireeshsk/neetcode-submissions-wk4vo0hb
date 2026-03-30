class Solution {
    public int[] productExceptSelf(int[] arr) {
        int zero = 0;
        int prod = 1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0) zero++;
            else prod *= arr[i];
        }
        if(zero>1){
            return new int[arr.length];
        }
        int res[] = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            if(zero>0){
                res[i] = arr[i]==0?prod:0;
            }
            else res[i] = prod/arr[i];
        }
        return res;
    }
}  
