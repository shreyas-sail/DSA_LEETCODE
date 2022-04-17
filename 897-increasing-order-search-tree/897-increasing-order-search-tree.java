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
    private TreeNode head = new TreeNode(-1);
    private TreeNode temp = head;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return head.right;
    }
    private void inOrder(TreeNode root){
        if(root!=null) {
            inOrder(root.left);
            temp.right=root;
            root.left=null;
            temp=root;
            inOrder(root.right);
        }
    }
}