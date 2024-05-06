class Solution {
    public boolean dfs(List<List<Integer>> adj, int visited[],int pathVis[],int node,Stack<Integer> st){
        visited[node]=1;
        pathVis[node]=1;
        
        for(int i : adj.get(node)){
            if(visited[i]==0){
              if(dfs(adj,visited,pathVis,i,st)== true) return true;
            }
            else if (pathVis[i] == 1){
                return true;
            }
        }
              
        pathVis[node]=0;
        st.push(node);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] visited = new int [numCourses];
        int[] pathVis = new int [numCourses];
        int[] order = new int [numCourses];
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0)
                if(dfs(adj,visited,pathVis,i,st)== true) return new int[0];
        }
        int t=0;
        while(!st.isEmpty()){
            order[t++]=st.peek();
            st.pop();
        }
        return order;
    }
}