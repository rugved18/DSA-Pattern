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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<int[]>> map=new HashMap<>();
        Queue<Object[]> q=new LinkedList<>();
        q.offer(new Object[]{root,0,0});
        int minCol=0,maxCol=0;

        while(!q.isEmpty()){
            Object[] arr=q.poll();
            TreeNode node=(TreeNode) arr[0];
            int row=(int) arr[1];
            int col=(int) arr[2];

            map.computeIfAbsent(col,x->new ArrayList<>()).add(new int[]{row,node.val});

            minCol=Math.min(minCol,col);
            maxCol=Math.max(maxCol,col);
            if(node.left!=null){
                q.offer(new Object[]{node.left,row+1,col-1});
            }
            if(node.right!=null){
                q.offer(new Object[]{node.right,row+1,col+1});
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int c=minCol;c<=maxCol;c++){
            List<int[]> list=map.get(c);
            list.sort((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

            List<Integer> colList=new ArrayList<>();
            for(int[] p:list){
                colList.add(p[1]);
            }
            res.add(colList);
        }
        return res;
    }
}
