class Solution {
public:
    
    bool isCycle(unordered_map<int,vector<int>> &mp, int* state,int t)
    {
        if(state[t]==2)
            return true;
        
         state[t]=2;
        // if(mp.find(t)!=mp.end())
        // {
           for(int i=0;i<mp[t].size();i++)
        {
            if(state[mp[t][i]]!=1)
            {
                if(isCycle(mp,state,mp[t][i]))
                    return true;
            }
        } 
        // }
        
        state[t]=1;
        return false;
    }
    
    
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
       unordered_map<int,vector<int>>mp;
        
        for(int i=0;i<prerequisites.size();i++)
        {
            mp[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        int *state = new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
        {
            state[i]=0;
        }
        
        for(int i=0;i<numCourses;i++)
        {
            if(state[i]==0)
            {
              if(isCycle(mp,state,i))  
                return false;
            }
        }
        return true;
    }
};