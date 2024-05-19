class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if(n<5)
            return 0;
        for(int i=0;i<4;i++){
            answer = Math.min(answer,nums[n-4+i]-nums[i]);
        }
        return answer;
    }
}