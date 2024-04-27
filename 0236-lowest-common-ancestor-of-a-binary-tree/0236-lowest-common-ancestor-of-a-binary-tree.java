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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        if(root.val == p.val)
            return root;
        if(root.val == q.val)
            return root;
        
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        
        if(leftNode != null && rightNode == null)
            return leftNode;
        else if(leftNode == null && rightNode != null)
            return rightNode;
        else if(leftNode != null && rightNode != null)
            return root;
        else 
            return null;
    }
}