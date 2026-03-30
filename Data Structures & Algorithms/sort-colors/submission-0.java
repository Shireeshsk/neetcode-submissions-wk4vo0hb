class Solution {
    public void sortColors(int[] arr) {
        int z = 0;
        int o = 0;
        int t = 0;
        for(int i : arr){
            if(i==0) z++;
            if(i==1) o++;
            if(i==2) t++;
        }
        int idx = 0;
        while(idx<arr.length){
            while(z>0){
                arr[idx++] = 0;
                z--;
            } 
            while(o>0){
                arr[idx++] = 1;
                o--;
            } 
            while(t>0){
                arr[idx++] = 2;
                t--;
            } 
        }
    }
}