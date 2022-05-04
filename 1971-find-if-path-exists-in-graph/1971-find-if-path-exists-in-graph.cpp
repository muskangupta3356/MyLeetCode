class Solution {
public:
    void helper(int s, vector<vector<int>> &edge, unordered_set<int> &visited)
    {
        // if(s==d)
        //     return true;
        
         visited.insert(s);
        // bool ans=false;
//         for(int i=0;i<n;i++)
//         {
           
//             if(edge[s][i]==1 && visited[i]==false)
//             {
                
//                ans=helper(n,i,d,edge,visited);
//                 if(ans==true)
//                     return ans;
//                  else continue;
//             }
//         }
        for(int neighbour: edge[s]) {
            if(visited.find(neighbour) == visited.end()) 
                helper(neighbour, edge, visited);
        }
        // return false;
        
    }
    
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        // int** edge=new int*[n];
        // for(int i=0;i<n;i++){
        //     int* temp=new int[n]{0};
        //     for(int j=0;j<n;j++){
        //         temp[j]=0;
        //     }
        //     edge[i]=temp;
        // }
        // for(int i=0;i<edges.size();i++)
        // {
        //     edge[edges[i][0]][edges[i][1]]=1;
        //     edge[edges[i][1]][edges[i][0]]=1;
        // }
        // bool* visited=new bool[n];
        // for(int i=0;i<n;i++){
        //     visited[i]=false;
        // }
        vector<vector<int>> edge(n);
        
        for(auto e:edges)
        {
            edge[e[0]].push_back(e[1]);
            edge[e[1]].push_back(e[0]);
        }
        unordered_set<int> visited;
        // vector<bool> visited(n, false);
        // bool ans=false;
        // ans= helper(n, source, destination, edge, visited);
        // return ans;
        helper(source,edge,visited);
        return visited.find(destination)!=visited.end();
    }
};