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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;
        
        boolean leftToRight = true; 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int lvlSize = q.size();
            List<Integer> tmp =new ArrayList<>();

            while(lvlSize --> 0){
                TreeNode t = q.poll();
                if(leftToRight) tmp.add(t.val);
                else tmp.add(0, t.val);

                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            ans.add(tmp);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}