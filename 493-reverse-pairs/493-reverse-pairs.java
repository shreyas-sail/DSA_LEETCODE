class Solution {
    public int count = 0;
    public int reversePairs(int[] nums) {
        int r = nums.length;
        mergeSort(0,r-1,nums);
        return count;
    }
    
    void mergeSort(int l,int r,int[] nums){
        if(l<r){
            int mid = l+(r-l)/2;
            mergeSort(l,mid,nums);
            mergeSort(mid+1,r,nums);
            merge(l,mid,r,nums);
        }
    }
    
    
    void merge(int l,int m,int r,int[] arr){
        int n1 = m - l + 1;
        int n2 = r - m;
        int leftIndex = l;
        int rightIndex = m + 1;
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
        int j = m+1;
        for(int i = l;i<=m;i++){
            while(j<=r && arr[i]>2*(long)arr[j]){
                j++;
            }
            count+=j-(m+1);
        }
  
        // Initial indexes of first and second subarrays
        int i = 0; j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                // System.out.print(L[i]);
                // System.out.println(R[j]);
                j++;
                
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}