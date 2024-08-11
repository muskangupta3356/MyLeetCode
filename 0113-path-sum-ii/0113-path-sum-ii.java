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
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        helper(root, targetSum, path, result);
        return result;        
    }
    
    public void helper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result){
        if(root == null)
            return;
       
        
        path.add(root.val);
        
        if(root.left == null && root.right == null && targetSum == root.val){
            result.add(new ArrayList<>(path));
        }else{
            helper(root.left, targetSum - root.val, path, result);
            helper(root.right, targetSum - root.val, path, result);
        }
        
        path.remove(path.size() -1);
        
      
    }
}