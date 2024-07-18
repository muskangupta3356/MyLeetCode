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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long minVal , long  maxVal){
        if(root == null )return true;
        boolean l= false; boolean r = false;
        if(root.val >= minVal && root.val <= maxVal){
            if(root.val == Integer.MIN_VALUE){
                if(root.left == null)
                    l= true;
                else 
                    l = false;
                r = helper(root.right, root.val+1, maxVal);
            }
            else if (root.val == Integer.MAX_VALUE){
                if(root.right == null)
                    r = true;
                else 
                    r = false;
                l = helper(root.left,minVal,root.val-1);
            }
            else{
                l = helper(root.left,minVal,root.val-1);
                r = helper(root.right, root.val+1, maxVal);
            }
        }
        return (l & r);
      
    }
}