class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> answer = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i= nums2.length-1;i>=0;i--){
            if(st.isEmpty()){
                answer.put(nums2[i],-1);
            }else{
                while(!st.isEmpty() && st.peek() <= nums2[i]){
                    st.pop();
                }
                if(st.isEmpty())
                    answer.put(nums2[i],-1);
                else
                    answer.put(nums2[i],st.peek());
            }
            
            st.push(nums2[i]);
        }
        
        int[] ng = new int [nums1.length];
        for(int i=0;i<nums1.length;i++){
            ng[i] = answer.get(nums1[i]);
        }
        return ng;
    }
}