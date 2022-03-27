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
    int total;
    public int sumNumbers(TreeNode root) {
        total = 0;
        sumOfNodes(root,0);
        
        
        return total;
    }
    
    public void sumOfNodes(TreeNode root,int sum){
        if(root == null){
            return;
        }
        sum = (sum*10)+root.val;
        if(root.left == null && root.right== null){
            total+=sum;
            return;
        }
        sumOfNodes(root.left,sum);
        sumOfNodes(root.right,sum);
    }
}