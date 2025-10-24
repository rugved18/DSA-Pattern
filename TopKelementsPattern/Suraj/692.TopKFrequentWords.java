class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String st:words){
            map.put(st,map.getOrDefault(st,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>(
            (a,b)->{
            if(a.getValue().equals(b.getValue()))
            {
            return b.getKey().compareTo(a.getKey());
            }
        return a.getValue()-b.getValue();
            }
        );
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        List<String> result=new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(0,minHeap.poll().getKey());
        }
        return result;
    }
}
