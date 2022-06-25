/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int[] count = new int[1];
        count[0] =0;
        int curMax = (int)-1e9;
        goodNodeHepler(root,curMax,count);
        return count[0];
    }
    
    private void  goodNodeHepler(TreeNode root,int curMax,int[] count){
       if(root == null) return ;
       if(root.val >=curMax){
           curMax = root.val;
           count[0]+=1;
       }
       goodNodeHepler(root.left,curMax,count);
       goodNodeHepler(root.right,curMax,count);
    }
    
}