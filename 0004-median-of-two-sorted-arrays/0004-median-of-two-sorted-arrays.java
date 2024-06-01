class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //creating min priority queue
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        //creating max priority queue
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare (Integer a, Integer b){
                return b - a;
            }
        });
        
      int l1 = nums1.length; int l2 = nums2.length;
        
        if(l1 == 0 && l2 != 0){
            if(l2%2==0)
                return ((nums2[l2/2]+nums2[l2/2-1])/2.0);
            else
                return (nums2[l2/2]);
        }
        if(l1 != 0 && l2 == 0){
            if(l1%2==0)
                return ((nums1[l1/2]+nums1[l1/2-1])/2.0);
            else
                return(nums1[l1/2]);
        }
        int i =1;
        maxPq.add(nums1[0]);
        while(i < l1){
            if(nums1[i] > maxPq.peek()){
                minPq.add(nums1[i]);
            }else{
                maxPq.add(nums1[i]);
            }
            if((maxPq.size() + minPq.size())%2 == 0){
                if(maxPq.size() > minPq.size()){
                    minPq.add(maxPq.poll());
                }else if(maxPq.size() < minPq.size()){
                    maxPq.add(minPq.poll());
                }
            }
            i++;
        }
        
        int j =0;
        while(j < l2){
            if(nums2[j] > maxPq.peek()){
                minPq.add(nums2[j]);
            }else{
                maxPq.add(nums2[j]);
            }
            if((maxPq.size() + minPq.size())%2 == 0){
                if(maxPq.size() > minPq.size()){
                    minPq.add(maxPq.poll());
                }else if(maxPq.size() < minPq.size()){
                    maxPq.add(minPq.poll());
                }
            }
            j++;
        }
        
        if(maxPq.size() > minPq.size()){
            return (maxPq.peek()/1.0);
        }else if(maxPq.size() < minPq.size()){
            return (minPq.peek()/1.0);
        }else{
            return ((maxPq.peek() + minPq.peek())/2.0);
        }
    }
}