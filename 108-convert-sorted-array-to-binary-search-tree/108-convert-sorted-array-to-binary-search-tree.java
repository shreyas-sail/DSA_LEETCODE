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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0,end =nums.length -1;
        TreeNode r = sortedArrayToBSTRec(nums,start,end);
        return r;
    }
    
    public TreeNode sortedArrayToBSTRec(int[] nums,int start,int end){
        if(start>end) return null;
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTRec(nums,start,mid-1);
        root.right = sortedArrayToBSTRec(nums,mid+1,end);
        
        return root;

    }
    
}