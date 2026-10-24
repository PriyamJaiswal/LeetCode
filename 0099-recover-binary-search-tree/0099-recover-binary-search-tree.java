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

    TreeNode prev = null;
    int galat = 0;
    TreeNode g1first, g1sec, g2first, g2sec;

    public void recoverTree(TreeNode root) {
        fun(root);
        if(galat == 1){
            int temp = g1first.val;
            g1first.val = g1sec.val;
            g1sec.val = temp;
        }else{
            int temp = g1first.val;
            g1first.val = g2sec.val;
            g2sec.val = temp;
        }
    }
    void fun(TreeNode root){ 
       
       if(root == null) return;
       fun(root.left);

       if(prev == null) prev = root;
       else{
        if(root.val < prev.val)
        {
            if(galat == 0){
                g1first = prev;
                g1sec = root;
                galat++;
            }else{
                g2first = prev;
                g2sec = root;
                galat++;
            }
        }
        prev = root;
       }
       fun(root.right);
    }
}