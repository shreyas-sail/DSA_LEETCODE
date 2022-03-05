class Solution {
    public boolean checkIfExist(int[] arr) {
        if(arr.length == 1 || arr.length <=0 ) return false;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = 0 ,j=0;
        while(i<arr.length && j<arr.length){
            int doub = arr[i]*2;
            if(i!=j && (doub == arr[j] || arr[i]/2 == arr[j])){
                System.out.println(i);
                System.out.println(j);
                return true;
            }
            else if(doub>arr[j] )
                j++;
            else
                i++;
        }
        return false; // [-10,2,3,5]
    }
}