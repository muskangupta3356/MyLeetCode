class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int [n+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] x : relations){
            adj.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
            }        
        }
        System.out.println(Arrays.toString(indegree));
       int count = q.size();
        int totalSem=0;int totalNodes=0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            totalNodes++;
            System.out.println(totalNodes);
            count--;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
            if(count==0){
                totalSem++;
                count = q.size();
            }
        }
        
        if(totalNodes==n)
            return totalSem;
        else return -1;
        
    }
}