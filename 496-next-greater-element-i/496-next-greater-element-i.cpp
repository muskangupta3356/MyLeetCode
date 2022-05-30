
class Solution {
public:
    
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;
        stack<int> s;
        unordered_map<int, int> map;
        
        for(int n : nums2){
            while(!s.empty() && s.top() < n){
                map[s.top()] = n;
                s.pop();
            }
            s.push(n);
        }
        
        for (int n : nums1) ans.push_back(map.count(n) ? map[n] : -1);
        
        return ans;
    }
};