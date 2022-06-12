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
    public int noOfNodes = 0; 
    public int averageOfSubtree(TreeNode root) {
        avgSubtree(root);
        return noOfNodes;
        
    }
    public Pair avgSubtree(TreeNode root){
        if(root == null) return new Pair(0,0);
        Pair left = avgSubtree(root.left);
        Pair right = avgSubtree(root.right);
        int nominator = left.val+right.val+root.val;
        int denominator = left.nodeCount+right.nodeCount+1;
        if(nominator/denominator == root.val) noOfNodes+=1;
        return new Pair(nominator,denominator);
    }
}

class Pair{
    int val;
    int nodeCount;
    Pair(int val,int nodeCount){
        this.val = val;
        this.nodeCount = nodeCount;
    }
}