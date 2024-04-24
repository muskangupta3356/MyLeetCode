class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] roomAvailabilityTime = new long [n];
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, (a,b)-> a[0] - b[0]);
        for(int [] meeting : meetings)
        {
            int startTime = meeting[0];
            int endTime = meeting[1];
            boolean foundUnusedRoom = false;
            int minAvaialableTimeRoom = 0;
            long minRoomAvailabilityTime = Long.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                if(roomAvailabilityTime[i]<=startTime)
                {
                    meetingCount[i]++;
                    roomAvailabilityTime[i]=endTime;
                    foundUnusedRoom = true;
                    break;
                }
                if(minRoomAvailabilityTime>roomAvailabilityTime[i])
                {
                    minRoomAvailabilityTime = roomAvailabilityTime[i];
                    minAvaialableTimeRoom = i;
                }
            }
            if(foundUnusedRoom == false)
            {
                roomAvailabilityTime[minAvaialableTimeRoom]+=endTime - startTime;
                meetingCount[minAvaialableTimeRoom]++;
            }
        }
        int maxMeetingCount = 0 ,maxMeetingCountRoom = 0;
        for(int i=0;i<n;i++)
        {
            if(meetingCount[i]>maxMeetingCount)
            {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }
        return maxMeetingCountRoom;
        //TC O(MlogM)+ O(M*N)
        //SC O(NlogN)
    }
}