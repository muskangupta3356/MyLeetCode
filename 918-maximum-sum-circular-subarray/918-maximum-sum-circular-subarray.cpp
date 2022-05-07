class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int max_sum=INT_MIN;
        int temp_max_sum=0;
         int total=0;
        int min_sum=INT_MAX;
        int temp_min_sum=0;
        
        for(int i=0;i<nums.size();i++)
        {
            temp_max_sum+=nums[i];
            if(max_sum<temp_max_sum)
                max_sum=temp_max_sum;
            if(temp_max_sum<0)
                temp_max_sum=0;
            
            total+=nums[i];
            
            temp_min_sum+=nums[i];
            if(min_sum>temp_min_sum)
                min_sum=temp_min_sum;
            if(temp_min_sum>0)
                temp_min_sum=0;
            
        }
        
        if(total==min_sum)
            return max_sum;
        
        else 
            return (max(max_sum,total-min_sum));
    }
};