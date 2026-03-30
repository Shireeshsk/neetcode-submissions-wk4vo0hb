class Solution {
    public int[] sortArray(int[] arr) {
        for(int i = arr.length-1;i>=0;i--){
            boolean flag = true;
            for(int j = 1;j<=i;j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        return arr;
    }
}