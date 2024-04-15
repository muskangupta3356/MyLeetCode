class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int peackIndex =-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1]){
                
                peackIndex=i;
                break;
            }
        }
        
        if(peackIndex==-1)
        {
           Arrays.sort(nums);
            return;
        }
         int index=peackIndex;
        for(int i=n-1;i>peackIndex;i--)
        {
            if(nums[i]>nums[peackIndex])
            {
                index=i;
                break;
            }
        }
        //swap(nums[peackIndex-1],nums[index]);
        int temp=nums[peackIndex];
        nums[peackIndex]=nums[index];
        nums[index]=temp;
        Arrays.sort(nums,peackIndex+1,nums.length);
        return;
    }
}