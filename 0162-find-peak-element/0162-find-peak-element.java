class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
if((mid>start && mid < end && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])||(mid == start && mid == end)|| (mid == end && nums[mid]>nums[mid-1]) || (mid == start && nums[mid]> nums[mid+1]))
                return mid;
            else if(nums[mid]<nums[mid+1])
                start = mid + 1;
            else
                end = mid -1;
        }
        return -1;
    }
}