class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target>x+y)
            return false;
        if(x+y==target || x== target || y == target || target == 0)
            return true;
        
        Set<String> state = new HashSet<>();
        return helper(x,y,0,0,target,state);
    }
    public boolean helper(int x, int y, int jug1, int jug2, int target,Set<String> state){
        if(state.contains(jug1+","+jug2))
            return false;
        
        state.add(jug1+","+jug2);
        
        if(jug1+jug2 == target || jug1 == target || jug2 == target)
            return true;
        
       return(helper(x,y,x,jug2,target,state)|| //complete fill jug1
        helper(x,y,jug1,y,target,state)|| //complete fill jug2
        helper(x,y,0,jug2,target,state)|| //empty jug1
        helper(x,y,jug1,0,target,state)|| //empty jug2
        helper(x,y,jug1-Math.min(jug1,y-jug2),jug2+Math.min(jug1,y-jug2),target,state)|| //transfer jug1 to jug2
        helper(x,y,jug1+Math.min(jug2,x-jug1),jug2-Math.min(jug2,x-jug1),target,state)); // transfer jug2 to jug1
    }
}