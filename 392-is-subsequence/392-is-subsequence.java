class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] t1 = s.toCharArray();
        char[] s1 = t.toCharArray();
        int n1 = s1.length,n2 = t1.length;
        int i = 0;
        int j = 0;
        
        while(i<n1 && j<n2){
            if(s1[i] == t1[j]){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j==n2;
    }
}