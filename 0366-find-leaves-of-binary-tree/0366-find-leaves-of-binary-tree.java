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
    public List<List<Integer>> findLeaves(TreeNode root) {
         List<List<Integer>> answer = new ArrayList<>();
       
       int h = height(root,answer);
        return answer;
    }
    public int height(TreeNode root, List<List<Integer>> answer){
        if(root==null)
            return 0;
        int leftHeight = height(root.left,answer);
        int rightHeight = height(root.right,answer);
       // if(root.left == null && root.right == null){
            int index = Math.max(leftHeight,rightHeight);
            if(answer.size()<= index){
                answer.add(new ArrayList<>());                
            }
            answer.get(index).add(root.val);
       // }
        return 1+Math.max(leftHeight,rightHeight);
    }
}