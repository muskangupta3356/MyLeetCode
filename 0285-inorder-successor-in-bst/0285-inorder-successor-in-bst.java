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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
            return null;
        if(root.left == null && root.right == null)
            return null;
          TreeNode pre = null;
      if(p.right != null)
          return(helper1(p.right));
       else
           while(root.val!=p.val)
        {
            if(p.val<root.val)
            {
              //only update pre when p.val<root.val
               pre = root;
               root = root.left; 
            }
            else if(p.val>root.val)
                root = root.right;
        }
          
            return pre;
      
    }
    
    TreeNode helper1(TreeNode node){
        if(node.left == null)
            return node;
        return helper1(node.left);
    }
 
        
        
}