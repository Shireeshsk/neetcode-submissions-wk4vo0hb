class Solution {
    public void rotate(int[] arr, int k) {
        k = k%arr.length;
        helper(0,arr.length-1,arr);
        helper(0,k-1,arr);
        helper(k,arr.length-1,arr);
    }
    public void helper(int i ,int j,int arr[]){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}