

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // Step 2: Use a priority queue (min-heap) with a custom comparator (without lambda)
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int freq1 = freqMap.get(word1);
                int freq2 = freqMap.get(word2);
                // First compare by frequency (ascending order)
                if (freq1 != freq2) {
                    return freq1 - freq2;
                }
                // If frequencies are the same, compare lexicographically (descending order)
                return word2.compareTo(word1);
            }
        });
        
        // Step 3: Add words to the priority queue
        for (String word : freqMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent or lexicographically largest
            }
        }
        
        // Step 4: Collect results
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        // Since we want the result in decreasing frequency and lexicographical order, reverse the list
        Collections.reverse(result);
        return result;
    }
}
