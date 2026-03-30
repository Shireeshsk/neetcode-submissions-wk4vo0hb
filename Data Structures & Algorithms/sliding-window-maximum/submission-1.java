class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int res[] = new int[arr.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        int idx = 0;
        while(r<arr.length){
            while(!dq.isEmpty() && arr[r]>arr[dq.peekLast()]) dq.removeLast();
            dq.addLast(r);
            if(l>dq.peekFirst()) dq.removeFirst();
            if((r-l+1)>=k){
                res[idx++] = arr[dq.peekFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
