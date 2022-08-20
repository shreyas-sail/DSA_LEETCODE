/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        mapParent(root);
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(target);
        HashSet<TreeNode> set = new HashSet<>();
        while(!q.isEmpty() && k>0){
            int size = q.size();
            k-=1;
            for(int i = 0;i<size;i++){
                TreeNode node =  q.poll();
                set.add(node);
                if(parentMap.containsKey(node) && !set.contains(parentMap.get(node))){
                    q.offer(parentMap.get(node));
                }
                if(node.left != null && !set.contains(node.left)){
                    q.offer(node.left);
                }
                if(node.right != null && !set.contains(node.right)){
                    q.offer(node.right);
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans; 
    }
    
    private void mapParent(TreeNode root){
        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node =  q.poll();
            if(node.left != null){
                parentMap.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
}

// for(TreeNode node:parentMap.keySet()){
//             System.out.print(node.val);
//             System.out.print("-->");
//             System.out.println(parentMap.get(node).val);
//         }