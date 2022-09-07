class Solution {
public:
    bool helper(string &s,unordered_set<string> &words,int index,int n,unordered_map<int,bool> &mp)
    {
        if(index==n)
            return true;
        if(mp.count(index)!=0)
            return mp[index];
        for(int i=index+1;i<=s.length();i++)
        {
            string temp = s.substr(index,i-index);
            // cout<<temp<<" "<<index<<endl;
            if(words.find(temp)!=words.end() && helper (s,words,i,n,mp))
            {
                // cout<<"substr found"<<endl;
                // bool x = helper (s,words,i,n);
                // cout<<"x "<<x<<" "<<i<<endl;
                // if(x)
                   mp[index]=true;
                    return true;
            }
        }
        mp[index]=false;
        return false;
    }
    bool wordBreak(string s, vector<string>& wordDict) {
      unordered_set<string> words;
      unordered_map<int,bool> mp;
        for(int i=0;i<wordDict.size();i++)
        {
            words.insert(wordDict[i]);
        }
        
        return helper(s,words,0,s.length(),mp);
        
    }
};