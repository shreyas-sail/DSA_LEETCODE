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
    public int maxAncestorDiff(TreeNode root) {
        
        List<Integer> anList =  new ArrayList<>();
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root,max,anList);
        return max[0];
    }
    
    void dfs(TreeNode root,int[] max,List<Integer> anList){
        if(root == null) return ;
        
        anList.add(root.val);
        dfs(root.left,max,anList);
        anList.remove(anList.size()-1);
        for(int i:anList){
            max[0] = Math.max(max[0],Math.abs(i - root.val));
        }
        anList.add(root.val);
        dfs(root.right,max,anList);
        anList.remove(anList.size()-1);
        for(int i:anList){
            max[0] = Math.max(max[0],Math.abs(i - root.val));
        }
        
    }
}