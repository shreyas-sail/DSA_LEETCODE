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
        double min = 1e9;
        for(Character c:hashMap.keySet()){
            if(hashMap.get(c) == 1){
                min = Math.min(min,s.indexOf(c));
            }
        }
        return min == 1e9?-1:(int)min;
    }
}