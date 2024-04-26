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
    List<TreeNode> nodes = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int val : to_delete)
        {
            set.add(val);
        }
        helper(root);
        if(!set.contains(root.val)){
            nodes.add(root);
        }      
        return nodes;        
    }
    public TreeNode helper(TreeNode node){
        if(node == null)
            return null;
        
        node.left = helper(node.left);
        node.right =helper(node.right);
        
        if(set.contains(node.val)){
            if(node.left != null)
                nodes.add(node.left);
            if(node.right != null)
                nodes.add(node.right);
            return null;
        }
        return node;
    }
    
}