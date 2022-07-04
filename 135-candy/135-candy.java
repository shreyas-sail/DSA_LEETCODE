class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        for(int i = 1;i < n ;i++){
            if(ratings[i-1]<ratings[i])
                left[i] = left[i-1]+1;
            else
                left[i] = 1;
        }
        for(int i = n-2;i>=0 ;i--){
            if(ratings[i]>ratings[i+1])
                right[i] = right[i+1]+1;
            else
                right[i] = 1;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans += Math.max(left[i],right[i]);
        }
        return ans;
        
    }
}