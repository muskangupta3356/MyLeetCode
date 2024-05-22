class Solution {
    public int earliestAcq(int[][] logs, int n) {
        //Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, new Comparator<int[]>(){
            public int compare (int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        DisjointSet ds = new DisjointSet(n);
        int answer = -1; 
        for(int[] log :logs){
            if(ds.findUPar(log[1]) != ds.findUPar(log[2])){
                ds.unionByRank(log[1],log[2]);
                answer = log[0];
                n--;
            }
            if(n==1)
                return answer;
        }
        return -1;
    }
}

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer>parent = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(node == parent.get(node))
            return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
                
    }
}