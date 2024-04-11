class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pTriangle = new ArrayList<List<Integer>>();
       for(int i=1;i<=numRows; i++)
       {
           List<Integer> row = new ArrayList<Integer>();
           if(i==1)
           {
               row.add(1);
               pTriangle.add(row);
           }
           else if(i==2)
           {
               row.add(1);
               row.add(1);
               pTriangle.add(row);
           }
           else
           {
               row.add(1);
               // List<Integer> temp = new ArrayList<Integer>();
               // temp = pTriangle.get(i-2);
               List<Integer> temp = pTriangle.get(i-2);
               for(int j=0;j<temp.size()-1;j++)
               {
                   int sum=temp.get(j)+temp.get(j+1);
                   row.add(sum);
               }
                
               row.add(1);
               pTriangle.add(row);
           }
       }
        return pTriangle;
    }
}