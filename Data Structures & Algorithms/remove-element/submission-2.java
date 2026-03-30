class Solution {
    public int removeElement(int[] arr, int val) {
        if(arr.length==0) return 0;
        int i = 0;
        int j = 1;
        while(j<arr.length){
            if(arr[i]==val && arr[j]==val){
                j++;
            }
            else if(arr[i]==val && arr[j]!=val){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
            else{
                i++;
                j++;
            }
        }
        if(arr[i]==val) return i;
        return i+1;
    }
}