class Solution {
    public String reverseWords(String s) {
        String[] stList = s.split(" ");
        for(int i=0;i<stList.length;i++){
            stList[i] = reverseString(stList[i].toCharArray());
        }
        String str = new String();
        return str.join(" ",stList);
    }
    
    public String reverseString(char[] s) {
        int start = 0, end  = s.length -1;
        while(start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return new String(s);
    }
}