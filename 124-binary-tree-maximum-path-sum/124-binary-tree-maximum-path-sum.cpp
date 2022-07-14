/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int totalSum(TreeNode* root)
    {
        if(root==NULL)
            return 0;
        int sumL=totalSum(root->left);//
        int sumR=totalSum(root->right);//
        return max(root->val,root->val+max(sumL,sumR));
    }
    int maxPathSum(TreeNode* root) {
        if(root==NULL)
            return INT_MIN;
        if(root->left==NULL && root->right==NULL)
            return root->val;
        int totalSumLeft=totalSum(root->left); //6
        int totalSumRight=totalSum(root->right);//-1
        int sum=root->val;
         if(totalSumLeft>=0)
            sum+=totalSumLeft;
         if(totalSumRight>=0)
            sum+=totalSumRight;
        int leftTree= maxPathSum(root->left);
        int rightTree= maxPathSum(root->right);
        int ans = max(sum,max(leftTree,rightTree));
        return ans;
        
    }
};