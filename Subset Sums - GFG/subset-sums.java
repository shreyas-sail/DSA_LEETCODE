// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
     ArrayList<Integer> para =  new ArrayList<Integer>();
        recurSet(0,arr.stream()
                            .mapToInt(Integer::intValue)
                            .toArray(),para,0);
        return para;
    }
    
    public  void recurSet(int index,int[] nums,ArrayList<Integer> ans,int sum){
        if(index==nums.length){
            ans.add(sum);
            return ;
        }
        sum +=nums[index];
        recurSet(index+1,nums,ans,sum);
        sum -=nums[index];
        recurSet(index+1,nums,ans,sum);
    }
}