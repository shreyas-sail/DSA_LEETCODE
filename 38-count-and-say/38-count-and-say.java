class Solution {
    public String countAndSay(int n) {
        String s = "1";
        String temp = "";
        for(int i = 2;i<=n;i++){
            char[] c = s.toCharArray();
            System.out.println(s);
            temp = "";
            for(int j = 0;j<c.length;j++){
                int count = 1;
                char cur = c[j];
                
                while(j+1<c.length && c[j] == c[j+1]){ //111221 
                    j++;count++;
                    // System.out.println(c.length);
                }
                // System.out.println(count);
                // if(count>1) j-=1;
                temp += String.valueOf(count)+cur;
            }
            s = temp;
        }
        return s;
    }
}
// 1211