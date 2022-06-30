class Solution {
    public int deleteAndEarn(int[] nums) {
        int n  = 10001;
        int[] arr = new int[n];
        for(int num:nums){
            arr[num] +=num;
        }
        int[] res=new int[10001];
        Arrays.fill(res, -1);
        //System.out.println(Arrays.toString(arr));
        int l = nums.length;
        return robHelper(arr,0,res);
    }
    
    int robHelper(int[] arr,int i,int[] res){
        if(i >=arr.length){
            return 0;
        }
        if(res[i] !=-1) return res[i];
        int notTake = robHelper(arr,i+1,res);
        int take = Integer.MIN_VALUE;
        take = arr[i]+ robHelper(arr,i+2,res);
        return res[i] = Math.max(take,notTake);
    }
}