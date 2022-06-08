class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0) return n == 1 ? 1 : -1;
        int[] trustCount = new int[n+1];
        for(int[] person:trust){
            trustCount[person[1]]++;
            trustCount[person[0]]--;
        }
        for(int i = 0;i<n+1;i++){
            if(trustCount[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}