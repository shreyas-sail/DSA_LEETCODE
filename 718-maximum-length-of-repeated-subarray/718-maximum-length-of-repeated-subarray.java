class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m =nums2.length;
        int[][] memo = new int[n+1][m+1];
        int result  = 0;
        
        for(int i = 0;i<=n;i++){
            for(int j = 0 ;j<=m;j++){
                if( i == 0 || j == 0){
                    memo[i][j] = 0;
                }else if(nums1[i-1] == nums2[j -1]){
                    memo[i][j] = memo[i-1][j-1]+1;
                    result = Math.max(result,memo[i][j]);
                }else{
                    memo[i][j] = 0;
                }
            }
        }
        
        return result;
    }
}