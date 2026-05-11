class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0;
        int t = 0;
        for(int i : bills){
            if(i==5) f++;
            else if(i==10){
                if(f<=0) return false;
                t++;
                f--;
            }
            else{
                if(t<=0){
                    if(f<3) return false;
                    f -=3;
                }
                else{
                    if(f<1) return false;
                    f--;
                    t--;
                }
            }
        }
        return true;
    }
}