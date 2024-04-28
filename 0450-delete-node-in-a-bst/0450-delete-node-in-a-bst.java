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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        
        if(root.val == key)
        {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left != null && root.right == null)
                root = root.left;
            else if(root.right!= null)
            {
                TreeNode node = nextGreatest(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
            return root;
        }
        
       root.left =  deleteNode(root.left,key);
       root.right = deleteNode(root.right,key);
        
        
        return root;
    }
    public TreeNode nextGreatest(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        
        return node;
    }
}