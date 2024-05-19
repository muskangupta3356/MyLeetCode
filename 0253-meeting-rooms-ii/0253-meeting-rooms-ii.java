class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals,
                   new Comparator<int[]>(){
                     public int compare(final int[] a, final int[] b){
                         return a[0]-b[0];
                     }  
                   });
        PriorityQueue<Integer> allocator =  new PriorityQueue<Integer>(intervals.length,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });
        int rooms=1;
    allocator.add(intervals[0][1]); // add finish time
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<allocator.peek()){
                allocator.add(intervals[i][1]) ;//10(start)<30(smallest finish time)
                rooms++;
            }
            else{
                allocator.poll();
                allocator.add(intervals[i][1]); //20(start)>10(smallest finish time) so add 20's finsih time
            }
        }
        return rooms;
            
        }
    }
