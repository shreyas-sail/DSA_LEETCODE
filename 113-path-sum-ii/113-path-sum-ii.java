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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       pathSumAgr(root,targetSum,ans,new ArrayList<Integer>());
       return ans;  
    }
    
    public void pathSumAgr(TreeNode root, int targetSum,List<List<Integer>> ans, List<Integer> ds) {
        if(root == null) return;
        if(root.left == null && root.right == null && root.val == targetSum){
            ds.add(root.val);
            ans.add(new ArrayList<Integer>(ds));
            ds.remove(ds.size() -1);
            return;
        }
        ds.add(root.val);
        pathSumAgr(root.left,targetSum - root.val,ans,ds);
        pathSumAgr(root.right,targetSum - root.val,ans,ds);
        ds.remove(ds.size() -1);
    }
}