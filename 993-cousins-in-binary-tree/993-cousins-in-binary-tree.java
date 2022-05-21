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
import java.util.*;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<Pair> map = new ArrayList<>();
        getDepth(root,x,y,map,0,null);
        // map.entrySet().forEach(entry -> {
    // System.out.println(entry.getKey() + " " + entry.getValue().depth+"--"+entry.getValue().parent.val);});
        // System.out.println(map.values().get(0));
        // Collection<Pair> p = map.values();
        // System.out.printf("%d--%d",map.get(0).depth,map.get(0).parent.val);
        // System.out.printf("%d--%d",map.get(1).depth,map.get(1).parent.val);
        if(map.get(0).depth == map.get(1).depth && map.get(0).parent.val != map.get(1).parent.val ){
            return true;
        }
        return false;
    }
    
    public void getDepth(TreeNode root, int x, int y,List<Pair> map,int depth,TreeNode parent){
        if(root == null) return;
        if(root.val == x || root.val == y){
            map.add(new Pair(depth,parent));
        }
        getDepth(root.left,x,y,map,depth+1,root);
        getDepth(root.right,x,y,map,depth+1,root);
    }
    class Pair{
        public int depth;
        public TreeNode parent;
        public Pair(int depth,TreeNode parent){
            this.depth = depth;
            this.parent = parent;
        }
    }
}