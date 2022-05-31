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
    TreeNode* helper(vector<int>& preorder,unordered_map<int,int>& mp,int &preIndex,int start, int end)
    {
        if(start>end)
            return NULL;
        // if(preIndex>=size)
        //     return NULL;
        int v = preorder[preIndex];
        int index = mp[v];
        preIndex++;
        TreeNode* newnode = new TreeNode (v);
        newnode->left = helper(preorder,mp,preIndex,start,index-1);
        newnode->right = helper(preorder,mp,preIndex,index+1,end);
        return newnode;
        
    }
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        
        int n=preorder.size();
        vector<int> inorder;
        for(int i=0;i<n;i++)
        inorder.push_back(preorder[i]);
        
        sort(inorder.begin(), inorder.end());
        
        unordered_map<int,int>mp;
        for(int i=0;i<n;i++)
        {
            mp[inorder[i]]=i;
        }
        
        int preIndex=0;
        
        TreeNode*root= helper(preorder,mp,preIndex,0,n-1);
        
        return root;
    }
};