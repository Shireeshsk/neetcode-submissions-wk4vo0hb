class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int dista = a[0]*a[0]+a[1]*a[1];
            int distb = b[0]*b[0]+b[1]*b[1];
            return dista-distb;
        });
        for(int sk[] : points) pq.add(sk);
        int res[][] = new int[k][2];
        for(int i = 0;i<k && !pq.isEmpty();i++){
            res[i] = pq.remove();
        }
        return res;
    }
}
