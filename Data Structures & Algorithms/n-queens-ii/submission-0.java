class Solution {
    public int totalNQueens(int n) {
        char arr[][] = new char[n][n];
        for(int i = 0;i<n;i++) Arrays.fill(arr[i],'.');
        int c[] = {0};
        helper(0,n,arr,c);
        return c[0];
    }

    public void helper(int r,int n,char arr[][],int c[]){
        if(r>=n){
            c[0]++;
            return;
        }
        for(int i = 0;i<n;i++){
            if(isValid(r,i,n,arr)){
                arr[r][i] = 'Q';
                helper(r+1,n,arr,c);
                arr[r][i] = '.';
            }
        }
    }

    public boolean isValid(int r,int c,int n,char arr[][]){
        for(int i = 0;i<n;i++){
            if(arr[i][c]=='Q') return false;
        }

        for(int i = r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=='Q') return false;
        }

        for(int i = r-1,j=c+1;i>=0 && j<n;i--,j++){
            if(arr[i][j]=='Q') return false;
        }
        return true;
    }
}