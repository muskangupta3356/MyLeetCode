class Solution {
    public int[][] highFive(int[][] items) {
         TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        for (int[] item : items) {
            if (!mp.containsKey(item[0])) {
                mp.put(item[0], new ArrayList<>());
            }
            mp.get(item[0]).add(item[1]);
        }
        List<int[]> answer = new ArrayList<>();
        int index=0;
        for(Map.Entry<Integer,ArrayList<Integer>> entry : mp.entrySet()){
            int key = entry.getKey();
            ArrayList<Integer> scores = entry.getValue();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
           for (int score : scores) {
                pq.add(score);
            }
            while(pq.size() > 5){
                pq.poll();
            }
            int sum =0;
            while(!pq.isEmpty()){
                sum+= pq.poll();
            }
            int avg = sum/5;
           answer.add(new int[]{key, avg});
            
        }
     int[][] solutionArray = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i++) {
            solutionArray[i] = answer.get(i);
        }
        return solutionArray;
      
    }
}