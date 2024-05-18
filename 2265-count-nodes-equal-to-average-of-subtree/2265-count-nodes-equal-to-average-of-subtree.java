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
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Result result = new Result();
        helper(root, result);
        return result.ans;
    }

    public Result helper(TreeNode root, Result result) {
        if (root == null) {
            return new Result(0, 0, 0);
        }

        Result leftResult = helper(root.left, result);
        Result rightResult = helper(root.right, result);

        int sum = leftResult.sum + rightResult.sum + root.val;
        int count = leftResult.count + rightResult.count + 1;

        if (root.val == sum / count) {
            result.ans++;
        }

        return new Result(sum, count, result.ans);
    }

    class Result {
        int sum;
        int count;
        int ans;

        Result() {
            this.sum = 0;
            this.count = 0;
            this.ans = 0;
        }

        Result(int sum, int count, int ans) {
            this.sum = sum;
            this.count = count;
            this.ans = ans;
        }
    }
}
