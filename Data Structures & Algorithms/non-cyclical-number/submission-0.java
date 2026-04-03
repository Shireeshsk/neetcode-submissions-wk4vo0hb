class Solution {
    public boolean isHappy(int n) {
        if(n==1) return true;
        if(n==4) return false;
        int sum = 0;
        int temp = n;
        while(temp>0){
            int last = temp%10;
            sum += last * last;
            temp = temp/10;
        }
        return isHappy(sum);
    }
}
