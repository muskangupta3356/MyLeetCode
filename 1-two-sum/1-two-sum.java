class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int [2] ;
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            int temp = target - nums[i];
            if(mp.containsKey(temp))
            {
                ans[0]=mp.get(temp);
                ans[1]=i;
                return ans;
            }
            else
            {
                mp.put(nums[i],i);
            }
            
        }
        return ans;
    }
}