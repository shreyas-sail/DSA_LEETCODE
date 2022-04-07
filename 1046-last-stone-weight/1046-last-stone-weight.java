class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int s:stones){
            pq.add(-s);
        }
        int  i =pq.size();
        while(pq.size() != 1){
            int stone1 = -pq.poll();
            int stone2;
            if(!pq.isEmpty())
                stone2 = -pq.poll();
            else
                break;
            System.out.println(stone1);
            System.out.println(stone2);
            
            int insertStone = Math.abs(stone1 - stone2);
            //System.out.println(insertStone);
            pq.add(-insertStone);
            System.out.println(pq);
            
        }
        return -pq.peek();
    }
}