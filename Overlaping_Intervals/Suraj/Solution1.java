package Overlaping_Intervals.Suraj;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


class Solution1{
    public List<List<Integer>> empFreeTime(List<List<Integer>> empytiming){
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        Set<Integer> freq=new HashSet<>();
        for(List<Integer> l1:empytiming){
        int start=l1.get(0);
        int end=l1.get(1);
        for(int i=start;i<end;i++){
            freq.add(i);
        }
        max=Math.max(max,end);
        min=Math.min(min,start);
        }

        List<List<Integer>> result=new ArrayList<>();
        int freeStart=0;
        boolean found=false;
        int[][] nfreq= (int[][]) freq.toArray();
        for(int i=min;i<max;i++){
            if(!freq.contains(i) && !found) {
                freeStart=1;
                found=true;
            } else if (freq.contains(i) && found) {
                result.add(Arrays.asList(freeStart,i));
                found=false;
            }
        }
        if(found){
            result.add(Arrays.asList(freeStart,max));
        }
        return result;

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 3));
        input.add(Arrays.asList(6, 7));
        input.add(Arrays.asList(2, 4));
        input.add(Arrays.asList(2, 5));
        input.add(Arrays.asList(9, 12));

        System.out.println(s.empFreeTime(input));
        // Expected output: [[5,6], [7,9]]
    }

}
