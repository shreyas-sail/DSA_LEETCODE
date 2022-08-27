            // System.out.println(mid);
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = -1;
        for(int i:piles){
            high = Math.max(i,high);
        }
        int low = 1;
        int ans = -1;
        while(low<=high){
            int mid =  low + (high - low)/2; //(low+high)/2;
            if(isPossible(piles,h,mid)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[] arr, int h, int k)
    {
        int i = 0;
        while(h > 0 && i < arr.length)
        {
            int x = arr[i];
            h -= (int)Math.ceil((double)x/(double)k);
            if(h < 0)
                return false;
            i++;
        }
        if(i == arr.length)
            return true;
        return false;
    }
}