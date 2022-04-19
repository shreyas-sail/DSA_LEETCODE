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
    TreeNode first = null ;
    TreeNode middle= null;
    TreeNode last =null ;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp =0;
        if(first != null && last !=null){
            temp = last.val;
            last.val = first.val;
        }else{
            temp = middle.val;
            middle.val = first.val;
        }
        first.val = temp;
        // System.out.println(first.val);
        // System.out.println(middle.val);
        // System.out.println(last.val);
    }
    void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        if(prev != null && root.val<prev.val){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last =root;
            }
        }
        prev = root;
        inorder(root.right);
        return;
    }
}