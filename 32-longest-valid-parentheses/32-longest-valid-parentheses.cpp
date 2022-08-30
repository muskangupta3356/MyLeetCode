class Solution {
public:
    int longestValidParentheses(string s) {
        string str =s;
        int n= str.length();
    int left=0; int right=0; int maxLength=0;
    for(int i=0;i<n;i++)
    {
        if(str[i]=='(')
            left++;
        else
            right++;
        if(left==right)
            maxLength=max(maxLength,2*right);
        else if(right>left)
        {
            left=0;
            right=0;
        }
    }
    left=0;right=0;
     for(int i=n-1;i>=0;i--)
    {
        if(str[i]=='(')
            left++;
        else
            right++;
        if(left==right)
            maxLength=max(maxLength,2*left);
        else if(left>right)
        {
            left=0;
            right=0;
        }
    }
    return maxLength;
        
    }
};