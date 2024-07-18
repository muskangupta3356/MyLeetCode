class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
          @Override
            public int compare(int[] a, int[] b){
                return a[0]- b[0];
            }
        });
        
        List<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){
            if(merged.isEmpty() || interval[0]> merged.getLast()[1]){
                merged.add(interval);
            }else{
                merged.getLast()[1]= Math.max(merged.getLast()[1],interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
        
    }
}