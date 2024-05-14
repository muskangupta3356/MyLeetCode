class Solution {
    public int dfs(List<List<Integer>> adj,Set<Integer> visited, int node){
        visited.add(node);
        int count=1;
        for(int it : adj.get(node))
        {
            if(!visited.contains(it))
                count+=dfs(adj,visited,it);
        }
        
        return count;
        
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int[] bomb1 = bombs[i];
            
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                int[] bomb2 = bombs[j];
                // System.out.println(Arrays.toString(bomb1));
                // System.out.println(Arrays.toString(bomb2));
                double dist = Math.sqrt(Math.pow(bomb1[0]-bomb2[0],2)+Math.pow(bomb1[1]-bomb2[1],2));
                System.out.println(dist);
                if(dist<=bomb1[2])
                    adj.get(i).add(j);
                // if(dist<=bomb2[2])
                //     adj.get(j).add(i);
                
//                        System.out.println("adj List");
//         for (List<Integer> innerList : adj) {
//     for (Integer element : innerList) {
//         System.out.print(element + " ");
//     }
//     System.out.println(); // Print a new line after each inner list
// }
            }
        }
 
        
        // int[] visit = new int [n];
        
        int total =0;
        for(int i=0;i<n;i++)
        {   int count=0;
            
               count = dfs(adj,new HashSet<>(),i);
               
                total = Math.max(total,count);
            
        }
        
        return total;        
        
    }
}
