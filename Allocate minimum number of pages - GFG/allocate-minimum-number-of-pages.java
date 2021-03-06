// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int A[], int N, int M) 
    {
        //code here
        int high =0;
        for(int i = 0 ;i <N;i++){
            high +=A[i]; 
            
        }
        int low = A[0] ;
        int res = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(allocationPossible(mid,M,N,A)){
                res = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
    
    static boolean allocationPossible(int barrier,int M,int N,int[] A){
        int numPage = 0;
        int studentC = 1;
        for(int i = 0 ;i <N;i++){
            if(A[i]>barrier) return false;
            if(numPage + A[i]>barrier){
                studentC++;
                numPage = A[i];
            }else{
              numPage+=A[i]; 
            }
        }
        if(studentC > M){
            return false;
        }
        return true;
    }
};