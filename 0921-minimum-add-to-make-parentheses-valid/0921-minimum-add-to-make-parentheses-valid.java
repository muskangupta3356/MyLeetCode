class Solution {
    public int minAddToMakeValid(String s) {
      Stack<Character> c = new Stack<>();
      int n = s.length();
        int count = 0;
      for(int i=0;i<n;i++){
          if(s.charAt(i) == '(')
              c.push(s.charAt(i));
          else if(s.charAt(i) == ')' && !c.empty())
              c.pop();
          else if(s.charAt(i) == ')' && c.empty())
              count++;
      }
       return c.size() + count;
    }
}