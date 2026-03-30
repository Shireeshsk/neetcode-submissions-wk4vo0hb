class Solution {
    class Pair{
        int pos;
        int speed;
        Pair(int pos,int speed){
            this.pos = pos;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] pos, int[] sp) {
        Pair arr[] = new Pair[pos.length];
        for(int i = 0;i<pos.length;i++){
            arr[i] = new Pair(pos[i],sp[i]);
        }
        Arrays.sort(arr,(a,b)->{
            return b.pos-a.pos;
        });
        Stack<Double> st = new Stack<>();
        for(Pair sk : arr){
            st.push((double)(target-sk.pos)/sk.speed);
            if(st.size()>=2 && st.peek()<=st.get(st.size()-2)) st.pop();
        }
        return st.size();
    }
}
