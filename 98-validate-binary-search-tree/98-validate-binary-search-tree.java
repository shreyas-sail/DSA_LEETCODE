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
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean helper(TreeNode root,long x,long y){
        if(root == null) return true;
        if(root.val > x && y > root.val){
            
        }else{
            return false;
        }
        
        boolean leftSub = helper(root.left,x,root.val);
        boolean rightSub = helper(root.right,root.val,y);
        
        return leftSub && rightSub;
    }
}