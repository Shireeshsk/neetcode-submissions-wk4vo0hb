class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int res = 0;
        for(int i : arr){
            int c = 0;
            int temp = i;
            while(set.contains(temp)){
                // set.remove(temp);
                temp++;
                c++;
            }
            res = Math.max(res,c);
        }
        return res;
    }
}
