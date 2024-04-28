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
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }
    public int helper(TreeNode root)
    {   if(root == null)
            return 0;
        int ls = Math.max(helper(root.left),0);
        int rs = Math.max(helper(root.right),0);
        sum = Math.max(sum, root.val+ls+rs);

        return root.val+Math.max(ls,rs);
    }
}