class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n=s.size();
        int i=0;
        int j=0;
        int ans=0;
        unordered_map<char,int>mp;
        while(j<n)
        {
           mp[s[j]]++;
            
            if(mp[s[j]]==1)
            {
              j++;  
            }
            else
            {
                while(mp[s[j]]!=1)
                {
                    mp[s[i]]--;
                    if(mp[s[i]]==0)
                        mp.erase(s[i]);
                    i++;
                }
                j++;
            }
            if(ans<mp.size())
                ans=mp.size();
            
        }
        return ans;
        
    }
};