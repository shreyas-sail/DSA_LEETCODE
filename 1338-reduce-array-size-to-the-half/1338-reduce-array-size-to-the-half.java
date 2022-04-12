class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        HashMap<Integer,Integer> hsMap = new HashMap<>();
        int halfSize = arr.length - (arr.length/2);
        for(int i :arr){
            if(!hsMap.containsKey(i)){
                hsMap.put(i,1);
            }else{
                hsMap.put(i,hsMap.get(i)+1);
            }
        }
         for(int i:hsMap.values())
             pq.add(i);
        int sum = 0 ;
        int counter = 0;
        for(int i = 0;i<pq.size();i++){
            counter+=1;
            sum +=pq.poll();
            if(sum >= halfSize)
                break;
        }
        return counter;
    }
}