class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        set.add("0000");
        int t = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                String sk = q.remove();
                if(sk.equals(target)) return t;
                for(String n : helper(sk)){
                    if(!set.contains(n)){
                        q.add(n);
                        set.add(n);
                    }
                }
            }
            t++;
        }
        return -1;
    }

    public List<String> helper(String str){
        List<String> res = new ArrayList<>();
        for(int i = 0;i<4;i++){
            char arr[] = str.toCharArray();
            arr[i] = (char)(((arr[i]-'0'+1)%10)+'0');
            res.add(new String(arr));
            arr = str.toCharArray();
            arr[i] = (char)(((arr[i]-'0'+10-1)%10)+'0');
            res.add(new String(arr));
        }
        return res;
    }
}