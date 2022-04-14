class Solution {
    public int countGoodSubstrings(String s) {
        char[] arr = s.toCharArray() ;
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0,l = 0 ,r = 0;
        while(l<arr.length && r<arr.length){
            if(map.containsKey(arr[r])){
                map.put(arr[r],map.get(arr[r])+1);
            }else{
                 map.put(arr[r],1);
            }
           
             if(r-l+1 < 3){
                 r++;
                 
             }else if(map.size() == 3 ){
                ans+=1;
                map.remove(arr[l]);l++;r++;
             }else{
                 if(map.containsKey(arr[l])){
                     map.put(arr[l],map.get(arr[l])-1);
                     if(map.get(arr[l]) == 0){
                         map.remove(arr[l]);
                     }
                 }
                 l++;r++;
             }
            
            
        }
        return ans;
    }
}