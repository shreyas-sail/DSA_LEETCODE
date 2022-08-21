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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int[] maxi = new int[1];
        maxi[0] = 0;
        int ans =  helper(root,null,maxi);
        return maxi[0]-1;
    }
    
    private int helper(TreeNode root,TreeNode parent,int[] maxi){
        if(root == null) return 0;
        int left = helper(root.left,root,maxi);
        int right =  helper(root.right,root,maxi);
        if(parent!=null && root.val == parent.val){
            maxi[0] = Math.max(maxi[0],left+right+1);
            return  Math.max(left, right)+1;
        }else{
            maxi[0] = Math.max(maxi[0],left+right+1);
            return 0;
        }
    }
}