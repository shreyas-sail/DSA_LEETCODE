class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                int temp = hashMap.get(s.charAt(i));
                hashMap.put(s.charAt(i) ,temp+1);
            }else{
                hashMap.put(s.charAt(i) ,1);
            }
        }
        for(int i = 0;i<s.length();i++){
            if(hashMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}