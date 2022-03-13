/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
         int l = 1 ,r = n,mid = 0;
        while(l<=r){
            mid = l + (r-l)/2;
            if(isBadVersion(mid) && ( !isBadVersion(mid-1) || mid == 0)){
                return mid;
            }
            if(!isBadVersion(mid)){
                l = mid+1;
            }else{
                r = mid -1;
            }
        }
        return mid;
    }
}