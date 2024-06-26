class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int [26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare (Integer a, Integer b){
              return b - a;  
            }
        });
        for(int i=0;i<26;i++){
            if(freq[i]>0)
                pq.add(freq[i]);
        }
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n +1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            while(cycle-- > 0 && !pq.isEmpty()){
                int currentFreq = pq.poll();
                if(currentFreq  > 1){
                    store.add(currentFreq - 1);
                }
                    taskCount++;
                
            }
            store.forEach(pq::add);
            time += (pq.isEmpty() ? taskCount : n+1);
        }
        return time;
    }
}