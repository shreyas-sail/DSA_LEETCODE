class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int s:stones){
            pq.add(-s);
        }
        while(pq.size() != 1){
            int stone1 = -pq.poll();
            //int stone2;
            //if(!pq.isEmpty())
                int stone2 = -pq.poll();
            //else
                //break;
            pq.add(-1 * Math.abs(stone1 - stone2));
            
        }
        return -pq.peek();
    }
}