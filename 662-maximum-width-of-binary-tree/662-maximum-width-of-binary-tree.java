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
class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node,int num){
        this.node =node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Pair rootPair = new Pair(root,0);
        Queue<Pair> q = new LinkedList<>();
        q.offer(rootPair);
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0, last = q.size() -1;
            int min = q.peek().num;
            for(int i =0;i<size;i++){
                int cur_id = q.peek().num - min;
                Pair remPair = q.poll();
                if(i == 0) first= cur_id;
                if(i == size -1) last = cur_id;
                if(remPair.node.left != null)
                    q.offer(new Pair(remPair.node.left,(cur_id*2)+1));
                if(remPair.node.right != null)
                    q.offer(new Pair(remPair.node.right,(cur_id*2)+2));
            }
            ans = Math.max(ans,last - first+1);
        }
        return ans;
    }
}