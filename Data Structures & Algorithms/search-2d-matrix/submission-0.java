class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int t = 0;
        int b = mat.length-1;
        int c = mat[0].length-1;
        while(t<=b){
            int mid = t+(b-t)/2;
            if(mat[mid][0]>target) b=mid-1;
            else if(mat[mid][c]<target) t= mid+1;
            else{
                int l = 0;
                int r = mat[0].length-1;
                while(l<=r){
                    int m = l+(r-l)/2;
                    if(mat[mid][m]==target) return true;
                    else if(mat[mid][m]>target) r=m-1;
                    else l = m+1;
                }
                return false;
            }
        }
        return false;
    }
}
