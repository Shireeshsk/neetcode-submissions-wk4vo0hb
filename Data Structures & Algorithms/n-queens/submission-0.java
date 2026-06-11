class Solution {
    public List<List<String>> solveNQueens(int n) {
        char arr[][] = new char[n][n];
        for(int i = 0;i<n;i++) Arrays.fill(arr[i],'.');
        List<List<String>> res = new ArrayList<>();
        helper(0,n,arr,res);
        return res;
    }
    public void helper(int r,int n,char arr[][],List<List<String>> res){
        if(r>=n){
            List<String> temp = new ArrayList<>();
            for(int i = 0;i<n;i++) temp.add(new String(arr[i]));
            res.add(temp);
            return;
        }
        for(int i = 0;i<n;i++){
            if(isValid(r,i,n,arr)){
                arr[r][i] = 'Q';
                helper(r+1,n,arr,res);
                arr[r][i] = '.';
            }
        }
    }

    public boolean isValid(int r,int c,int n,char arr[][]){
        for(int i = 0;i<n;i++){
            if(arr[i][c]=='Q') return false;
        }
        // Upper-left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') return false;
        }

        // Upper-right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 'Q') return false;
        }
        return true;
    }
}
