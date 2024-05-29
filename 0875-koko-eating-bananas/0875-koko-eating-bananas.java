class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lowest = 1;
        int highest = 0;
        for(int pile : piles){
            if(pile>highest)
                highest = Math.max(highest, pile);
        }
        
        while(lowest < highest){
            int mid = (lowest + highest)/2;
            int hours=0;
            for(int pile : piles){
                hours+=Math.ceil((double)pile/mid);
                if(hours>h)
                    break;
            }
            if(hours <= h){
                highest = mid;
            }else{
                lowest = mid + 1;
            }
        }
        return lowest;
    }
}