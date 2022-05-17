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
    
    public int deepestLeavesSum(TreeNode root) {
        int[] curMax = new int[2];
        curMax[0] =0;
        curMax[1] = 0;
        maxHeight(root,0,curMax);
        return curMax[1];
        
    }
    
    public void maxHeight(TreeNode root,int level,int[] curMax){
        if(root == null)    return ;
        maxHeight(root.left,level+1,curMax);
        maxHeight(root.right,level+1,curMax);
        if(curMax[0] < level){
            curMax[0] = level;
            curMax[1] = 0;
        }
        if(curMax[0] == level){
            curMax[1] +=root.val; 
        } 
    }
}