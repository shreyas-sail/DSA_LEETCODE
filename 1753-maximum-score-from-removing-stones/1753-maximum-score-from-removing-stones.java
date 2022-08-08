class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        int score =0;
        q.offer(a);
        q.offer(b);
        q.offer(c);
        int pop1 = -1 ,pop2 = -1;
        while(q.size()>1){
            pop1 = q.poll()-1;
            pop2 = q.poll()-1;
            if(pop1>0)
                q.offer(pop1);
            if(pop2>0)
                q.offer(pop2);
            score++;
        }
        return score;
    }
}