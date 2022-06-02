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
    
    void helper(TreeNode* root,int mx,int &count)
    {
        if(root==NULL)
            return;
        if(root->val>=mx)
        {
            count++;
            mx=root->val;
            
        }
            helper(root->left,mx,count);
            helper(root->right,mx,count);
        return;
    }
    
    int goodNodes(TreeNode* root) {
        if(root==NULL)
            return 0;
        int count=1;
        int mx = root->val;
        
        helper(root->left,mx,count);
        helper(root->right,mx,count);
        
        return count;
    }
};