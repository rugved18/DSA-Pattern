import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder stb=new StringBuilder();
        Map.Entry<Character,Integer> prev=null;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> curr=maxHeap.poll();
            stb.append(curr.getKey());
            curr.setValue(curr.getValue()-1);
            if(prev!=null && prev.getValue()>0){
                maxHeap.offer(prev);
            }
            prev = curr;
        }
        if (stb.length()!=s.length()){
            return "";
        }
        return stb.toString();
    } 
    public static void main(String args[]){
	    Solution sto=new Solution();
	    String s1="aab";
	    String s2="aaab";
	    System.out.println("Solution for s1 "+sto.reorganizeString(s1));
	    System.out.println("Solution for s2 "+sto.reorganizeString(s2));

    }
} 

