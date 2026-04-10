class Solution {
    public int[] plusOne(int[] arr) {
        int buf = 1;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i]+buf>9){
                arr[i] = 0;
                buf = 1;
            }
            else{
                arr[i] = arr[i]+buf;
                buf = 0;
            }
        }
        if(buf==0) return arr;
        int res[] = new int[arr.length+1];
        res[0] = buf;
        for(int i = 1;i<res.length;i++){
            res[i] = arr[i-1];
        }
        return res;
    }
}
