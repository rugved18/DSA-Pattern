import java.util.*;
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int n=start.length;
        int[][] meetings=new int[n][2];
        
        for(int i=0;i<n;i++){
            meetings[i][0]=start[i];
            meetings[i][1]=end[i];
        }
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int[] meeting:meetings){
            if(!heap.isEmpty() && heap.peek()<=meeting[0]){
                heap.poll();
            }
            heap.add(meeting[1]);
        }
        return heap.size();
    }
}

