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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i =0;i<k;i++){
                TreeNode popedNode = q.poll();
                if(popedNode.left != null){
                    q.offer(popedNode.left);
                }
                if(popedNode.right != null){
                    q.offer(popedNode.right);
                }
                level.add(popedNode.val);
            }
            ans.add(level);
        }
        return ans;
    }
}