class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int res[] = new int[num1.length()+num2.length()];
        for(int i = num2.length()-1;i>=0;i--){
            for(int j = num1.length()-1;j>=0;j--){
                int temp = (num1.charAt(j)-'0')*(num2.charAt(i)-'0');
                int curr = temp + res[i+j+1];
                res[i+j+1] = curr%10;
                res[i+j] += curr/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx<res.length && res[idx]==0) idx++;
        while(idx<res.length) sb.append(res[idx++]);
        return sb.toString();
    }
}
