class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int n = nums.length;
        int rIndex =0;
        int[] maxOfAllKSize = new int[n-k+1];
        for(int i = 0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <=nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                maxOfAllKSize[rIndex++] = nums[dq.peek()];
            }
        }
        return maxOfAllKSize;
    }
}