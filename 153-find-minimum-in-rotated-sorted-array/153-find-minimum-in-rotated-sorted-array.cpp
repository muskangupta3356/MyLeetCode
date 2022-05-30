class Solution {
public:
    int helper(vector<int>& nums, int s, int e)
    {
        if(s>e)
            return -1;
        int mid = (s+e)/2;
        cout<<mid<<endl;
        if(mid<e && nums[mid]>nums[mid+1])
            return mid+1;
        if(mid>s && nums[mid]<nums[mid-1])
            return mid;
        if(nums[mid]<nums[e])
           return (helper(nums,s,mid-1));
        else
            return (helper(nums,mid+1,e));
        return -1;
        
    }
    int findMin(vector<int>& nums) {
        int s=0;
        int e=nums.size()-1;
       int ans = helper(nums,0,e) ;
        if(ans==-1)
        return nums[0];
        else
            return nums[ans];
           
    }
};