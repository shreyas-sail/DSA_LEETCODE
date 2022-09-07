class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        res.add(intervals[0]);
        for(int  i = 1;i<intervals.length;i++){
            int[] prevRange = res.get(res.size()-1);
            if(prevRange[0]<=intervals[i][0] && intervals[i][0] <=prevRange[1]){
                prevRange[1] =  Math.max(prevRange[1],intervals[i][1]);
                res.set(res.size()-1,prevRange);
            }
            else{
                res.add(intervals[i]);
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}