class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,1)+1);
        }
        PriorityQueue<Pair> p = new PriorityQueue<Pair>(n, new PairComparator());
        for(Integer key:map.keySet()){
            p.offer(new Pair(key,map.get(key)));
        }
        int[] ans = new int[k];
        int i = 0;
        while(i<k){
            Pair c = p.poll();
            ans[i] = c.k;
            i++;
        }
        return ans;
    }
}
class PairComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair p1,Pair p2){
        if(p1.f < p2.f){
            return 1;
        }
        if(p1.f > p2.f){
            return -1;
        }
        return 0;
    }
}



class Pair{
    int k;
    int f;
    Pair(int k1,int f1){
        k = k1;
        f = f1;
    }
}