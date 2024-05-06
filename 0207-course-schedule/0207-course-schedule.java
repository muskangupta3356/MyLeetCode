class Solution {
    public boolean dfs(List<List<Integer>> adj, int visited[],int pathVis[],int node){
        visited[node]=1;
        pathVis[node]=1;
        
        for(int i : adj.get(node)){
            if(visited[i]==0){
              if(dfs(adj,visited,pathVis,i)== true) return true;
            }
            else if (pathVis[i] == 1){
                return true;
            }
        }
              
        pathVis[node]=0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] visited = new int [numCourses];
        int[] pathVis = new int [numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0)
                if(dfs(adj,visited,pathVis,i)== true) return false;
        }
        
        return true;
    }
}