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

    HashMap<Integer, Integer> in = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i=0; i<inorder.length; i++)
        in.put(inorder[i], i);

        idx = postorder.length-1;
        return fun(postorder, 0, postorder.length-1);
    }

    TreeNode fun(int[] postorder,int low,int high){

        if(low > high) return null;
        
        TreeNode node = new TreeNode(postorder[idx--]);

        int id = in.get(node.val);
        node.right = fun(postorder, id+1, high);
        node.left = fun(postorder, low , id-1);

        return node;
    }
}