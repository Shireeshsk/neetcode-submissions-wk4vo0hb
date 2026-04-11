class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> list = new ArrayList<>();
        int t = 0;
        int b = mat.length-1;
        int l = 0;
        int r = mat[0].length-1;
        while(l<=r && t<=b){
            for(int i = l;i<=r;i++){
                list.add(mat[t][i]);
            }
            t++;
            for(int i =t;i<=b;i++){
                list.add(mat[i][r]);
            }
            r--;
            if(t<=b){
                for(int i = r;i>=l;i--){
                    list.add(mat[b][i]);
                }
                b--;
            }
            if(l<=r){
                for(int i = b;i>=t;i--){
                    list.add(mat[i][l]);
                }
                l++;
            }
        }
        return list;
    }
}
