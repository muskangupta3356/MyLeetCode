class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        int end = n-1;
        int start = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            boolean pivotArray = existsInFirst(nums,start,nums[mid]);
            boolean targetArray = existsInFirst(nums,start,target);
            if(pivotArray ^ targetArray){
                if(pivotArray){
                    start = mid +1;
                }else{
                    end = mid - 1;
                }
            } else {
                if(nums[mid] < target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
        private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
        }
    }
