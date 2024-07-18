class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordsFind = new HashSet<>(wordDict);
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(s,wordsFind,memo,0,s.length());
    }
    
    public boolean helper(String s, Set<String> wordsFind,int[]memo,int index, int len){
        if(index==len)
            return true;
        
        if(memo[index]!=-1)
            return memo[index] ==1;
        for(int i = index +1; i <=len;i++){
        if(wordsFind.contains(s.substring(index,i)) && helper(s,wordsFind,memo,i,len)){
            memo[index]=1;
            return true;
        }
    }
        memo[index]=0;
        return false;
    }
}