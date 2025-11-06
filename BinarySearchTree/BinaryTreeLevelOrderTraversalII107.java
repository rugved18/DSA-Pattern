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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root,0);

        Collections.reverse(result);
        return result;
    }
    void dfs(TreeNode root,int count){
        if(root == null)    return;
        
        if(count == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(count).add(root.val);

        dfs(root.left,count+1);
        dfs(root.right,count+1);
        
        }
    }

