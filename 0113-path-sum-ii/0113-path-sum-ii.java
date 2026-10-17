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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        fun(root, 0, diary, res, targetSum);
        return res;
    }
    void fun(TreeNode root, int sum, List<Integer> diary, List<List<Integer>> res, int k){

        if(root == null) return;

        sum += root.val;
        diary.add(root.val);
        if(root.left==null && root.right==null){
            if(sum == k)  res.add(new ArrayList<>(diary));;
            
        }
        fun(root.left, sum, diary, res, k);
        fun(root.right, sum, diary, res, k);
        diary.remove(diary.size() - 1);
    }
}