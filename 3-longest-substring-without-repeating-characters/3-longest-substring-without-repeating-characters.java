class Solution {
    public int lengthOfLongestSubstring(String s) {
         int l = 0,r =0 ,len = 0,n=s.length(); 
        Map<Character,Integer> hashMap = new HashMap<>();
        while(r<n){
            if(hashMap.containsKey(s.charAt(r)) && hashMap.get(s.charAt(r)) >= l ){
                l = hashMap.get(s.charAt(r)) +1;
            }
            len=Math.max(len,(r-l)+1);
            hashMap.put(s.charAt(r),r);
            r++;
        }
        return len;
    }
}