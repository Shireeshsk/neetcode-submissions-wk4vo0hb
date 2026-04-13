class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0) return 1/helper(x,-1*n);
        return helper(x,n);
    }

    public double helper(double x,int n){
        if(n==1) return x;
        if(n%2==0){
            return helper(x*x,n/2);
        }
        else{
            return x*helper(x*x,n/2);
        }
    }
}
