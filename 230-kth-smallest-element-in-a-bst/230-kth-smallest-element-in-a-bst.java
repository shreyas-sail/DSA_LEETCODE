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
  private int val = 0;
  private int count = 0;
  
  public int kthSmallest(TreeNode root, int k) {
    dfs(root, k);
    return val;
  }

  /**
   * Time O(n)
   * Space O(h)
   *   - Each element costs constant space O(1).
   *     And the size of the stack is exactly the depth of DFS.
   *     So in the worst case, it costs O(h) to maintain the system stack,
   *     where h is the maximum depth of DFS.
   */
  public void dfs(TreeNode node, int k) {
    if (node == null) return;
    dfs(node.left, k);
    if (++count == k) {
	  this.val = node.val;
	  return;
    }
    dfs(node.right, k);
  }
}