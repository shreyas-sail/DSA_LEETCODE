class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // [4,5,0,-2,-3,1]
        // [4,9,9, 7,4,5]   3+1+1   []
        HashMap<Integer,Integer> hashS = new HashMap<Integer,Integer>(); 
        hashS.put(0,1);
        int counter = 0,sum = 0;
        
        for(int i = 0;i<nums.length ; i++){
           sum += nums[i];
           int rem = sum%k;
           if(rem<0){
               rem+=k;
           }
           if(hashS.containsKey(rem)){
               counter+=hashS.get(rem);
               hashS.put(rem,hashS.get(rem)+1);
           }else{
               hashS.put(rem,1);
           }
           // if(rem<0)
           //    hashS.put(rem,hashS.getOrDefault(rem,1)+1);
           // else
           //  hashS.put(rem,hashS.getOrDefault(rem,1)+1);
             
        }
        
        return counter;
    }
}