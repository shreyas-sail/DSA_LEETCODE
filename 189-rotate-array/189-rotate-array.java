class Solution {
    public void rotate(int[] nums, int k) {
           int n = nums.length;
    int arr[] = new int[n];
    int j = n-k%n , i =0;
    while(i<n){
        arr[i] = nums[j%n];
        i++;
        j++;
    }
    for(int t =0; t<n; t++){
        nums[t] = arr[t];
    }  
    } 
}
    
   