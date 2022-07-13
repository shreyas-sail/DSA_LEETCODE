class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int h = n-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]>arr[mid+1] && arr[mid-1]<arr[mid]){
                return mid;
            }
            if(arr[mid]<arr[mid+1]){
                l = mid+1;
            }else if(arr[mid-1]>arr[mid+1]){
                h = mid-1;
            }
        }
        return -1;
    }
}