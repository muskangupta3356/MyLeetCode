class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        priority_queue<int> max_heap;
        priority_queue<int, vector<int>,greater<int>>min_heap;
        
        if(nums1.size()!=0)
        {
             max_heap.push(nums1[0]);
        int i=1; int j=0; int count=1;
        
        while(i<nums1.size())
        {
            if(nums1[i]>=max_heap.top())
            {
                min_heap.push(nums1[i]);
                i++;
                count++;
            }
            else
            {
                  max_heap.push(nums1[i]);
                i++;
                count++;
            }
            if(count%2==0)
            {
                  if(max_heap.size()>min_heap.size())
            {
                min_heap.push(max_heap.top());
                max_heap.pop();
            }
                     else if(min_heap.size()>max_heap.size())
            {
                max_heap.push(min_heap.top());
                min_heap.pop();
            }
           
            }
          
        }
        while(j<nums2.size())
        {
           if(nums2[j]>=max_heap.top())
            {
                min_heap.push(nums2[j]);
                j++;
               count++;
            }
           else  {
                  max_heap.push(nums2[j]);
                j++;
                count++;
            }
            if(count%2==0)
            {
                 if(max_heap.size()>min_heap.size())
            {
                min_heap.push(max_heap.top());
                max_heap.pop();
            } 
                 else if(min_heap.size()>max_heap.size())
            {
                max_heap.push(min_heap.top());
                min_heap.pop();
            }
            }
           
        }
        
        }
        else
        {
           max_heap.push(nums2[0]);
        int j=1; int count=1;
        
       
        while(j<nums2.size())
        {
           if(nums2[j]>=max_heap.top())
            {
                min_heap.push(nums2[j]);
                j++;
               count++;
            }
             else  {
                  max_heap.push(nums2[j]);
                j++;
                count++;
            }
            if(count%2==0)
            {
                 if(max_heap.size()>min_heap.size())
            {
                min_heap.push(max_heap.top());
                max_heap.pop();
            } 
                 else if(min_heap.size()>max_heap.size())
            {
                max_heap.push(min_heap.top());
                min_heap.pop();
            }
            }
           
        } 
        }
       
       if(max_heap.size()==min_heap.size())
       {
           return((max_heap.top()+min_heap.top())/2.0);
       }
        else 
        {
            if(max_heap.size()>min_heap.size())
            return max_heap.top()*1.0;
            else
                return min_heap.top()*1.0;
        }
    }
};