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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        if(root == null)    return result;
        dfs(root,"",result);
        return result;
    }
    private void dfs(TreeNode root,String stb,List<String> result){
        if(root==null)  return;
        stb+=root.val;
        if(root.left == null && root.right == null){
            result.add(stb);
            return;
        }
        stb+="->";
        dfs(root.left,stb,result);
        dfs(root.right,stb,result);
    }
}
