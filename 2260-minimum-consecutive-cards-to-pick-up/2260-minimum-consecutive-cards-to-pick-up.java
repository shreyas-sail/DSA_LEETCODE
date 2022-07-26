class Solution {
    public int minimumCardPickup(int[] cards) {
        int mini = Integer.MAX_VALUE;
        int n = cards.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i =0;i<n;i++){
            if(map.containsKey(cards[i])){
                mini = Math.min(mini,i-map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }
        return mini == Integer.MAX_VALUE?-1:mini;
    }
}