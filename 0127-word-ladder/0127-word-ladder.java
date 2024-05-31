class Solution {
    public int ladderLength(String source, String target, List<String> words) {
        Set<String> wordList = new HashSet<>();
        for (String word : words) {
            wordList.add(word);
        }
        if (!wordList.contains(target)) {
            return 0;
        }

        Queue<Path> q = new LinkedList<>();
        Path p = new Path(source, 1);
        q.add(p);
        Set<String> visited = new HashSet<>();
        visited.add(source);

        while (!q.isEmpty()) {
            Path temp = q.poll();
            String w = temp.wrd;
            int d = temp.step;

            for (int i = 0; i < w.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (w.charAt(i) != c) {
                        StringBuffer wBuffer = new StringBuffer(w);
                        wBuffer.setCharAt(i, c);
                        String nextWord = wBuffer.toString();

                        if (nextWord.equals(target)) { 
                            return d + 1;
                        }
                        if (wordList.contains(nextWord) && !visited.contains(nextWord)) {
                            Path t = new Path(nextWord, d + 1);
                            q.add(t);
                            visited.add(nextWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
class Path {
    String wrd;
    int step;

    Path() {
        this.wrd = "";
        this.step = 0;
    }

    Path(String s, int d) {
        this.wrd = s;
        this.step = d;
    }
}