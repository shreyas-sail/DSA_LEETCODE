// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st =  new Stack<>();
    	for(int i =0;i<n;i++){
    	    st.push(i);
    	}
    	
    	while(st.size()>1){
    	    int p1 = st.pop(); //2 
    	    int p2 = st.pop(); //1 
    	    if(M[p2][p1] == 1){
    	        st.push(p1);
    	    }else{
    	        st.push(p2);
    	    }
    	}
    	for(int i:M[st.peek()]){
    	    if(i == 1) return -1;
    	}
    	for(int i =0;i<n;i++){
    	    if(i!=st.peek()){
    	        if(M[i][st.peek()] == 0){
    	            return -1;
    	        }
    	    }
    	}
    	return st.peek();
    }
}