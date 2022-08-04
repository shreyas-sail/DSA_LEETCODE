class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int a = 0;
        int b = 0;
        Set<Integer> s = new HashSet<>();
        
        for(int i:aliceSizes){
            a+=i;
        }
        
        for(int i:bobSizes){
            b+=i;
            s.add(i);
        }
        
        int delta = (b - a)/2;
        
        for(int x:aliceSizes){
            if(s.contains(x+delta)){
               return new int[]{x,x+delta}; 
            }
        }
        
        return new int[]{-1,-1};
    }
}