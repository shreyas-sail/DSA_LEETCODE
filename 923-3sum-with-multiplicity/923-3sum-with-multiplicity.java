class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = 0;final int mod = (int) (1e9 + 7);
        for(int  i = 0;i<=arr.length-2 ;i++){
            int lo = i+1 , high = arr.length -1 ,twoSumTarget = target - arr[i];
            while(lo<high){
                if(arr[lo]+arr[high] == twoSumTarget){
                    int cntlo=1, cnthi=1;
                    while (lo < high && arr[lo] == arr[lo+1]) {cntlo++; lo++;}
                    while (lo < high && arr[high] == arr[high-1]) {cnthi++; high--;}
                    if (lo == high) ans =(ans+cntlo*(cntlo-1)/2)%mod;
					// A[lo]!=A[hi]
                    else ans = (ans+cntlo*cnthi)%mod;
                    lo++; high--; 
                }
                else if(arr[lo]+arr[high] < twoSumTarget){
                    lo++;
                }else{
                    high--;
                }
            }
        }
        return ans;
    }
}