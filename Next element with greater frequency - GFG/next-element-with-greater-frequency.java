// { Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}
// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(freqMap.containsKey(arr[i])){
                freqMap.put(arr[i],freqMap.get(arr[i])+1);
            }else{
                freqMap.put(arr[i],1);
            }
        }
        // System.out.println(freqMap.keySet());
        Stack<Integer> st = new Stack<>();
        int[] ngf =  new int[n];
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && freqMap.get(st.peek())<=freqMap.get(arr[i])) {
                // System.out.println("pop");
                st.pop();
                
            }
            if(st.isEmpty()) {
                ngf[i] = -1;
                // System.out.println("push");
            }
            else{
                ngf[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ngf;
    }
}

