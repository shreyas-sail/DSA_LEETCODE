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
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = (int) -1e9;
        if(root.left == null && root.right == null) return root.val;
        maxPathSumHelper(root,maxi);
        return maxi[0];
    }
    
    public int maxPathSumHelper(TreeNode root,int[] maxi){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0,maxPathSumHelper(root.left,maxi));   // -1
        int rightSum = Math.max(0,maxPathSumHelper(root.right,maxi));  // 7
        
        maxi[0] = Math.max(maxi[0],leftSum+rightSum+root.val); // 15+7+20 =42
        
        return root.val + Math.max(leftSum,rightSum);
    }
}