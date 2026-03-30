class Solution {
    public int[] getConcatenation(int[] arr) {
        int res[] = new int[2*arr.length];
        int i = 0;
        int j = arr.length;
        while(j<res.length){
            res[i] = res[j] = arr[i];
            i++;
            j++;
        }
        return res;
    }
}