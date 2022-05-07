class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
      int temp=0; int ans=INT_MIN;
        for(int i=0;i<k;i++)
        {
            temp+=cardPoints[i];
        }
        if(ans<temp)
            ans=temp;
        int i=k-1; int j=cardPoints.size()-1;
        while(k>0)
        {
            
            temp=temp-cardPoints[i]+cardPoints[j];
             if(ans<temp)
            ans=temp;
            i--;
            j--;
            k--;
            
        }
        return ans;
    }
};