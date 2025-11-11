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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        buildParent(root,null,parent);

        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        
        queue.offer(target);
        visited.add(target);
        int distance=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(distance == k){
                break;
            }
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();

                for(TreeNode neighbor : new TreeNode[]{
                    node.left,node.right,parent.get(node)
                })
                {
                    if(neighbor != null && !visited.contains(neighbor)){
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            distance++;
        }
        List<Integer> reuslt=new ArrayList<>();
        while(!queue.isEmpty()) reuslt.add(queue.poll().val);
        return reuslt;

    }

    private void buildParent(TreeNode node,TreeNode parentNode,Map<TreeNode,TreeNode> parent){
        if(node == null)    return;
        parent.put(node,parentNode);
        buildParent( node.left,node,parent);
        buildParent( node.right,node,parent);
    }
}
