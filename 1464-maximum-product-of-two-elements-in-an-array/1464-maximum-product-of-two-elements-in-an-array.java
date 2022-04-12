class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i:nums)
            pq.add(-1*i);
        int a = -1*pq.poll();
        int b = -1*pq.poll();
        return (a-1)*(b-1) ;
        
    }
}