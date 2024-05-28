class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[start] <= nums[end])
                return nums[start];
            if(nums[mid] >= nums[start]){
                if(mid < n)
                    start = mid + 1;
                else
                    return nums[start];
            }
            else{
                if(mid > start && nums[mid] > nums[mid-1])
                    end = mid - 1;
                else
                    return nums[mid];
            }
        }
        return -1;
    }
}