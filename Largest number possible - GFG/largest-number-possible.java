// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int N, int S){
        // code here
        int [] nums = {0,1,2,3,4,5,6,7,8,9};
        String res ="";
        if(N == 1 && S == 0) return "0";
         if(S == 0) return "-1";
        for(int i=nums.length - 1; i>=0 && S != 0; i--){
            if((int)S/nums[i] > 0){
                int sumTaken = ((int) S/nums[i]) * nums[i];
                //System.out.println(nums[i]);
                res +=String.valueOf(nums[i]).repeat(S/nums[i]);
                S -= sumTaken;
                if(res.length()>N) return "-1";
            }
        }
        if(res.length() < N){
            int l = res.length();
            res+=String.valueOf(0).repeat(N-l);
        }
        return res;
    }
}