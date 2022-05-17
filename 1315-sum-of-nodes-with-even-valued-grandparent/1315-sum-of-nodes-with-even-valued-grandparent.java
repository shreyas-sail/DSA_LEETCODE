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
    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = 0;
        evenHelper(root,null,null,sum);
        return sum[0];
    }
    
    public void evenHelper(TreeNode root,TreeNode parent,TreeNode gParent,int[] sum){
        if(root == null) return;
        evenHelper(root.left,root,parent,sum);
        evenHelper(root.right,root,parent,sum);
        if(gParent!=null && gParent.val %2 == 0){
            sum[0] += root.val;
        }
    }
}