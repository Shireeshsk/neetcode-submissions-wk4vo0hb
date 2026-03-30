class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(rowCheck(i,j,board[i][j],board) || colCheck(i,j,board[i][j],board) || matCheck(i,j,board[i][j],board)) return false;
                }
            }
        }
        return true;
    }
    public boolean rowCheck(int r ,int c,char ch,char mat[][]){
        for(int i = 0;i<mat[0].length;i++){
            if(i!=c && mat[r][i]==ch) return true;
        }
        return false;
    }

    public boolean colCheck(int r,int c,char ch,char mat[][]){
        for(int i = 0;i<mat.length;i++){
            if(r!=i && mat[i][c]==ch) return true;
        }
        return false;
    }

    public boolean matCheck(int r,int c,char ch,char mat[][]){
        int str = (r/3)*3;
        int stc = (c/3)*3;
        for(int i = str;i<str+3;i++){
            for(int j =stc;j<stc+3;j++){
                if((i!=r || j!=c)&& mat[i][j]==ch) return true;
            }
        }
        return false;
    }
}
