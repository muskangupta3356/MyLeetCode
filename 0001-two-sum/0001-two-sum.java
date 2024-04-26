class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] answer = new int [2];
        m.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(m.containsKey(target-nums[i]))
            {
                answer[0]=m.get(target-nums[i]);
                answer[1]=i;
                return answer;
            }
            else
            {
                m.put(nums[i],i);
            }
        }
        return answer;
    }
}