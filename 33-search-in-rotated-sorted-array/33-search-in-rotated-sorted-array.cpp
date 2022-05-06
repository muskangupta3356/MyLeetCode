class Solution {
public:
    int pivot_func(int low, int high,vector<int>& nums)
    {
        if(low>high)
            return -1;
        int mid =(low+high)/2;
        if(mid<high &&  nums[mid]>nums[mid+1])
            return mid;
        else if(mid >low && nums[mid]<nums[mid-1])
            return mid-1;
        if(nums[mid]<nums[high])
            return pivot_func(low, mid-1,nums);
        else 
            return pivot_func(mid+1 , high , nums);
        
    }
    int find_element(int low, int high,vector<int>& nums, int target )
    {
        if(low>high)
            return -1;
        
        int mid=(low+high)/2;
        if(target==nums[mid])
            return mid;
        else if(target<nums[mid])
            return find_element(low,mid-1,nums,target);
        else return find_element(mid+1,high,nums,target);
    }
    
    int search(vector<int>& nums, int target) {
        int low=0; int high=nums.size()-1;
        int pivot=pivot_func(low,high,nums);
        
        if(pivot!=-1)
        {
           if(target>= nums[low] && target<=nums[pivot])
            return find_element(low,pivot,nums,target);
        else if(pivot+1<=high && target>= nums[pivot+1] && target<=nums[high])
            return find_element(pivot+1,high,nums,target);
        }
        
        else 
        {
            return find_element(low,high,nums,target);
        }
        return -1;
    
}
};