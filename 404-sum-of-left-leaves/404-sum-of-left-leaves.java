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
    public int sumOfLeftLeaves(TreeNode root) {
       //List<TreeNode> ds = new ArrayList<TreeNode>();
        int [] sum = new int[2];
        sum[0] = 0;
        sumOfLeftLeavesHelper(root,0,false,sum);
        return sum[0];
    }
    public int sumOfLeftLeavesHelper(TreeNode root,int curDepth,Boolean isLeft,int[] sum){
        if(root == null) return 0 ;
        if(root.left == null && root.right == null && isLeft){
            return sum[0]+=root.val;
        }
         int left =sumOfLeftLeavesHelper(root.left,curDepth+1,true,sum);
         int right = sumOfLeftLeavesHelper(root.right,curDepth+1,false,sum);
        
        return left+right;
    }
}