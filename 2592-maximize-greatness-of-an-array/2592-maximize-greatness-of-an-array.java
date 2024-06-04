class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int i=0;int j=0;
        int count = 0;
        while(i<l && j<l){
           if(nums[i]<nums[j]) {
               i++; j++;
               count ++;
           }
            else{
                j++;
            }
        }
        
        return count;
    }
}