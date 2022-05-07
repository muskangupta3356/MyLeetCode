class Solution {
public:
    int longestConsecutive(vector<int>& arr) {
        unordered_map<int, int>mp;
        if(arr.size()==0)
            return 0;

            for(int i=0;i<arr.size();i++)
        {
            mp[arr[i]]=1;
        }
        if(mp.size()==1)
            return 1;

        int temp=0; int ans=1;
        for(auto i= mp.begin();i!=mp.end();i++)
        {
            int t=i->first;
            if(mp.find(t+1)!=mp.end())
                continue;
            else
            {
               if(mp.find(t-1)==mp.end()) 
                continue;

               else 
               {    while(mp.find(t)!=mp.end()){
                        temp+=1;
                        // mp.erase(t);
                        t=t-1;
                    }
                    
               }
            }

            ans=max(ans,temp);
            temp=0;

        }
        return ans;
        }

};