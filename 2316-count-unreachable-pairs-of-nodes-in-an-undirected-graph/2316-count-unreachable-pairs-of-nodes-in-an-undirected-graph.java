class Solution {
    public long countPairs(int n, int[][] edges) {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int [n];
        long total = 0;long answer=0;int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0)
            {     
                count=dfs(adj,visited,i);
                answer+=total * count;
                total+=count;
                
            }
        }

        return answer;
    }
    public int dfs(List<ArrayList<Integer>> adj,int[] visited,int node){
        visited[node]=1;
        int total=1;
        ArrayList<Integer> row = adj.get(node);
        for(int i=0;i<row.size();i++){
            if(visited[row.get(i)]==0)
                total+=dfs(adj,visited,row.get(i));
        }
        return total;
    }
}