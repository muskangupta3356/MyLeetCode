class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int peackIndex =-1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>nums[i-1])
                peackIndex=i;
        }
        
        if(peackIndex==-1)
        {
           Arrays.sort(nums);
            return;
        }
         int index=peackIndex;
        for(int i=peackIndex+1;i<n;i++)
        {
            if(nums[i]>nums[peackIndex-1] && nums[i]<nums[peackIndex])
            {
                index=i;
            }
        }
        //swap(nums[peackIndex-1],nums[index]);
        int temp=nums[peackIndex-1];
        nums[peackIndex-1]=nums[index];
        nums[index]=temp;
        Arrays.sort(nums,peackIndex,nums.length);
        return;
    }
}