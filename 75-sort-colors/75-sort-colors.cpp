class Solution {
public:
    void sortColors(vector<int>& nums) {
        int a[3]={0,0,0};
      for(auto i : nums)
      {
        a[i]++;
      }
      int t=0;
      for(int i=0;i<nums.size();)
      {
        while(t<3 && a[t]--)
        {
          nums[i]=t;
          i++;
        }
        t++;
      }
      return;
        
    }
};