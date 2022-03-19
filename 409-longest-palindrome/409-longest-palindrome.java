class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i =0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }else{
                hashMap.put(s.charAt(i),1);
            }
        }
        int longestPali = 0;
        for(Character c: hashMap.keySet()){
            if(hashMap.get(c)/2>0){
                longestPali+=(hashMap.get(c)/2)*2;
                hashMap.put(c,hashMap.get(c)%2);
            }
        }
        for(Character c: hashMap.keySet()){
            if(hashMap.get(c)%2==1){
                longestPali+=1;
                break;
            }
        }
        return longestPali;
    }
}