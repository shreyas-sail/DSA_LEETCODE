class Solution {
    public boolean validPalindrome(String s) {
        int count = 0;
        int first = 0, last = s.length() - 1;
        while(first<=last){
            if(s.charAt(first) != s.charAt(last)){
                return isPali(s,first+1,last) || isPali(s,first,last-1);
            }
            first++;
            last --;
        }
        
        return true;
    }
    
    private boolean isPali(String s,int first,int last){
        while(first<=last){
            if(s.charAt(first) != s.charAt(last)){
                return false;
            }
            first++;
            last --;
        }
        return true;
    }
}