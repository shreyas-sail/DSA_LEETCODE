class Solution {
    public String countAndSay(int n) {
        String s = "1";
        String temp = "";
        for(int i = 2;i<=n;i++){
            char[] c = s.toCharArray();
            temp = "";
            for(int j = 0;j<c.length;j++){
                int count = 1;
                char cur = c[j];
                
                while(j+1<c.length && c[j] == c[j+1]){ //111221 
                    j++;count++;
                }
                temp += String.valueOf(count)+cur;
            }
            s = temp;
        }
        return s;
    }
}
// 1211