class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i =0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(rating[j] < rating[i]){
                    left[i]++;
                }
            }
        }
        //System.out.println(Arrays.toString(left));
        for(int  i = n-1;i>=0;i--){
            for(int j = n-1;j >= i; j--){
                if(rating[j] < rating[i]){
                    right[i]++;
                }
            }
        }
        // System.out.println(Arrays.toString(right));
        int res = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(rating[j] < rating[i]){
                    res+=left[j];
                }
            }
        }
        
        for(int  i = n-1;i>=0;i--){
            for(int j = n-1;j >= i; j--){
                if(rating[j] < rating[i]){
                    res+=right[j];
                }
            }
        }
        return res;
        
    }
}