class MedianFinder {
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() || minHeap.peek() < num){
            minHeap.offer(num); //[1]  -- 1
        }else{
            maxHeap.offer(num); //[ 3,2 ] -- 2
        }
        
        if(minHeap.size() > maxHeap.size()+1){
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        }
        if(minHeap.size()+1 < maxHeap.size()){
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (double) (minHeap.peek() + maxHeap.peek())/2.0;
        }
        if(minHeap.size() > maxHeap.size()){
            return (double) minHeap.peek();
        }
        else{
            return (double) maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */