// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<Pair> p = new PriorityQueue<Pair>( new PairComparator(arr));
        for(int i = 0;i<K;i++){
            p.offer(new Pair(0,i));
            //System.out.println(arr[p.peek().num][p.peek().val]);
        }
        //System.out.println(arr[p.peek().num][p.peek().val]);
        ArrayList<Integer> ans =  new ArrayList<Integer>();
        while(!p.isEmpty()){
            Pair popedPair =  p.poll();
            //System.out.printf("%d %d\n",popedPair.num,popedPair.val);
            ans.add(arr[popedPair.num][popedPair.val]);
            if(popedPair.val+1 < arr[popedPair.num].length)
                p.offer(new Pair(popedPair.val+1,popedPair.num));
        }
        return ans;
    }
}

class PairComparator implements Comparator<Pair>{
    public int[][] arr;
    PairComparator(int[][] arr){
        this.arr = arr;
    }
    @Override
    public int compare(Pair a,Pair b){
        if(arr[a.num][a.val]>arr[b.num][b.val]){
            return 1;
        }
        if(arr[a.num][a.val]<arr[b.num][b.val]){
            return -1;
        }
        return 0;
    }
}

class Pair{
    int val;
    int num;
    Pair(int v,int n){
        val = v;
        num = n;
    }
}