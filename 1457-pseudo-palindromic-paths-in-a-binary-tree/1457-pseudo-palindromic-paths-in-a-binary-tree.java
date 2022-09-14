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
    
    int noOfPaths;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] map = new int[10];
        helper(root,map);
        return noOfPaths;
    }
    
    private void helper(TreeNode root,int[] map){
        if(root == null) return ;
        map[root.val] = map[root.val]+1;
        // System.out.println(Arrays.toString(map));
        if(root.left == null && root.right == null){
            System.out.println(Arrays.toString(map));
            if(checkIfPseudoPalindromicPaths(map)){
                noOfPaths+=1;
            }
        }
        helper(root.left,map);
        helper(root.right,map);
        map[root.val] = map[root.val]-1;
    }
    
    private Boolean checkIfPseudoPalindromicPaths(int[] map){
        Boolean oddDetected = false;
        for(int i:map){
            if(i%2 != 0 && !oddDetected){
                oddDetected = true;
            } else if(i%2 != 0 && oddDetected){
                return false;
            }
        }
        return true;
    }
}