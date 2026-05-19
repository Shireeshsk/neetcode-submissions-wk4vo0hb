class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(arr[0]);
        for(int i = 1;i<arr.length;i++){
            int temp[] = res.get(res.size()-1);
            if(arr[i][0]<=temp[1]){
                temp[1] = Math.max(temp[1],arr[i][1]);
            }
            else{
                res.add(arr[i]);
            }
        }
        return res.toArray(new int[0][]);
    }
}
